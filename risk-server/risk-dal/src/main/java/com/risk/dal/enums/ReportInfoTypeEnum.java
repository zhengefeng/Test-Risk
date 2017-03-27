package com.risk.dal.enums;

/**
 * 报告信息类别 及 接口名称
 * Created by zhenge.feng.
 */
public enum ReportInfoTypeEnum {

    AUTHENTICATION(2001,"身份验证信息"),
        BASEINFO(200101,"基本信息"),
        MOREINFO(200102,"多项身份信息"),
    SUANHUASHAREPERSONINFO(2002,"算话共享个人身份信息"),
    UNCERTAINTYRISKINFO(2003,"疑似风险信息"),
        UNCERTAINTYRISK(200301,"涉诉风险"),
        BADNESSINFO(200302,"不良信息"),
    CREDITDEBTSUMMARY(2004,"授信及负债信息概要"),
        INFOMATION(200401,"信息概要"),
        CREDITINFO(200402,"信贷信息"),
        FOREIGNASSURANCEINFO(200403,"对外担保信息"),
        ABNORMITYINFO(200404,"异常交易信息"),
    PROFESSIONINFO(2005,"职业信息"),
        PERSONSTOCKINVESTMENT(200501,"个人股权投资信息"),
        LEGALPERSONINFO(200502,"个人担任法定代表人信息"),
        TOPMANAGER(200503,"个人担任高管信息"),
        WORKUNITEXPERIENCE(200504,"工作单位经历"),
    EDUCATIONINFO(2006,"学历/职业资格信息"),
        EDUCATION(200601,"学历信息"),
        QUALIFICATIONINFO(200602,"职业资格信息"),
    CONNECTIONINFO(2007,"联系信息"),
        REGISTER(200701,"户籍信息"),
        COMMUNICATION(200702,"通讯地址"),
        LIVEADDRESS(200703,"居住地址"),
        FIXEDPHONE(200704,"固定电话"),
        PHONE(200705,"手机号码"),
        OTHERCONTACTINFO(200706,"其它信息"),
    PERSONVALUEASSESS(2008,"乘机人价值评估"),
    COMMUNICATIONINFO(2009,"运营商信息"),
        FIXEDPHONEINFOQUERY(200901,"固话信息查询"),
        MOBILEDATA(200902,"移动通讯数据"),
    PERSONCONSUMEANALYSIS(2010,"个人消费行为分析"),
        PERSONCONSUMEINFO(201001,"个人消费特征信息"),
    MERCHANTBUSINESSANALYSIS(2011,"商户经营交易分析"),
        MERCHANTTRADEINFO(201101,"商户交易特征信息"),
    PHONEACTIONDATAANALYSIS(2012,"手机行为数据分析"),
        OVERDUEINFO(201201,"逾期信息"),
        BLACKLISTINFO(201202,"黑名单信息"),
    HOUSEPRICE(2013,"房价信息"),
    DRIVERSTATUSQUERY(2014,"驾驶证/行驶证状态查询"),
        LICENCESTATUS(201401,"驾驶证状态查询"),
        LIVINGLICENSE(201402,"行驶证状态查询"),
    DISSENTEXPLAIN(2015,"异议说明"),
    INFORMATIONCOMPARISON(2016,"信息对比"),
        PERSONINFOCOMPARISON(201601,"身份信息对比"),
        CARDINFOCOMPARISON(201602,"银行卡信息对比"),
        LICENCECOMPARISON(201603,"驾驶证信息对比"),
        LIVEINGLICENSECOMPARISON(201604,"行驶证信息对比");


    private Integer code;
    private String name;

    ReportInfoTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
