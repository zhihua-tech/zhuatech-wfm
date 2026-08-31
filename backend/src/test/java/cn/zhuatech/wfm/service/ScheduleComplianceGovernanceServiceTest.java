/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ScheduleComplianceGovernanceServiceTest {
    private final ScheduleComplianceGovernanceService service = new ScheduleComplianceGovernanceService();

    @Test void publishesCompliantCoveredSchedule() {
        var result = service.assess(new ScheduleComplianceGovernanceService.Request(
            "SCH-001", 8, 8, 12, 11, true, 2, 3, false, false, 100, 10000, 20000, true));
        assertThat(result.decision()).isEqualTo(ScheduleComplianceGovernanceService.Decision.PUBLISH);
        assertThat(result.publishable()).isTrue();
    }

    @Test void blocksLaborAndQualificationViolations() {
        var result = service.assess(new ScheduleComplianceGovernanceService.Request(
            "SCH-002", 12, 8, 6, 11, false, 4, 1, true, false, 100, 10000, 20000, true));
        assertThat(result.decision()).isEqualTo(ScheduleComplianceGovernanceService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(5);
    }

    @Test void reviewsCoverageCostAndPreferenceGaps() {
        var result = service.assess(new ScheduleComplianceGovernanceService.Request(
            "SCH-003", 8, 8, 12, 11, true, 2, 2, false, false, 80, 30000, 20000, false));
        assertThat(result.decision()).isEqualTo(ScheduleComplianceGovernanceService.Decision.REVIEW);
        assertThat(result.actions()).hasSize(3);
    }
}
