package com.common.utils.price;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 调用成功后，计算每个接口调用的价格
 * Created by zhenge.feng.
 */
public class PriceHandler {

    public static BigDecimal countPrice(BigDecimal perPrice,Map returnMap,Integer feeType){
        BigDecimal price = BigDecimal.valueOf(0.00);
        if("1".equals(feeType) || "2".equals(feeType)){
            price = perPrice;
        }else if("3".equals(feeType) || "4".equals(feeType)){
            Set<String> keySet = returnMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            int iNum = 0;
            while (iterator.hasNext()){
                String string = iterator.next();
                List list = JSON.parseObject(String.valueOf(returnMap.get(string)),List.class);
                if(list.size()>0){
                    iNum++;
                }
            }
            return price.multiply(BigDecimal.valueOf(iNum));
        }else if("5".equals(feeType)){
            Set<String> keySet = returnMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            int iNum = 0;
            while (iterator.hasNext()){
                String string = iterator.next();
                List list = JSON.parseObject(String.valueOf(returnMap.get(string)),List.class);
                if(list.size()>0){
                    iNum = list.size();
                }
            }
            return price.multiply(BigDecimal.valueOf(iNum));
        }
        return  price;
    }

}
