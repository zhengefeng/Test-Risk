package com.risk.integration.suanhua.request;

/**
 * 算话2003请求参数
 * Created by zhenge.feng.
 */
public class SHReq2003 extends SHBaseRequest {

    private String name;    //姓名

    private String idCard;  //身份证号码

    public SHReq2003(String sorgcode, String sorgseq, String hash, String name, String idCard) {
        super(sorgcode, sorgseq, hash);
        this.name = name;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
