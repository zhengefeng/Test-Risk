package com.risk.biz.credit.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.CompanyBiz;
import com.risk.dal.credit.entity.Company;
import com.risk.dal.credit.mapper.CompanyMapper;

@Service("companyBiz")
public class CompanyBizImpl implements CompanyBiz {

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public int insert(Company company) {
		int result = 0;
		if (company.getId() == null) {
			company.setCreatetime(new Date());
			result = companyMapper.insert(company);
		} else {
			result = companyMapper.updateByPrimaryKey(company);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return companyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Company selectByPrimaryKey(Integer id) {
		return companyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Company> queryCompanys(Company company) {
		return companyMapper.queryCompanys(company);
	}

	@Override
	public Pagination<Company, Company> queryCompanys(Pagination<Company, Company> pagination) {
		int totalCount = companyMapper.queryCompanysCount(pagination.getParam());
		pagination.setTotalCount(totalCount);
		if (totalCount > 0) {
			pagination.setDataList(companyMapper.queryCompanys(pagination.getParam(), new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

	@Override
	public List<Company> getCompanyList() {
		return null;
	}

	@Override
	public Company getCompanyById(Integer id) {
		return companyMapper.selectByPrimaryKey(id);
	}

}
