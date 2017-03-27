package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.ProviderInterDetail;

/**
 * Created by zhenge.feng.
 */
public interface ProviderInterDetailBiz {
	
	/**
	 * 保存
	 */
	int insert(ProviderInterDetail providerInterDetail);

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
	ProviderInterDetail selectByPrimaryKey(Integer id);

	/**
	 * 查询服务商接口调用流水，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<ProviderInterDetail> queryProviderInterDetails(ProviderInterDetail providerInterDetail);

	/**
	 * 分页查询服务商接口调用流水
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<ProviderInterDetail, ProviderInterDetail> queryProviderInterDetails(Pagination<ProviderInterDetail, ProviderInterDetail> pagination);

}
