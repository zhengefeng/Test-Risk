package com.risk.utils;

import org.springframework.http.HttpRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口处理util
 * Created by zhenge.feng.
 */
public class InterfaceUtil {

    /**
     * 参数ids为模板对应的接口id的集合
     * @param ids
     * @return
     */
    public static List<String> getTemplateParames(List<String> ids){
        List<String> params = new ArrayList<String>();
        for(String id:ids){
            for(String param: InterfaceParamUtil.getParams(id)){
                if(params.contains(param)){
                    continue;
                }
                params.add(param);
            }
        }
        return params;
    }

    /**
     * 生成json格式string 返回前端页面
     * @param id
     * @param request
     * @return
     */
    public static String createRequestJson(String id,HttpRequest request){
        String result = "";
        //JsonObject json = new JsonObject();
        Map<String,String> map = new HashMap<String,String>();
        for(String param: InterfaceParamUtil.getParams(id)){
            //map.put(param, request.getParamter(param));
        }
        //json = Json.toJson(map);
        return result;
    }

}
