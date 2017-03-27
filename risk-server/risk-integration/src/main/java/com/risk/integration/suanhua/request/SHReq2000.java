package com.risk.integration.suanhua.request;

/**
 * 算话2000请求参数
 * Created by zhenge.feng.
 */
public class SHReq2000 extends SHBaseRequest{


    private String name;    //姓名

    private String idCard;  //身份证号码

    public SHReq2000(String sorgcode, String sorgseq, String hash) {
        super(sorgcode, sorgseq, hash);
    }

    public SHReq2000(String sorgcode, String sorgseq, String hash, String name, String idCard) {
        super(sorgcode, sorgseq, hash);
        this.name = name;
        this.idCard = idCard;
    }

    public SHReq2000() {

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
