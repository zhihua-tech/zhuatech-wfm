/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.controller;

import cn.zhuatech.wfm.common.ApiResponse;
import cn.zhuatech.wfm.service.StaffingCoverageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wfm/insights")
public class StaffingCoverageController {
    private final StaffingCoverageService service;

    public StaffingCoverageController(StaffingCoverageService service) {
        this.service = service;
    }

    @PostMapping("/staffing-coverage")
    public ApiResponse<StaffingCoverageService.Result> forecast(
        @Valid @RequestBody StaffingCoverageService.Request request) {
        return ApiResponse.ok(service.forecast(request));
    }
}
