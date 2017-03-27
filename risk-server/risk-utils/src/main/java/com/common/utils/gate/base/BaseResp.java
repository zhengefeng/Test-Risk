package com.common.utils.gate.base;

/**
 * Created by Administrator on 2016/8/29.
 */
public class BaseResp {

    /**
     * true：调用成功
     * false：调用失败
     */
    private Boolean success;
    //错误信息
    private String errors;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
