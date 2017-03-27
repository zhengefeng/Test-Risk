package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.Company;

public interface CompanyBiz {

	/**
	 * 保存
	 */
	int insert(Company company);

	/**
	 * 根据ID删除
	 */
	int delete(Integer id);

	/**
	 * 通过主键ID查询
	 * 
	 * @param id
	 * @return
	 */
	Company selectByPrimaryKey(Integer id);

	/**
	 * 查询商户信息列表，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<Company> queryCompanys(Company company);

	/**
	 * 分页查询商户信息
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<Company, Company> queryCompanys(Pagination<Company, Company> pagination);

	List<Company> getCompanyList();

	Company  getCompanyById(Integer id);

}
