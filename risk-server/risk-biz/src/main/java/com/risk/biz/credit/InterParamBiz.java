package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.InterParam;

/**
 * Created by zhenge.feng.
 */
public interface InterParamBiz {
	
	/**
	 * 保存
	 */
	int insert(InterParam interParam);

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
	InterParam selectByPrimaryKey(Integer id);

	/**
	 * 查询接口参数，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<InterParam> queryInterParams(InterParam interParam);

	/**
	 * 分页查询接口参数
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<InterParam, InterParam> queryInterParams(Pagination<InterParam, InterParam> pagination);

}
