package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.InterParam;

public interface InterParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterParam interParam);

    int insertSelective(InterParam interParam);

    InterParam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterParam interParam);

    int updateByPrimaryKey(InterParam interParam);

	List<InterParam> queryInterParams(InterParam interParam);

	int queryInterParamsCount(InterParam interParam);

	List<InterParam> queryInterParams(InterParam interParam, RowBounds rowBounds);
}