package com.risk.dal.enums;

/**
 * 接口提供商
 * Created by zhenge.feng.
 */
public enum ProviderEnum {

    SUANHUA(1001,"算话"),
    ZHIMA(1002,"芝麻信用"),
    QIANZHI(1003,"前知数据");

    private Integer code;
    private String name;

    ProviderEnum(Integer code, String name) {
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
