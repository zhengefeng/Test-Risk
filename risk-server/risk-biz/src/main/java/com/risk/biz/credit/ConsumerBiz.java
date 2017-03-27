package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.Consumer;

public interface ConsumerBiz {
	/**
	 * 保存
	 */
	int insert(Consumer consumer);

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
	Consumer selectByPrimaryKey(Integer id);

	/**
	 * 查询商户用户信息列表，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<Consumer> queryConsumers(Consumer consumer);

	/**
	 * 分页查询商户用户信息
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<Consumer, Consumer> queryConsumers(Pagination<Consumer, Consumer> pagination);

}
