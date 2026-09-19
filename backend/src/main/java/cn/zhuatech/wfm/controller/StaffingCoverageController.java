/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.controller;

import cn.zhuatech.wfm.common.ApiResponse;
import cn.zhuatech.wfm.service.StaffingCoverageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/wfm/insights")
public class StaffingCoverageController {
    private final StaffingCoverageService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public StaffingCoverageController(StaffingCoverageService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/staffing-coverage")
    public ApiResponse<StaffingCoverageService.Result> forecast(
        @Valid @RequestBody StaffingCoverageService.Request request) {
        return ApiResponse.ok(service.forecast(request));
    }
}
