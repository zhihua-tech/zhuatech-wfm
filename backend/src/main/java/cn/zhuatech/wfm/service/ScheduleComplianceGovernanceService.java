/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class ScheduleComplianceGovernanceService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (request.plannedHours() > request.legalMaximumHours()) blockers.add("计划工时超过适用的法定上限");
        if (request.restHoursBeforeShift() < request.minimumRestHours()) blockers.add("班次间连续休息时间不足");
        if (!request.mandatoryBreaksPlanned()) blockers.add("强制休息时段未排入计划");
        if (request.requiredCertifiedWorkers() > request.scheduledCertifiedWorkers()) blockers.add("持证人员覆盖不足");
        if (request.approvedExceptionRequired() && !request.exceptionApproved()) blockers.add("排班例外未经批准");
        if (!blockers.isEmpty()) {
            actions.add("禁止发布班表，调整工时、休息、资质和例外审批");
            return new Assessment(Decision.BLOCKED, false, blockers, actions);
        }
        if (request.demandCoveragePercent() < 95 || request.overtimeCostCents() > request.overtimeBudgetCents()
            || !request.employeePreferenceReviewed()) {
            if (request.demandCoveragePercent() < 95) actions.add("补充跨技能或弹性班次以达到 95% 需求覆盖");
            if (request.overtimeCostCents() > request.overtimeBudgetCents()) actions.add("复核超时预算或调整人员组合");
            if (!request.employeePreferenceReviewed()) actions.add("完成员工可用性与偏好复核");
            return new Assessment(Decision.REVIEW, false, blockers, actions);
        }
        actions.add("发布班表并冻结合规、资质、成本和需求快照");
        return new Assessment(Decision.PUBLISH, true, blockers, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String scheduleId, @Min(0) double plannedHours,
                          @Min(1) double legalMaximumHours, @Min(0) double restHoursBeforeShift,
                          @Min(0) double minimumRestHours, boolean mandatoryBreaksPlanned,
                          @Min(0) int requiredCertifiedWorkers,
                          @Min(0) int scheduledCertifiedWorkers,
                          boolean approvedExceptionRequired, boolean exceptionApproved,
                          @Min(0) @Max(100) int demandCoveragePercent,
                          @Min(0) long overtimeCostCents, @Min(0) long overtimeBudgetCents,
                          boolean employeePreferenceReviewed) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Assessment(Decision decision, boolean publishable, List<String> blockers,
                             List<String> actions) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Decision { PUBLISH, REVIEW, BLOCKED }
}
