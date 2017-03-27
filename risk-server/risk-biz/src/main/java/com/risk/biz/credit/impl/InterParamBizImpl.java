package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.InterParamBiz;
import com.risk.dal.credit.entity.InterParam;
import com.risk.dal.credit.mapper.InterParamMapper;

/**
 * Created by zhenge.feng.
 */
@Service
public class InterParamBizImpl implements InterParamBiz {
	
	@Autowired
	private InterParamMapper interParamMapper;

	@Override
	public int insert(InterParam interParam) {
		int result = 0;
		if(interParam.getId() == null){
			interParam.setCreatetime(new Date());
			result = interParamMapper.insert(interParam);
		}else{
			result = interParamMapper.updateByPrimaryKey(interParam);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return interParamMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InterParam selectByPrimaryKey(Integer id) {
		return interParamMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<InterParam> queryInterParams(InterParam interParam) {
		return interParamMapper.queryInterParams(interParam);
	}

	@Override
	public Pagination<InterParam, InterParam> queryInterParams(Pagination<InterParam, InterParam> pagination) {
		int count = interParamMapper.queryInterParamsCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(interParamMapper.queryInterParams(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}
    
}
