package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class ErrorMsg {
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    private String errCode;

    public ErrorMsg(String code, String msg)
    {
        this.errCode = code;
        this.errMsg = msg;
    }

    public ErrorMsg(String msg)
    {
        this.errMsg = msg;
    }

    public String toString() {
        return errCode == null ? "" : (errCode + ":") + errMsg;
    }

}
