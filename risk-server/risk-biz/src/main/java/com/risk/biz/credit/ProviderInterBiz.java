package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.ProviderInter;
/**
 * Created by zhenge.feng.
 */
public interface ProviderInterBiz {
	/**
	 * 保存
	 */
	int insert(ProviderInter providerInter);

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
	ProviderInter selectByPrimaryKey(Integer id);

	/**
	 * 查询服务商接口，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<ProviderInter> queryProviderInters(ProviderInter providerInter);

	/**
	 * 分页查询服务商接口
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<ProviderInter, ProviderInter> queryProviderInters(Pagination<ProviderInter, ProviderInter> pagination);

}
