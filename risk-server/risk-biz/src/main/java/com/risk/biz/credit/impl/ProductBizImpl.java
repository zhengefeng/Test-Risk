package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.ProductBiz;
import com.risk.dal.credit.entity.Product;
import com.risk.dal.credit.mapper.ProductMapper;

@Service("productBiz")
public class ProductBizImpl implements ProductBiz {
	
	@Autowired
	private ProductMapper productMapper;


	@Override
	public List<Product> queryAllActiveProduct() {
		return productMapper.queryAllActiveProduct();
	}
}
