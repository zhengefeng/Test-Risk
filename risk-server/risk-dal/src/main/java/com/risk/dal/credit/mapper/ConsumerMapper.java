package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.Consumer;

public interface ConsumerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Consumer consumer);

    int insertSelective(Consumer consumer);

    Consumer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Consumer consumer);

    int updateByPrimaryKey(Consumer consumer);

	List<Consumer> queryConsumers(Consumer consumer);

	int queryConsumersCount(Consumer consumer);

	List<Consumer> queryConsumers(Consumer consumer, RowBounds rowBounds);
}