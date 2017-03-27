package com.risk.dal.enums;

/**
 * 后台op用户类型
 * Created by zhenge.feng.
 */
public enum AdminTypeEnum {

    ADMIN(01,"管理员"),
    COMMON(02,"普通用户");

    private Integer code;

    private String name;

    AdminTypeEnum(Integer code, String name) {
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
