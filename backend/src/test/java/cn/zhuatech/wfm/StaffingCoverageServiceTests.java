/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm;

import cn.zhuatech.wfm.service.StaffingCoverageService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class StaffingCoverageServiceTests {
    private final StaffingCoverageService service = new StaffingCoverageService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void identifiesUnderstaffedServiceInterval() {
        var result = service.forecast(new StaffingCoverageService.Request(
            "MON-AM", 120, 6, 480, .20, .85, 2));

        assertEquals(12, result.workloadHours());
        assertEquals(3, result.requiredAgents());
        assertEquals(-1, result.staffingGap());
        assertEquals("UNDERSTAFFED", result.status());
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void recognizesCoveredInterval() {
        var result = service.forecast(new StaffingCoverageService.Request(
            "MON-PM", 60, 5, 480, .15, .80, 3));

        assertEquals("COVERED", result.status());
    }
}
