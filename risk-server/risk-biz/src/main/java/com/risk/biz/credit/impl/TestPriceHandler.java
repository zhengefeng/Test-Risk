package com.risk.biz.credit.impl;

import com.alibaba.fastjson.JSON;
import com.common.utils.price.PriceHandler;
import java.util.Map;
import java.math.BigDecimal;

/**
 * Created by zhenge.feng.
 */
public class TestPriceHandler {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(22.0);
        Integer feeType = 5;
        //String ss = ReturnDataTest.zhiYeZiGe();
        //String ss = ReturnDataTest.morePersonInfo();
        String ss = ReturnDataTest.sheSuFengxianZhaiYao();

        Map  map = JSON.parseObject(ss,Map.class);
        BigDecimal bigDecimal1 = PriceHandler.countPrice(bigDecimal,map,feeType);
        System.out.println(bigDecimal1);
    }
}
