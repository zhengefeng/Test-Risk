package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.ProductCallDetailBiz;
import com.risk.dal.credit.entity.ProductCallDetail;
import com.risk.dal.credit.mapper.ProductCallDetailMapper;

@Service("productCallDetailBizImpl")
public class ProductCallDetailBizImpl implements ProductCallDetailBiz {

	@Autowired
	private ProductCallDetailMapper productCallDetailMapper;
	
	@Override
	public int insert(ProductCallDetail productCallDetail) {
		int result = 0;
		if(productCallDetail.getId() == null){
			productCallDetail.setCreatetime(new Date());
			result = productCallDetailMapper.insert(productCallDetail);
		}else{
			result = productCallDetailMapper.updateByPrimaryKey(productCallDetail);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return productCallDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProductCallDetail selectByPrimaryKey(Integer id) {
		return productCallDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductCallDetail> queryProductCallDetails(ProductCallDetail productCallDetail) {
		return productCallDetailMapper.queryProductCallDetails(productCallDetail);
	}

	@Override
	public Pagination<ProductCallDetail, ProductCallDetail> queryProductCallDetails(Pagination<ProductCallDetail, ProductCallDetail> pagination) {
		int count = productCallDetailMapper.queryProductCallDetailsCount(pagination.getParam());
		pagination.setTotalCount(count);
		if(count > 0){
			pagination.setDataList(productCallDetailMapper.queryProductCallDetails(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

}
