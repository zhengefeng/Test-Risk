package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.ProviderInterBiz;
import com.risk.dal.credit.entity.ProviderInter;
import com.risk.dal.credit.mapper.ProviderInterMapper;

/**
 * Created by zhenge.feng.
 */
@Service
public class ProviderInterBizImpl implements ProviderInterBiz {
	
	@Autowired
	private ProviderInterMapper providerInterMapper;

	@Override
	public int insert(ProviderInter providerInter) {
		int result = 0;
		if(providerInter.getId() == null){
			providerInter.setCreatetime(new Date());
			result = providerInterMapper.insert(providerInter);
		}else{
			result = providerInterMapper.updateByPrimaryKey(providerInter);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return providerInterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProviderInter selectByPrimaryKey(Integer id) {
		return providerInterMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProviderInter> queryProviderInters(ProviderInter providerInter) {
		return providerInterMapper.queryProviderInters(providerInter);
	}

	@Override
	public Pagination<ProviderInter, ProviderInter> queryProviderInters(Pagination<ProviderInter, ProviderInter> pagination) {
		int count = providerInterMapper.queryProviderIntersCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(providerInterMapper.queryProviderInters(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

}
