package com.risk.dal.credit.mapper;

import com.alibaba.fastjson.JSON;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.entity.InterParam;
import com.risk.dal.credit.entity.Product;
import com.risk.dal.credit.entity.ProviderInter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhenge.feng.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ReportMapperTest {

    @Autowired
    private ReportMapper reportMapper;

    @Test
    public void testGetTemplateParams() throws Exception {
        Integer templateId = 1;
        List<InterParam> interParams = reportMapper.getTemplateParams(templateId);
        System.out.println(JSON.toJSON(interParams));

    }

    @Test
    public void testGetProviderInters() throws Exception {
        Integer integer = 1;
        List<ProviderInter> providerInters = reportMapper.getProviderInters(integer);
        System.out.println(JSON.toJSON(providerInters));

    }

    @Test
    public void testGetInterParamsByPid() throws Exception {
        Integer providerId = 58;
        List<InterParam> interParams = reportMapper.getInterParamsByPid(providerId);
        System.out.println(JSON.toJSON(interParams));

    }

    @Test
    public void testGetProducts() throws Exception {
        Integer templateId = 1;
        List<Product> products = reportMapper.getProducts(templateId);
        System.out.println(JSON.toJSON(products));

    }

    @Test
    public void testGetConsumerByLoginName() throws Exception {
        String loginName = "yuedaUser1";
        Consumer consumer = reportMapper.getConsumerByLoginName(loginName);
        System.out.println(JSON.toJSON(consumer));
    }

    @Test
    public void testGetProductByPIid() throws Exception {
        Integer providerInterId = 58;
        Product product = reportMapper.getProductByPIid(providerInterId);
        System.out.println(JSON.toJSON(product));

    }
}