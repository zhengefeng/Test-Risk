package com.risk.pricehandler;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by zhenge.feng.
 */
public class PriceHandler {
    public double countPrice(List<PriceRule> list, JSON json){
        double price = 0.0;

        for(PriceRule priceRule:list){
            //1查询  2查得
            if("1".equals(priceRule.getQueryType())){
                price += priceRule.getPrice();
            }else if("2".equals(priceRule.getQueryType())){
                //1按count统计  2按sum统计
                if("1".equals(priceRule.getStaticType())){
                    price += priceRule.getPrice();
                }else if("2".equals(priceRule.getStaticType())){
                    int size = 0;
                    int sum = 0;
                    price += priceRule.getPrice()*sum;
                }
            }
        }
        return price;
    }
}
