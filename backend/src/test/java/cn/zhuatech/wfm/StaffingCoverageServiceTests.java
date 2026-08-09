/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.wfm;

import cn.zhuatech.wfm.service.StaffingCoverageService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaffingCoverageServiceTests {
    private final StaffingCoverageService service = new StaffingCoverageService();

    @Test
    void identifiesUnderstaffedServiceInterval() {
        var result = service.forecast(new StaffingCoverageService.Request(
            "MON-AM", 120, 6, 480, .20, .85, 2));

        assertEquals(12, result.workloadHours());
        assertEquals(3, result.requiredAgents());
        assertEquals(-1, result.staffingGap());
        assertEquals("UNDERSTAFFED", result.status());
    }

    @Test
    void recognizesCoveredInterval() {
        var result = service.forecast(new StaffingCoverageService.Request(
            "MON-PM", 60, 5, 480, .15, .80, 3));

        assertEquals("COVERED", result.status());
    }
}
