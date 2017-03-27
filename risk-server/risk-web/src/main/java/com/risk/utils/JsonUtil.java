package com.risk.utils;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhenge.feng.
 */
public class JsonUtil {

    public static String toJsonStr(Object obj) {
        try {
            //modify fastjson
            return JSON.toJSONString(obj);
        } catch (Exception e) {
        }
        return null;
    }
    
}
