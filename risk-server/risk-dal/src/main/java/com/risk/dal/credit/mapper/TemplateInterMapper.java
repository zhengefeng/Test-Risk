package com.risk.dal.credit.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.risk.dal.credit.entity.TemplateInter;

public interface TemplateInterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplateInter templateInter);

    int insertSelective(TemplateInter templateInter);

    TemplateInter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplateInter templateInter);

    int updateByPrimaryKey(TemplateInter templateInter);

	List<TemplateInter> queryTemplateInters(TemplateInter templateInter);

	int queryTemplateIntersCount(TemplateInter templateInter);

	List<TemplateInter> queryTemplateInters(TemplateInter templateInter, RowBounds rowBounds);

    void insertAll(List<TemplateInter> detailList);

    List<TemplateInter> queryByTemplateId(Integer id);
}