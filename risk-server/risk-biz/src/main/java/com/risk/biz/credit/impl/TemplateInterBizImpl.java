package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.TemplateInterBiz;
import com.risk.dal.credit.entity.TemplateInter;
import com.risk.dal.credit.mapper.TemplateInterMapper;

/**
 * Created by zhenge.feng.
 */
@Service
public class TemplateInterBizImpl implements TemplateInterBiz{
	
	@Autowired
	private TemplateInterMapper templateInterMapper;

	@Override
	public int insert(TemplateInter templateInter) {
		int result = 0;
		if(templateInter.getId() == null){
			templateInter.setCreatetime(new Date());
			result = templateInterMapper.insert(templateInter);
		}else{
			result = templateInterMapper.updateByPrimaryKey(templateInter);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return templateInterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TemplateInter selectByPrimaryKey(Integer id) {
		return templateInterMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TemplateInter> queryTemplateInters(TemplateInter templateInter) {
		return templateInterMapper.queryTemplateInters(templateInter);
	}

	@Override
	public Pagination<TemplateInter, TemplateInter> queryTemplateInters(Pagination<TemplateInter, TemplateInter> pagination) {
		int count = templateInterMapper.queryTemplateIntersCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(templateInterMapper.queryTemplateInters(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

	
}
