package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.ProviderInter;

public interface ProviderInterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProviderInter providerInter);

    int insertSelective(ProviderInter providerInter);

    ProviderInter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProviderInter providerInter);

    int updateByPrimaryKey(ProviderInter providerInter);

	List<ProviderInter> queryProviderInters(ProviderInter providerInter);

	int queryProviderIntersCount(ProviderInter providerInter);

	List<ProviderInter> queryProviderInters(ProviderInter providerInter, RowBounds rowBounds);
}