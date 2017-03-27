package com.risk.integration.suanhua.response;

/**
 * 算话响应基类
 * Created by zhenge.feng.
 */
public class SHBaseResponse {

    private boolean success;//接口调用结果。true：调用成功  false：调用失败

    private String errors ; //错误信息

    public SHBaseResponse(boolean success, String errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
