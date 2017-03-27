
/**init company**/
INSERT INTO r_company(id, companyName, STATUS, operName, createTime, updateTime)
VALUES
(1, '上海欣亨', 1, 'sys', SYSDATE(), SYSDATE()),
(2, '江苏悦达', 1, 'sys', SYSDATE(), SYSDATE());


/** init user **/
INSERT INTO r_consumer(companyId, loginName, NAME, PASSWORD, rankLevel, STATUS,operName, updateTime, createTime)
VALUES
 (1, 'admin', '欣亨管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', 1, 'sys', SYSDATE(), SYSDATE()),
 (1, 'normalUser', '欣亨普通用户', 'e10adc3949ba59abbe56e057f20f883e', '2', 1, 'sys', SYSDATE(), SYSDATE()),
 (2, 'admin', '悦达管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', 1, 'sys', SYSDATE(), SYSDATE()),
 (2, 'normalUser', '悦达普通用户', 'e10adc3949ba59abbe56e057f20f883e', '2', 1, 'sys', SYSDATE(), SYSDATE());


 /** init product data**/
 INSERT INTO r_product(id, NAME, marketPrice, costPrice, STATUS, feeType, infoType, description, operName, createTime, updateTime)
 VALUES
 (1, '身份证核实', 2, 1, 1, 1, 1, '提供验证姓名和身份证是否匹配(一致/不一致/库中无此号)', 'sys', SYSDATE(), SYSDATE()),
 (2, '用户信息验证', 0, 0, 2, 1, 1, '提供姓名、手机号、身份证号、银行卡号、设备号等 确定真实性评分', 'sys', SYSDATE(), SYSDATE()),
(3, '银行卡四要素', 2, 1, 1, 1, 1, '提供姓名、身份证号、手机号、银行卡号验证(一致/姓名不一致/身份证不一致/库无)', 'sys', SYSDATE(), SYSDATE()),
(4, '驾驶证状态查询', 7, 3.5, 1, 1, 1, '提供驾驶证号 正常,超分,转出,暂扣,撤销,吊销,注销,违法未处理,事故未处理,停止使用,协查,锁定,逾期未换证,延期换证,延期体检,逾期未体检,逾期未审,扣留,其他', 'sys', SYSDATE(), SYSDATE()),
(5, '行驶证状态查询', 7, 3.5, 1, 1, 1, '提供车牌号、发动机号 状态为正常,转出,被盗抢,停驶,注销,吊销,违法未处理,海关监管,事故未处理,嫌疑车,查封,暂扣,强制注销,事故逃逸,锁定,达到报废标准公告牌证作废,逾期未检验,其他', 'sys', SYSDATE(), SYSDATE()),

(6, '身份证多项信息', 3.6, 1.8, 1, 1, 2, '提供姓名、身份证号 返回性别、民族、出生年月、工作单位、学历等', 'sys', SYSDATE(), SYSDATE()),
(7, '手机号查询', 4, 2, 1, 1, 2, '提供移动手机号 返回机主姓名、号码归属地、号码类型、联系地址', 'sys', SYSDATE(), SYSDATE()),
(8, '固话查询', 4, 2, 1, 1, 2, '提供固话号码 返回机主名称、邮编、所在地区、详细地址', 'sys', SYSDATE(), SYSDATE()),
(9, '学历查询', 4, 2, 1, 1, 2, '提供姓名、身份证 返回学校、学历、专业、入学时间、毕业时间、照片等', 'sys', SYSDATE(), SYSDATE()),
(10, '职业资格信息', 4, 2, 1, 1, 2, '提供姓名、身份证号	返回职业资格证书', 'sys', SYSDATE(), SYSDATE()),
(11, '个人工商法信息查询', 9, 4.5, 1, 1, 2, '提供姓名、身份证号 返回企业股东信息,企业法定代表人信息,企业主要管理人员信息,失信未执行人信息,失信已执行人信息,阿里欠贷信息', 'sys', SYSDATE(), SYSDATE()),

