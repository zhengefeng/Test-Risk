package com.risk.dal.exception;

/**
 * 业务异常
 * Created by zhenge.feng.
 */
public class BizException extends RuntimeException {

    private String respCode;
    private String respMsg;


    public BizException(String respMsg, String respCode) {
        super(respMsg);
        this.respMsg=respMsg;
        this.respCode=respCode;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

}
