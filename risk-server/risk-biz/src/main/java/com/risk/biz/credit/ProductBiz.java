package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.Product;

public interface ProductBiz {

	/**
	 * 查询所有开启的产品，用于用户自定义模板组合不同的产品
	 * @return 所有状态为正常的产品
	 */
	List<Product> queryAllActiveProduct();

}
