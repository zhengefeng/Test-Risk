package com.common.utils.gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/29.
 */
public class EnumMap {

    //2.23	姓名、身份证号、银行卡、手机号比对 状态
    public static final Map<String, String > statusMap = new HashMap<>();
    //2.1	基本身份信息验证
    public static final Map<String, String> baseIDVerifyMap = new HashMap<>();

    //
    public static final Map<String, String> driverNoStatMap = new HashMap<>();

    public static final Map<String, String> badPersonInfoMap = new HashMap<>();

    static {

        baseIDVerifyMap.put("1", "一致");
        baseIDVerifyMap.put("2", "不一致");
        baseIDVerifyMap.put("3", "无此号码");

        statusMap.put("1", "成功");
        statusMap.put("2", "不一致");
        statusMap.put("3", "系统错误");
        statusMap.put("31", "请求参数错误");
        statusMap.put("5", "不支持；如，银行卡不支持");
        statusMap.put("9", "接口调用失败 ");
        statusMap.put("91", "数据源接口调用失败-产品暂停服务");
        statusMap.put("99", "数据源报未知异常");


        badPersonInfoMap.put("1", "在逃");
        badPersonInfoMap.put("2", "前科");
        badPersonInfoMap.put("3", "在逃和前科");



    }


    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(7));
        System.out.println(r.nextInt(7));
        for(int i=0;i<100;i++){
            System.out.println(r.nextInt(7));
        }
    }


}
