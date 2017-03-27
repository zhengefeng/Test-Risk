package com.risk.integration.suanhua.response;

/**
 * 算话2003响应结果
 * Created by zhenge.feng.
 */
public class SHResp2003 extends SHBaseResponse {

    private String result;//验证结果： 1一致，2不一致，3无此号码

    private String photo; //公安部带网文照片，Base64

    public SHResp2003(boolean success, String errors, String result, String photo) {
        super(success, errors);
        this.result = result;
        this.photo = photo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
