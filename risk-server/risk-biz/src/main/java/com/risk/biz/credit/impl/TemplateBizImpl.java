package com.risk.biz.credit.impl;

import java.util.*;

import com.risk.dal.credit.dto.InterDto;
import com.risk.dal.credit.dto.TemplateDetailDto;
import com.risk.dal.credit.entity.TemplateInter;
import com.risk.dal.credit.mapper.TemplateInterMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.page.Pagination;
import com.risk.biz.credit.TemplateBiz;
import com.risk.dal.credit.entity.Template;
import com.risk.dal.credit.mapper.TemplateMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("templateBiz")
public class TemplateBizImpl implements TemplateBiz {

	@Autowired
	private TemplateMapper templateMapper;

	@Autowired
	private TemplateInterMapper templateInterMapper;

	@Override
	public int insert(Template template) {
		int result = 0;
		if (template.getId() != null) {
			template.setCreatetime(new Date());
			result = templateMapper.insert(template);
		} else {
			result = templateMapper.updateByPrimaryKey(template);
		}
		return result;
	}

	@Override
	public int delete(Integer id) {
		return templateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Template selectByPrimaryKey(Integer id) {
		return templateMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Template> queryTemplates(Template template) {
		return templateMapper.queryTemplates(template);
	}

	@Override
	public Pagination<Template, Template> queryTemplates(Pagination<Template, Template> pagination) {
		int count = templateMapper.queryTemplatesCount(pagination.getParam());
		pagination.setTotalCount(count);
		if(count > 0){
			pagination.setDataList(templateMapper.queryTemplates(pagination.getParam(),new RowBounds(pagination.getOffset(), pagination.getLimit())));
		}
		return pagination;
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED)
    public void saveTemplateAndDetail(Template template, List<TemplateInter> detailList) {
        templateMapper.insert(template);
		handleDetailFK(template, detailList);
		templateInterMapper.insertAll(detailList);
    }

    @Override
    public List<Template> queryUserAllTemplate(Template dto) {
        return templateMapper.queryUserAllTemplate(dto);
    }

	@Override
	public Integer updateTemplate(Template temp) {
		return templateMapper.updateBySelective(temp);
	}

    @Override
    public List<TemplateDetailDto> queryTemplatesAndDetailList(Template dto) {
    	//自己给自己留个坑，导致代码写的有点恶心
    	List<TemplateDetailDto> resultList = new LinkedList<>();

    	//查询用户所有模板
		List<Template> tList = templateMapper.queryUserAllTemplate(dto);
		//插叙用户所有模板对应infoType
		Map<Integer, List<InterDto>> integerListMap = new HashMap<>();

		List<InterDto> interDtos = templateMapper.queryTemplateAllInfoType(dto);
		for (InterDto idto : interDtos) {
			if(integerListMap.get(idto.getTemplateId()) == null) {
				integerListMap.put(idto.getTemplateId(), new ArrayList<InterDto>());
			}
			integerListMap.get(idto.getTemplateId()).add(idto);
		}

		for (Template tl : tList) {
			TemplateDetailDto tdto = new TemplateDetailDto();
			BeanUtils.copyProperties(tl, tdto);
			tdto.setTypes(integerListMap.get(tdto.getId()));
			resultList.add(tdto);
		}

		return resultList;
    }

	private void handleDetailFK(Template template, List<TemplateInter> detailList) {
		for (TemplateInter tinter : detailList) {
			tinter.setTemplateid(template.getId());
		}
	}

	@Override
	public List<TemplateInter> queryTemplateDetailById(Integer id) {
		return templateInterMapper.queryByTemplateId(id);
	}


}
