package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.ProductCallDetail;

public interface ProductCallDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCallDetail record);

    int insertSelective(ProductCallDetail record);

    ProductCallDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCallDetail record);

    int updateByPrimaryKey(ProductCallDetail record);

	List<ProductCallDetail> queryProductCallDetails(ProductCallDetail productCallDetail);

	int queryProductCallDetailsCount(ProductCallDetail param);

	List<ProductCallDetail> queryProductCallDetails(ProductCallDetail param, RowBounds rowBounds);
}