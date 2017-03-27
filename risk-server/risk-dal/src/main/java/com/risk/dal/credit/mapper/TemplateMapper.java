package com.risk.dal.credit.mapper;

import java.util.List;
import java.util.Map;

import com.risk.dal.credit.dto.InterDto;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.Template;

public interface TemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Template template);

    int insertSelective(Template template);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Template template);

    int updateByPrimaryKey(Template template);

	List<Template> queryTemplates(Template template);

	int queryTemplatesCount(Template template);

	List<Template> queryTemplates(Template template, RowBounds rowBounds);

    List<Template> queryUserAllTemplate(Template dto);

    Integer updateBySelective(Template temp);

    /**
     * 返回某些模板按照infoType分组的结果
     * @param temp
     * @return
     */
    List<InterDto> queryTemplateAllInfoType(Template temp);
}