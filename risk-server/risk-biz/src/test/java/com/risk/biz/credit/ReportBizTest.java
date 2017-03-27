package com.risk.biz.credit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.risk.dal.credit.dto.ProductResultDto;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.entity.InterParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zhenge.feng.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ReportBizTest {
    @Autowired
    private ReportBiz reportBiz;

    @Test
    public void testGetTemplateParams() throws Exception {
        String params = reportBiz.getTemplateParams(1);
        System.out.println(params);
    }

    @Test
    public void testInvoke() throws Exception {
        Integer templateId = 1;
        String userId = "yuedaUser1";
        Consumer consumer = new Consumer();
        consumer.setLoginname("yuedaUser1");
        HashMap paramMap = new HashMap();
        paramMap.put("name", "冯振阁");
        paramMap.put("idCard", "411422198705083330");
        System.out.println(JSON.toJSON(paramMap));
        String id = "1";

        List<ProductResultDto> reportMap = reportBiz.invoke(templateId, paramMap, consumer,id);
//        System.out.println(JSON.toJSON(reportMap));

    }

    @Test
    public void testValidateParams() throws Exception {
        Integer templateId = 1;
        HashMap paramMap = new HashMap();
        paramMap.put("name", "11111111111111111111111111111111");
        paramMap.put("idCard", "");
        reportBiz.validateParams(templateId, paramMap);

    }
}