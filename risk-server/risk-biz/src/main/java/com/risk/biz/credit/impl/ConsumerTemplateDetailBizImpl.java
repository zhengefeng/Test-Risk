package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.common.utils.page.PageDto;
import com.risk.dal.credit.dto.ConsumerTemplateDetailDto;
import com.risk.dal.credit.dto.StatisticsPersonDto;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.ConsumerTemplateDetailBiz;
import com.risk.dal.credit.entity.ConsumerTemplateDetail;
import com.risk.dal.credit.mapper.ConsumerTemplateDetailMapper;

@Service("consumerTemplateDetailBizImpl")
public class ConsumerTemplateDetailBizImpl implements ConsumerTemplateDetailBiz {

	@Autowired
	private ConsumerTemplateDetailMapper consumerTemplateDetailMapper;
	
	@Override
	public int insert(ConsumerTemplateDetail consumerTemplateDetail) {
		int result = 0;
		if(consumerTemplateDetail.getId() == null){
			consumerTemplateDetail.setCreatetime(new Date());
			consumerTemplateDetailMapper.insert(consumerTemplateDetail);
		}else{
			consumerTemplateDetailMapper.updateByPrimaryKey(consumerTemplateDetail);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return consumerTemplateDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public ConsumerTemplateDetail selectByPrimaryKey(Integer id) {
		return consumerTemplateDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ConsumerTemplateDetail> queryConsumerTemplateDetails(ConsumerTemplateDetail consumerTemplateDetail) {
		return consumerTemplateDetailMapper.queryConsumerTemplateDetails(consumerTemplateDetail);
	}
	
	@Override
	public Object queryTemplateSearchDetail(Map<String,Object> paramMap) {
		List<Map<String,Object>> oo  = consumerTemplateDetailMapper.queryTemplateSearchDetail(paramMap);
		System.out.println(oo);
		return oo;
	}

	@Override
	public Pagination<ConsumerTemplateDetail, ConsumerTemplateDetail> queryConsumerTemplateDetails(
			Pagination<ConsumerTemplateDetail, ConsumerTemplateDetail> pagination) {
		int count = consumerTemplateDetailMapper.queryConsumerTemplateDetailsCount(pagination.getParam());
		pagination.setTotalCount(count);
		if (count > 0) {
			pagination.setDataList(consumerTemplateDetailMapper.queryConsumerTemplateDetails(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

    @Override
    public PageDto<ConsumerTemplateDetail> queryPage(ConsumerTemplateDetailDto dto, RowBounds rowBounds) {
    	PageDto<ConsumerTemplateDetail> result = new PageDto<>();
		result.setTotalCount(consumerTemplateDetailMapper.queryPageCount(dto));
		result.setDataList(consumerTemplateDetailMapper.queryPage(dto, rowBounds));
        return result;
    }

    @Override
    public StatisticsPersonDto queryStatisticsPerson(String name) {
        return consumerTemplateDetailMapper.queryStatisticsPerson(name);
    }

}
