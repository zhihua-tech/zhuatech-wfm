# 企业级排班合规治理

[知华科技（上海如静知华信息科技有限公司）](https://www.zhuatech.cn/)为 WFM 开源版增加班表发布门禁。

`POST /api/enterprise/wfm/schedule-compliance-governance` 检查计划工时、班次间休息、强制休息、持证人员、例外审批、需求覆盖、加班预算和员工偏好，返回 `PUBLISH / REVIEW / BLOCKED`。

法定工时和休息要求应由企业根据员工所在地、劳动合同和集体协议配置；生产系统还应保留排班版本、员工确认和例外审批证据。
