package com.risk.dto;

import com.common.utils.constant.RiskConstants;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/24.
 */
public class AjaxCommonResp implements Serializable {

    private String code = RiskConstants.SUCCESS;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
