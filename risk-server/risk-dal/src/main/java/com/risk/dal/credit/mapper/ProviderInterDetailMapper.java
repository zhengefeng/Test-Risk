package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.ProviderInterDetail;

public interface ProviderInterDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProviderInterDetail providerInterDetail);

    int insertSelective(ProviderInterDetail providerInterDetail);

    ProviderInterDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProviderInterDetail providerInterDetail);

    int updateByPrimaryKey(ProviderInterDetail providerInterDetail);

	List<ProviderInterDetail> queryProviderInterDetails(ProviderInterDetail providerInterDetail);

	int queryProviderInterDetailsCount(ProviderInterDetail param);

	List<ProviderInterDetail> queryProviderInterDetails(ProviderInterDetail param, RowBounds rowBounds);
}