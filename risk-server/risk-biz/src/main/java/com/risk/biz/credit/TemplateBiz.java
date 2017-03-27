package com.risk.biz.credit;

import java.util.List;

import com.common.utils.page.Pagination;
import com.risk.dal.credit.dto.TemplateDetailDto;
import com.risk.dal.credit.entity.Template;
import com.risk.dal.credit.entity.TemplateInter;

public interface TemplateBiz {
	/**
	 * 保存
	 */
	int insert(Template template);

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
	Template selectByPrimaryKey(Integer id);

	/**
	 * 查询模板列表，不分页
	 * 
	 * @param company
	 * @return
	 */
	List<Template> queryTemplates(Template template);

	/**
	 * 分页查询模板信息
	 * 
	 * @param pagination
	 * @return
	 */
	Pagination<Template, Template> queryTemplates(Pagination<Template, Template> pagination);

	/**
	 * 保存用户模板和模板下面的所有产品列表
	 * @param template
	 * @param detailList
	 */
    void saveTemplateAndDetail(Template template, List<TemplateInter> detailList);

    List<Template> queryUserAllTemplate(Template dto);

    Integer updateTemplate(Template temp);

	/**
	 * 查询模板所有关联产品类别
	 * @param dto
	 * @return
	 */
    List<TemplateDetailDto> queryTemplatesAndDetailList(Template dto);

    List<TemplateInter> queryTemplateDetailById(Integer id);
}
