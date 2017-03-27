package com.risk.integration.suanhua.response;

/**
 * 算话2000响应结果
 * Created by zhenge.feng.
 */
public class SHResp2000 extends SHBaseResponse {

    private String result;//验证结果： 1一致，2不一致，3无此号码

    public SHResp2000(boolean success, String errors, String result) {
        super(success, errors);
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
