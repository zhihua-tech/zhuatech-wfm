/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain={
 code:'WFM',systemName:'劳动力管理平台',englishName:'WORKFORCE MANAGEMENT',theme:{primary:'#3b5f84',dark:'#27394d',accent:'#bb7939'},
 workspace:'运营管理中心 / 劳动力计划',fieldWorkspace:'华东客服中心',period:'2026-08-01 · 周六',liveText:'排班覆盖率于 09:52 更新',fieldContextLabel:'当前班组',fieldContext:'华东一线 · 早班',fieldUser:'江澄',fieldRole:'现场主管',adminUser:'许宁',adminRole:'劳动力计划经理',
 adminTitle:'全渠道劳动力运营中心',adminBreadcrumb:'人力运营 / 今日态势',adminSubtitle:'统一查看需求预测、排班覆盖、实时遵从、技能供给与服务水平。',exportAction:'导出运营日报',createAction:'发布排班方案',
 chartTitle:'需求与到岗覆盖趋势',chartSubtitle:'半小时需求人数 / 实际到岗人数',chartLabels:['08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00'],loadTitle:'业务队列负荷',loadSubtitle:'已分配工作量占可用产能',recordsTitle:'今日重点班次',recordsSubtitle:'按服务风险与缺口人数排序',issueTitle:'实时运营预警',issueSubtitle:'需要现场主管立即协调的事项',
 recordName:'班次任务',itemName:'业务队列',unitName:'运营班组',batchName:'班次',planName:'需求人数',doneName:'到岗人数',exceptionName:'缺口人数',unitLabel:'人',
 listBreadcrumb:'排班运营 / 班次台账',listSubtitle:'管理需求预测、班次计划、技能匹配、换班申请与出勤确认。',listSummary:[['今日班次','48'],['在岗员工','286'],['待审批换班','9'],['人员缺口','12',true]],tabs:['全部','待确认','执行中','调整中','已结束'],
 fieldBreadcrumb:'现场运营 / 主管工作台',fieldTitle:'华东客服中心早班',fieldSubtitle:'当前 6 个业务队列 · 12 人待调配 · 现场主管江澄',fieldSecondary:'查看交接记录',reportAction:'提交现场调整',fieldNoticeTitle:'考勤与业务系统连接正常',fieldNotice:'实时遵从数据延迟低于 2 分钟',
 steps:['需求预测','排班发布','到岗确认','实时调度','班次复盘'],documentAction:'查看排班明细',printAction:'下载签到表',resourceCardTitle:'技能池状态',resourceValueLabel:'可用技能组',resourceHealthLabel:'技能覆盖率',quickSubtitle:'现场劳动力运营快捷入口',quickActions:[['现场调整','/shopfloor/report','调入、调出与休息安排'],['人员调配','/shopfloor/material','跨队列技能调度'],['技能矩阵','/shopfloor/resources','认证、熟练度与到期'],['异常上报','/shopfloor/andon','缺勤、超负荷与系统异常']],
 reportDefaults:[8,2],reportTitle:'现场调度记录',reportSubtitle:'记录调整人数、未解决缺口和调度说明。',reportSuccess:'现场调度已保存并同步至员工工作台',reportPlaceholder:'填写调配原因、涉及队列、员工范围和恢复计划',reportFootnote:'提交后重新计算服务水平预测',ruleTitle:'班次服务目标',ruleSubtitle:'EAST-CS-AM · V6.1',rules:[['目标服务水平','≥ 85%'],['实时遵从','≥ 92%'],['连续工作上限','4 小时'],['排班状态','执行中',true]],fieldTotals:[['286','当前在岗'],['92.8%','实时遵从'],['12','人员缺口'],['86.4%','预测服务水平']],
 adminMenus:[['/admin','home','劳动力驾驶舱'],['/admin/work-orders','order','排班计划'],['/admin/samples','box','员工与技能'],['/admin/schedule','calendar','班次日历'],['/admin/methods','process','预测模型'],['/admin/reviews','quality','换班审批'],['/admin/resources','machine','技能池'],['/admin/report','chart','效能分析']],
 fieldMenus:[['/shopfloor','home','主管工作台'],['/shopfloor/report','report','现场调整'],['/shopfloor/tasks','order','今日班次'],['/shopfloor/material','box','人员调配'],['/shopfloor/resources','machine','技能矩阵'],['/shopfloor/andon','risk','异常上报',3]],
 moduleTitles:{tasks:['今日班次','查看班组、队列、人数和执行状态'],material:['人员调配','管理跨队列借调、休息与加班安排'],resources:['技能矩阵','查看员工认证、熟练度和技能有效期'],andon:['异常上报','登记缺勤、负荷、设施和系统异常'],samples:['员工与技能','维护合同工时、技能标签与可用性'],schedule:['班次日历','协调轮班、休息、假期和活动安排'],methods:['预测模型','配置业务量、处理时长和收缩率'],reviews:['换班审批','处理换班、请假、加班和临时调度'],report:['效能分析','分析服务水平、占用率、遵从和成本']},
 tagline:'让每一份业务需求匹配合适的人员与技能',storyTitle:'从业务量预测到实时调度，<br/>每个班次都兼顾服务与员工体验。',storyText:'连接需求、人员、技能、规则和现场运营的精细化劳动力底座。',pattern:[2,3,7,8,12,13,17,18,22,23,27,28],loginStats:[['92.8%','实时遵从率'],['286','当前在岗'],['86.4%','预测服务水平']],loginTitle:'全渠道劳动力运营中心',adminDemo:'预测 / 排班 / 效能',fieldDemo:'到岗 / 调度 / 异常'
}
export const records=[
 {no:'SHIFT-260801-018',name:'在线咨询早班',code:'QUEUE-CHAT',unit:'华东一线组',group:'华东客服中心',plan:68,done:61,exception:7,due:'08-01',batch:'08:00-16:00',status:'执行中',progress:72,priority:'关注'},
 {no:'SHIFT-260801-021',name:'售后电话午间峰值班',code:'QUEUE-VOICE',unit:'售后二线组',group:'全国服务中心',plan:52,done:50,exception:2,due:'08-01',batch:'10:00-18:00',status:'执行中',progress:66,priority:'正常'},
 {no:'SHIFT-260802-006',name:'企业客户夜间支持班',code:'QUEUE-B2B',unit:'大客户组',group:'企业服务中心',plan:24,done:19,exception:5,due:'08-02',batch:'16:00-24:00',status:'待确认',progress:35,priority:'正常'},
 {no:'SHIFT-260731-015',name:'订单审核晚班',code:'QUEUE-ORDER',unit:'交易运营组',group:'共享运营中心',plan:38,done:38,exception:0,due:'08-01',batch:'14:00-22:00',status:'已结束',progress:100,priority:'正常'},
 {no:'SHIFT-260801-024',name:'活动保障弹性班',code:'QUEUE-CAMPAIGN',unit:'华东一线组',group:'华东客服中心',plan:42,done:31,exception:11,due:'08-01',batch:'12:00-20:00',status:'调整中',progress:58,priority:'加急'}]
