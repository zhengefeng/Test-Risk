package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product product);

    int insertSelective(Product product);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product product);

    int updateByPrimaryKey(Product product);

	List<Product> queryProducts(Product product);

	int queryProductsCount(Product product);

	List<Product> queryProducts(Product product, RowBounds rowBounds);

    List<Product> queryAllActiveProduct();
}