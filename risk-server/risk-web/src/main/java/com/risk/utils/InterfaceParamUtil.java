package com.risk.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口参数视图
 * Created by zhenge.feng.
 */
public class InterfaceParamUtil {

    private static Map<String,List<String>> params = new HashMap<String,List<String>>();

    /**
     * 数据库查询记录,调用addParams方法
     * @param id
     * @param list
     */
    public static void addParams(String id,List<String> list){
        params.put(id, list);
    }

    /**
     * 根据接口id获取接口参数
     * @param id
     * @return
     */
    public static List<String> getParams(String id){
        return params.get(id);
    }


}