export const resources=[{code:'SKILL-CHAT-01',name:'在线咨询技能池',unit:'华东客服中心',status:'可用',health:94,value:'126',valueUnit:'人',note:'高级技能员工 38 人'},{code:'SKILL-VOICE-02',name:'售后电话技能池',unit:'全国服务中心',status:'可用',health:88,value:'96',valueUnit:'人',note:'午间峰值覆盖稳定'},{code:'SKILL-B2B-03',name:'企业客户技能池',unit:'企业服务中心',status:'预警',health:69,value:'31',valueUnit:'人',note:'夜班资深人员缺口 5 人'}]
export const reviews=[{no:'WFM-260801-032',title:'活动保障跨组调配',type:'临时调度',detail:'11 人 · 许宁',result:'待确认'},{no:'WFM-260801-011',title:'售后二线换班申请',type:'员工申请',detail:'4 人 · 江澄',result:'通过'},{no:'WFM-260728-018',title:'夜班技能覆盖复核',type:'排班风险',detail:'缺口 5 人',result:'异常'}]
export const adminMetrics=[['预测服务水平','86.4%','目标 85%','blue'],['实时遵从率','92.8%','较昨日提升 1.4%','green'],['待审批申请','9','3 项临近班次','orange'],['人员缺口','12','集中在 3 个队列','red']]
export const fieldMetrics=[['当前在岗','286','计划 298 人','blue'],['实时遵从','92.8%','目标 92%','green'],['待调配','12','涉及 3 个队列','orange'],['技能覆盖','94%','关键技能正常','slate']]
export const chartActual=[58,64,72,78,75,83,88,91,86],chartTarget=[61,67,74,81,80,85,90,93,89]
export const loads=[['在线咨询队列',91,'当前等待 28 人'],['售后电话队列',84,'当前等待 19 人'],['企业客户队列',76,'6 个高优先级会话'],['订单审核队列',62,'积压 46 个订单']]
export const issues=[{type:'缺勤',title:'华东一线组临时缺勤 7 人',detail:'在线咨询队列 · 需跨组调配',status:'处理中'},{type:'负荷',title:'活动保障队列预计 14:00 超载',detail:'预测缺口 11 人',status:'待调度'},{type:'技能',title:'企业客户夜班高级技能不足',detail:'5 名员工认证即将到期',status:'跟进中'}]
