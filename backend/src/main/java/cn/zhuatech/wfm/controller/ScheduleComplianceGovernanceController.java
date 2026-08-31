/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.controller;

import cn.zhuatech.wfm.common.ApiResponse;
import cn.zhuatech.wfm.service.ScheduleComplianceGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/wfm")
public class ScheduleComplianceGovernanceController {
    private final ScheduleComplianceGovernanceService service;
    public ScheduleComplianceGovernanceController(ScheduleComplianceGovernanceService service) { this.service = service; }

    @PostMapping("/schedule-compliance-governance")
    public ApiResponse<ScheduleComplianceGovernanceService.Assessment> assess(
        @Valid @RequestBody ScheduleComplianceGovernanceService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