(12, '手机黑名单', 10, 5, 1, 1, 3, '提供手机号 返回机构失联,银行失联,机构逾期期数,银行逾期期数,机构诉讼,银行诉讼,列为黑名单的机构等', 'sys', SYSDATE(), SYSDATE()),
/**(13, '外部-机构A', 0, 0, 2, 1, 3, '提供姓名、身份证号 返回逾期危险分及对应逾期概率', 'sys', SYSDATE(), SYSDATE()),
(14, '外部-机构B', 0, 0, 2, 1, 3, '提供姓名、身份证号 返回黑名单类型、逾期发生时间、违约金额、最长逾期时间', 'sys', SYSDATE(), SYSDATE()),
**/
(15, '涉诉风险（总信息）', 1, 0.5, 1, 1, 3, '提供姓名、身份证号 返回是否命中汇法网的法律名单及详情', 'sys', SYSDATE(), SYSDATE()),
(16, '涉诉风险（摘要）', 7*2*2.8, 2.8, 1, 1, 3, '提供姓名、身份证号 返回是否命中法海网的法律名单及详情 裁判文书摘要,执行公告摘要,失信公告摘要,开庭公告摘要,法院公告摘要,网贷黑名单摘要,案件流程信息摘要', 'sys', SYSDATE(), SYSDATE()),
(17, '涉诉风险（详情）', 7*2*2.8, 2.8, 2, 1, 3, '提供姓名、身份证号 返回裁判文书,执行公告,失信公告,开庭公告,法院公告,网贷黑名单,案件流程信息', 'sys', SYSDATE(), SYSDATE()),
(18, '公安不良信息', 4, 2, 1, 1, 3, '提供姓名、身份证号 返回是否在逃，违法，吸毒', 'sys', SYSDATE(), SYSDATE()),

(19, '银联报告查询', 4, 2, 1, 1, 4, '提供姓名、身份证号、手机号 返回个人消费特征信息', 'sys', SYSDATE(), SYSDATE()),
(20, '信贷报告', 4, 2, 1, 1, 4, '提供姓名、证件类型、证件号码 返回个人信贷信息列表', 'sys', SYSDATE(), SYSDATE());


/** init provider data**/
INSERT INTO r_providerinter(productId, NAME, providerCode, interCode, price, feeType, STATUS, description, updateTime, createTime)
VALUES
(1, '算话', '10000', '/channel/2000', 1, 1, 1, '身份证核实', SYSDATE(), SYSDATE()),
(2, '算话', NULL, NULL, 1, 1, 1, '用户信息验证', SYSDATE(), SYSDATE()),
(3, '算话', '10000', '/channel/1003', 1, 1, 1, '银行卡四要素', SYSDATE(), SYSDATE()),
(4, '算话', '10000', '/channel/A002', 3.5, 1, 1, '驾驶证状态查询', SYSDATE(), SYSDATE()),
(5, '算话', '10000', '/channel/A004', 3.5, 1, 1, '行驶证状态查询', SYSDATE(), SYSDATE()),

(6, '算话', '10000', '/channel/2001', 1.8, 1, 1, '身份证多项信息', SYSDATE(), SYSDATE()),
(7, '算话', '10000', '/channel/3005', 2, 2, 1, '手机号查询', SYSDATE(), SYSDATE()),
(8, '算话', '10000', '/channel/3004', 2, 1, 1, '固话查询', SYSDATE(), SYSDATE()),
(9, '算话', '10000', '/channel/3001', 2, 1, 1, '学历查询', SYSDATE(), SYSDATE()),
(10, '算话', '10000', '/channel/3003', 2, 1, 1, '职业资格信息', SYSDATE(), SYSDATE()),
(11, '算话', '10000', '/channel/4001', 4.5, 1, 1, '个人工商法信息查询', SYSDATE(), SYSDATE()),

