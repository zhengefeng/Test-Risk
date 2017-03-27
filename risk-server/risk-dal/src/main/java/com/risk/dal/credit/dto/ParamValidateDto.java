package com.risk.dal.credit.dto;


import java.util.Map;

import java.util.List;

/**
 * Created by zhenge.feng.
 */
public class ParamValidateDto {
    private String respCode;
    private String respMsg;

    private List<Map<String,String>> valiateInfos;

    public ParamValidateDto(String respCode, String respMsg, List<Map<String, String>> valiateInfos) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.valiateInfos = valiateInfos;
    }

    public ParamValidateDto() {

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

    public List<Map<String, String>> getValiateInfos() {
        return valiateInfos;
    }

    public void setValiateInfos(List<Map<String, String>> valiateInfos) {
        this.valiateInfos = valiateInfos;
    }
}
