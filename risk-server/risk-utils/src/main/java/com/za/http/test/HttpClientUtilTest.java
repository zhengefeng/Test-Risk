package com.za.http.test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengzhenge on 2016/12/19.
 */
public class HttpClientUtilTest {
    public static void main(String[] args) throws Exception {
        //调用接口  MessageSendService.sendWeChat(String weChatInfo)
        Map<Object, Object> postData = new HashMap<Object, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", "weixinhao");  // 微信号
        params.put("userNo", "XXno");
        //直接发送内容
        params.put("content", "我在众安进行测试");
        Object[] obj = new Object[]{params};
        Object[] type = new Object[]{"java.lang.String"};
        postData.put("ArgsObjects", JSONObject.toJSONString(obj));
        postData.put("ArgsTypes", JSONObject.toJSONString(type));

        String response =
                HttpClientUtil.doRequest("http://10.253.2.232:12220/com.zhongan.pigeon.service.MessageSendService:1.0.0/sendWeChat", postData,null, "utf-8");
        System.out.println(response);

    }

}