(12, '算话', '10000', '/channel/8002', 0, 1, 1, '欣亨黑名单', SYSDATE(), SYSDATE()),
/**
(13, '算话', NULL, NULL, 1, 1, 1, '外部-机构A', SYSDATE(), SYSDATE()),
(14, '算话', NULL, NULL, 1, 1, 1, '外部-机构B', SYSDATE(), SYSDATE()),
**/
(15, '算话', '10000', '/channel/6001', 0.5, 1, 1, '外部-汇法网', SYSDATE(), SYSDATE()),
(16, '算话', '10000', '/channel/6002', 2.8, 3, 1, '外部-法海网', SYSDATE(), SYSDATE()),
(17, '算话', '10000', '/channel/6003', 2.8, 4, 1, '外部-黑名单', SYSDATE(), SYSDATE()),
(18, '算话', '10000', '/channel/3007', 2, 1, 1, '公安不良信息', SYSDATE(), SYSDATE()),

(19, '算话', '10000', '5003', 1, 1, 1, '银联报告查询', SYSDATE(), SYSDATE()),
(20, '算话', '10000', '/credit/query', 0, 1, 1, '信贷报告', SYSDATE(), SYSDATE());

/**init interparam data**/
INSERT INTO r_interparam VALUES ('1', '58', '/channel/2000', 'name', 'String', '1', '姓名', SYSDATE(), SYSDATE());
INSERT INTO r_interparam VALUES ('2','58','/channel/2000','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES ('3', '63', '/channel/2001', 'name', 'String', '1', '姓名', SYSDATE(), SYSDATE());
INSERT INTO r_interparam VALUES ('4','63','/channel/2001','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES ('5', '66', '/channel/3001', 'name', 'String', '1', '姓名', SYSDATE(), SYSDATE());
INSERT INTO r_interparam VALUES ('6','66','/channel/3001','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES ('7', '60', '/channel/1003', 'name', 'String', '1', '姓名', SYSDATE(), SYSDATE());
INSERT INTO r_interparam VALUES('8','60','/channel/1003','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('9','60','/channel/1003','cardNum','String','1','卡号',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('10','60','/channel/1003','mobileNum','String','1','手机号',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('11','61','/channel/A002','drivingNo','String','1','驾驶证号',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('12','62','/channel/A004','carNo','String','1','车牌号',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('13','62','/channel/A004','engineNo','String','1','发动机号(二选一)',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('14','62','/channel/A004','carType','String','1','号牌种类(二选一)',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('15','64','/channel/3005','name','String','1','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('16','64','/channel/3005','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('17','64','/channel/3005','mobileNum','String','1','手机号',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('18','65','/channel/3004','name','String','1','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('19','65','/channel/3004','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('20','65','/channel/3004','telephone','String','1','固定电话',SYSDATE(),SYSDATE());


INSERT INTO r_interparam VALUES('21','66','/channel/3001','name','String','1','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('22','66','/channel/3001','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('23','67','/channel/3003','name','String','1','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('24','67','/channel/3003','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('25','68','/channel/4001','name','String','1','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('26','68','/channel/4001','idCard','String','1','身份证号码',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('27','68','/channel/4001','keyType','String','1','gd个人股权投资信息;个人担任法定代表人信息;gl个人担任高管信息',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('28','69','/channel/8002','mobileNum','String','1','手机号',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('29','69','/channel/8002','imsi','String','2','Sim卡序列号',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('30','69','/channel/8002','imei','String','2','手机设备号',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('31','70','/channel/6001','name','String','2','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('32','70','/channel/6001','idCard','String','2','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('33','71','/channel/6002','name','String','2','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('34','71','/channel/6002','idCard','String','2','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('35','72','/channel/6003','name','String','2','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('36','72','/channel/6003','idCard','String','2','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('37','73','/channel/3007','name','String','2','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('38','73','/channel/3007','idCard','String','2','身份证号码',SYSDATE(),SYSDATE());

INSERT INTO r_interparam VALUES('39','72','/channel/6003','name','String','2','姓名',SYSDATE(),SYSDATE());
INSERT INTO r_interparam VALUES('40','72','/channel/6003','idCard','String','2','身份证号码',SYSDATE(),SYSDATE());

/**init templateinter data**/
INSERT INTO r_templateinter VALUES ('1', '1', '1', '1', '1', 'sys', SYSDATE());
INSERT INTO r_templateinter VALUES ('2', '1', '6', '1', '2', 'sys', SYSDATE());
INSERT INTO r_templateinter VALUES ('3', '1', '9', '1', '3', 'sys', SYSDATE());