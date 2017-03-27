package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.ProductCallDetail;

/**
 * Created by zhenge.feng.
 */
public interface ProductCallDetailBiz {
	
	/**
	 * 保存
	 */
	int insert(ProductCallDetail productCallDetail);

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
	ProductCallDetail selectByPrimaryKey(Integer id);

	/**
	 * 查询产品调用明细流水，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<ProductCallDetail> queryProductCallDetails(ProductCallDetail productCallDetail);

	/**
	 * 分页查询产品调用明细流水
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<ProductCallDetail, ProductCallDetail> queryProductCallDetails(Pagination<ProductCallDetail, ProductCallDetail> pagination);

}
