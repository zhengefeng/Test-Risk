package com.risk.dal.credit.mapper;

import java.util.List;
import java.util.Map;

import com.risk.dal.credit.dto.ConsumerTemplateDetailDto;
import com.risk.dal.credit.dto.StatisticsPersonDto;
import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.ConsumerTemplateDetail;

public interface ConsumerTemplateDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConsumerTemplateDetail consumerTemplateDetail);

    int insertSelective(ConsumerTemplateDetail consumerTemplateDetail);

    ConsumerTemplateDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConsumerTemplateDetail consumerTemplateDetail);

    int updateByPrimaryKey(ConsumerTemplateDetail consumerTemplateDetail);

	List<ConsumerTemplateDetail> queryConsumerTemplateDetails(ConsumerTemplateDetail consumerTemplateDetail);

	int queryConsumerTemplateDetailsCount(ConsumerTemplateDetail consumerTemplateDetail);

	List<ConsumerTemplateDetail> queryConsumerTemplateDetails(ConsumerTemplateDetail consumerTemplateDetail, RowBounds rowBounds);
	
	List<Map<String,Object>> queryTemplateSearchDetail(Map<String,Object> paramMap);

    Integer queryPageCount(ConsumerTemplateDetailDto dto);

    List<ConsumerTemplateDetail> queryPage(ConsumerTemplateDetailDto dto, RowBounds rb);

    StatisticsPersonDto queryStatisticsPerson(String name);
}