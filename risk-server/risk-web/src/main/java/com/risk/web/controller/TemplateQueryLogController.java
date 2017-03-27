package com.risk.web.controller;

import com.alibaba.fastjson.JSON;
import com.common.utils.constant.RiskConstants;
import com.common.utils.gate.EnumMap;
import com.common.utils.page.PageDto;
import com.risk.biz.credit.ConsumerTemplateDetailBiz;
import com.risk.dal.credit.dto.ConsumerTemplateDetailDto;
import com.risk.dal.credit.dto.ProductResultDto;
import com.risk.dal.credit.dto.StatisticsPersonDto;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dal.credit.entity.ConsumerTemplateDetail;
import com.risk.form.TemplateQLogForm;
import com.risk.utils.WebUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/25.
 */
@Controller
@RequestMapping("/template-log")
public class TemplateQueryLogController {

    public static final Logger logger = LoggerFactory.getLogger(TemplateQueryLogController.class);

    @Autowired
    private ConsumerTemplateDetailBiz biz;

    @RequestMapping("/index")
    public String index(){

        return "templateLog/index";
    }

    @RequestMapping("/list-data")
    @ResponseBody
    public PageDto<ConsumerTemplateDetail> listData(TemplateQLogForm form, HttpSession session){

        ConsumerTemplateDetailDto dto = new ConsumerTemplateDetailDto();
        BeanUtils.copyProperties(form, dto);

        handlerQueryDto(session, dto);

        PageDto<ConsumerTemplateDetail> result = biz.queryPage(dto, new RowBounds(form.getStartIndex(), form.getPageSize()));

        return result;
    }

    private ConsumerTemplateDetailDto handlerQueryDto(HttpSession session, ConsumerTemplateDetailDto dto) {
        Consumer user = WebUtils.handlerConsumer(session);
        dto.setCompanyid(user.getCompanyid());
        //不是管理员就把user限制下
        if(RiskConstants.ADMIN_SIGN != Integer.valueOf(user.getRanklevel())){
            dto.setConsumerid(user.getId());
        }
        return dto;
    }

    @RequestMapping("/report/{id}")
    public ModelAndView report(@PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView("/templateLog/report");
        ConsumerTemplateDetail detail = biz.selectByPrimaryKey(id);

        if(!StringUtils.isEmpty(detail.getPersonname())){
            StatisticsPersonDto statisticsDto = biz.queryStatisticsPerson(detail.getPersonname());
            mav.addObject("statisticsDto", statisticsDto);
        }
        String jsonStr = detail.getReturndata();

        List<ProductResultDto> prodList = JSON.parseArray(jsonStr, ProductResultDto.class);

        /**
         * infoType1: proId1:resultDto
         * infoType1: proId2:resultDto
         * infoType1: proId3:resultDto
         *
         * infoType2: proId4:resultDto
         * infoType2: proId5:resultDto
         * infoType2: proId6:resultDto
         *
         * ...
         *
         */
        Map<String, Map<String, ProductResultDto>> itMap = new HashMap<>();
        for (ProductResultDto dto : prodList) {
            if (itMap.get(dto.getInfoType()) == null) {
                itMap.put(dto.getInfoType(), new HashMap<String, ProductResultDto>());
            }
            itMap.get(dto.getInfoType()).put(dto.getProductId()+"", dto);
        }


        mav.addObject("prodMap", itMap);
        mav.addObject("detail", detail);


        return mav;
    }
    
    @ResponseBody
    @RequestMapping("queryTemplateSearchDetail")
    public Map<String,Object> queryTemplateSearchDetail(Integer templateId){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("templateId", templateId);
    	map.put("data", biz.queryTemplateSearchDetail(map));
    	return map;
    }

}
