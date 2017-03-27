package com.risk.integration.suanhua.request;

/**
 * 算话接口请求基类
 * Created by zhenge.feng.
 */
public class SHBaseRequest {

    private String sorgcode; //算话分配的机构代码

    private String sorgseq;  //机构流水

    private String hash ;    //消息hash值

    public SHBaseRequest() {
    }

    public SHBaseRequest(String sorgcode, String sorgseq, String hash) {
        this.sorgcode = sorgcode;
        this.sorgseq = sorgseq;
        this.hash = hash;
    }

    public String getSorgcode() {
        return sorgcode;
    }

    public void setSorgcode(String sorgcode) {
        this.sorgcode = sorgcode;
    }

    public String getSorgseq() {
        return sorgseq;
    }

    public void setSorgseq(String sorgseq) {
        this.sorgseq = sorgseq;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
