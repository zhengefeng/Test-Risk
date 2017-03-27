package com.risk.dal.credit.dao;

import com.risk.dal.credit.entity.Product;
import com.risk.dal.credit.mapper.ProductMapper;
import com.risk.dal.enums.ProviderEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhenge.feng.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProductMapperTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testQueryOne() throws Exception{
        Product product =
        productMapper.selectByPrimaryKey(58);

        System.out.println(product);


    }

    @Test
    public void testInsert() throws Exception{
        Product product = new Product();
        product.setName("基本身份信息验证");
        product.setProvidercode(ProviderEnum.SUANHUA.getCode());
        product.setMarketprice(new BigDecimal(1.22));
        product.setFeetype((short) 1);
        product.setStatus((short)1);
        product.setSpecialprice(new BigDecimal(1.11));
        product.setCreatetime(new Date());
        product.setOpername("fengzhenge");

        productMapper.insert(product);
        System.out.println("--------");

    }

}
