package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company company);

    int insertSelective(Company company);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company company);

    int updateByPrimaryKey(Company company);
    
    List<Company> queryCompanys(Company company);

	int queryCompanysCount(Company company);

	List<Company> queryCompanys(Company company, RowBounds rowBounds);
}