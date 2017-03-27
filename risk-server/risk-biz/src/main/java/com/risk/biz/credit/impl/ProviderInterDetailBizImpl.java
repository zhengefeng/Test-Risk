package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.ProviderInterDetailBiz;
import com.risk.dal.credit.entity.ProviderInterDetail;
import com.risk.dal.credit.mapper.ProviderInterDetailMapper;

@Service("providerInterDetailBizImpl")
public class ProviderInterDetailBizImpl implements ProviderInterDetailBiz {

	@Autowired
	private ProviderInterDetailMapper providerInterDetailMapper;

	@Override
	public int insert(ProviderInterDetail providerInterDetail) {
		int result = 0;
		if (providerInterDetail.getId() == null) {
			providerInterDetail.setCreatetime(new Date());
			result = providerInterDetailMapper.insert(providerInterDetail);
		} else {
			result = providerInterDetailMapper.updateByPrimaryKey(providerInterDetail);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return providerInterDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProviderInterDetail selectByPrimaryKey(Integer id) {
		return providerInterDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProviderInterDetail> queryProviderInterDetails(ProviderInterDetail providerInterDetail) {
		return providerInterDetailMapper.queryProviderInterDetails(providerInterDetail);
	}

	@Override
	public Pagination<ProviderInterDetail, ProviderInterDetail> queryProviderInterDetails(Pagination<ProviderInterDetail, ProviderInterDetail> pagination) {
		int count = providerInterDetailMapper.queryProviderInterDetailsCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(providerInterDetailMapper.queryProviderInterDetails(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

}
