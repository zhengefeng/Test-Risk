package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.entity.TemplateInter;

/**
 * Created by zhenge.feng.
 */
public interface TemplateInterBiz {
	/**
	 * 保存
	 */
	int insert(TemplateInter templateInter);

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
	TemplateInter selectByPrimaryKey(Integer id);

	/**
	 * 查询模板管理接口信息，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<TemplateInter> queryTemplateInters(TemplateInter templateInter);

	/**
	 * 分页查询模板管理接口信息
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<TemplateInter, TemplateInter> queryTemplateInters(Pagination<TemplateInter, TemplateInter> pagination);

}
