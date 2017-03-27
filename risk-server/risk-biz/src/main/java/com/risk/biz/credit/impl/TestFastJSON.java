package com.risk.biz.credit.impl;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by zhenge.feng.
 */
public class TestFastJSON {
    public static void main(String[] args) {
        String data = "{\"status\":\"2\",\"data\":{\"ktgg\":0,\"totalNum\":0,\"ajlc\":0,\"wdhmd\":0,\"cpws\":0,\"zxgg\":0,\"fygg\":0,\"sxgg\":0},\"success\":true}";

        String string = ReturnDataTest.zhiYeZiGe();
        Map resultMap = JSON.parseObject(string, Map.class);
        Map datamap = (Map)resultMap.get("data");
        Set<String> keySet = datamap.keySet();
        //有了Set集合就可以获取其迭代器，取值
        Iterator<String> it = keySet.iterator();
        int iNum = 0;
        while (it.hasNext())
        {
            String i = it.next();
            List list = JSON.parseObject(String.valueOf(datamap.get(i)),List.class);
            if(list.size()>0){
                iNum++;
            }
        }
        System.out.println(datamap.isEmpty());
        String listResult = JSON.toJSONString( resultMap.get("data"));
        System.out.println(listResult);
    }
}
