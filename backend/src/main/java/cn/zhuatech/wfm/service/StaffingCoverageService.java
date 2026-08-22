/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffingCoverageService {
    public Result forecast(Request request) {
        double workloadHours = request.forecastDemand() * request.averageHandleMinutes() / 60D;
        double productiveHoursPerAgent = request.intervalMinutes() / 60D
            * request.targetOccupancy() * (1 - request.shrinkageRate());
        int requiredAgents = (int) Math.ceil(workloadHours / productiveHoursPerAgent);
        int staffingGap = request.scheduledAgents() - requiredAgents;
        String status = staffingGap < 0 ? "UNDERSTAFFED" : staffingGap <= 1 ? "TIGHT" : "COVERED";
        List<String> actions = new ArrayList<>();
        if (staffingGap < 0) actions.add("补充 " + Math.abs(staffingGap) + " 名人员或安排跨技能支援");
        if (request.shrinkageRate() >= .25) actions.add("错开培训、会议和休息时间以降低收缩率");
        if ("COVERED".equals(status)) actions.add("保持排班并设置实时需求偏差监控");
        return new Result(request.intervalCode(), round(workloadHours), round(productiveHoursPerAgent),
            requiredAgents, request.scheduledAgents(), staffingGap, status, actions);
    }

    private double round(double value) {
        return Math.round(value * 100D) / 100D;
    }

    public record Request(@NotBlank String intervalCode, @Min(0) int forecastDemand,
                          @DecimalMin("0.1") double averageHandleMinutes,
                          @Min(1) int intervalMinutes,
                          @DecimalMin("0") @DecimalMax("0.95") double shrinkageRate,
                          @DecimalMin("0.1") @DecimalMax("1") double targetOccupancy,
                          @Min(0) int scheduledAgents) {}

    public record Result(String intervalCode, double workloadHours,
                         double productiveHoursPerAgent, int requiredAgents,
                         int scheduledAgents, int staffingGap, String status,
                         List<String> actions) {}
}
