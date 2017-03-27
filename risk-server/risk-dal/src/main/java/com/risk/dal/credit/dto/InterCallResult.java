package com.risk.dal.credit.dto;

/**
 * 封装json结果 所有ajax请求返回类型
 * Created by zhenge.feng.
 */
public class InterCallResult<T> {

    private boolean success;

    private T data;

    private String error;

    public InterCallResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public InterCallResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
