package com.common.utils.gate.resp;

import com.common.utils.gate.base.BaseResp;

/**
 * Created by Administrator on 2016/8/29.
 */
public class IDVerificationResp extends BaseResp {

    /**
     * 验证结果：
         1一致，
         2不一致，
         3无此号码
     */
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
