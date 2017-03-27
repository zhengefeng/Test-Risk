package com.risk.dal.enums;

/**
 * 返回状态字典
 * Created by zhenge.feng.
 */
public enum ReturnStatusEnum {
    SUCCESS(1,"成功"),
    QUERYERROR(2,"查询接口：查询失败,比对接口：不一致"),
    ERROR(3,"系统错误"),
    PARAMSERROR(31,"请求参数错误"),
    NOSUPPORT(5,"不支持，如银行卡不支持"),
    INVOKEFAILURE(9,"接口调用失败"),
    INVOKERFAILUREV2(91,"数据源接口调用失败-产品暂停服务"),
    UNKNOWN(99,"数据源报未知异常");

    private Integer code;
    private String name;

    ReturnStatusEnum(Integer code, String name) {
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
