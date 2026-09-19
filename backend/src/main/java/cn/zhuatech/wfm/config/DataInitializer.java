/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.wfm.config;

import cn.zhuatech.wfm.model.*;
import cn.zhuatech.wfm.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Configuration
public class DataInitializer {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Bean
    CommandLineRunner seed(OperatingUnitRepository operatingUnits, WorkRecordRepository orders,
                           ResourceRegisterRepository resources, ReviewRecordRepository reviewRecords,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (operatingUnits.count() > 0) return;
            OperatingUnit primaryUnit = operatingUnits.save(new OperatingUnit("WFM-EAST", "华东一线组", "华东客服中心", 180));
            OperatingUnit secondaryUnit = operatingUnits.save(new OperatingUnit("WFM-SERVICE", "售后二线组", "售后二线组", 120));
            OperatingUnit tertiaryUnit = operatingUnits.save(new OperatingUnit("WFM-B2B", "大客户组", "企业服务中心", 96));

            WorkRecord t1 = orders.save(new WorkRecord("FC-260801-018", "QUEUE-CHAT", "在线咨询早班", tertiaryUnit, 24, 16, 1, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "GW-Q3"));
            WorkRecord t2 = orders.save(new WorkRecord("FC-260801-021", "QUEUE-VOICE", "售后电话午间峰值班", primaryUnit, 18, 8, 0, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "TERM-12"));
            WorkRecord t3 = orders.save(new WorkRecord("BUD-260802-006", "QUEUE-B2B", "企业客户夜间支持班", secondaryUnit, 12, 0, 0, LocalDate.now().plusDays(3), WorkRecord.Status.RELEASED, "SP-2026"));
            WorkRecord t4 = orders.save(new WorkRecord("FC-260728-015", "QUEUE-ORDER", "订单审核晚班", primaryUnit, 20, 20, 1, LocalDate.now(), WorkRecord.Status.COMPLETED, "SEA-09"));

            resources.saveAll(List.of(
                new ResourceRegister("CAT-HPLC-03", "在线咨询技能池", primaryUnit, ResourceRegister.Status.RUNNING, 88),
                new ResourceRegister("CAT-ICP-02", "售后电话技能池", primaryUnit, ResourceRegister.Status.IDLE, 76),
                new ResourceRegister("CAT-UTM-05", "企业客户技能池", tertiaryUnit, ResourceRegister.Status.RUNNING, 91),
                new ResourceRegister("CAT-INC-08", "现场调度模型", secondaryUnit, ResourceRegister.Status.ALARM, 62)
            ));
            reviewRecords.saveAll(List.of(
                new ReviewRecord("ISS-260801-032", t1, "排班需求复核", 6, 0, ReviewRecord.Result.PASSED, "许宁"),
                new ReviewRecord("ISS-260801-011", t2, "需求模型校验", 3, 0, ReviewRecord.Result.PASSED, "江澄"),
                new ReviewRecord("ISS-260801-018", t4, "班次关闭复核", 5, 1, ReviewRecord.Result.FAILED, "许宁"),
                new ReviewRecord("ISS-260802-003", t3, "班次需求确认", 4, 0, ReviewRecord.Result.PENDING, "江澄")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "江澄", UserAccount.Role.DOMAIN_USER, "WFM-EAST"),
                new UserAccount("planner", demo, "许宁", UserAccount.Role.DOMAIN_OPERATOR, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
