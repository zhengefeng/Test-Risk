package com.risk.web.controller;

import com.common.utils.clazz.ObjectUtils;
import com.common.utils.constant.RiskConstants;
import com.common.utils.exception.RiskRunTimeException;
import com.risk.biz.credit.ProductBiz;
import com.risk.biz.credit.ReportBiz;
import com.risk.biz.credit.TemplateBiz;
import com.risk.dal.credit.dto.ParamValidateDto;
import com.risk.dal.credit.dto.ProductResultDto;
import com.risk.dal.credit.dto.TemplateDetailDto;
import com.risk.dal.credit.entity.*;
import com.risk.dto.AjaxCommonResp;
import com.risk.form.TemplateForm;
import com.risk.form.TemplateUpdateForm;
import com.risk.utils.BidResultUtils;
import com.risk.utils.WebUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板
 * Created by zhenge.feng.
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    private final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateBiz templateBiz;

    @Autowired
    private ProductBiz productBiz;

    @Autowired
    private ReportBiz reportBiz;

    @Autowired
    private TaskExecutor threadPool;

    @RequestMapping("/query")
    public ModelAndView userQuery(HttpSession session){
        ModelAndView mav = new ModelAndView("template/query");
        Template dto = new Template();
        //查询模板为正常的状态，禁用的不查出来
        dto.setStatus(RiskConstants.STATUS_NORMAL_INT);
        List<TemplateDetailDto> list = templateBiz.queryTemplatesAndDetailList(dto);
        mav.addObject("templateList", list);
        return mav;
    }

    @RequestMapping("/query-param/{tmpId}")
    public ModelAndView queryByTemplate(@PathVariable Integer tmpId){
        ModelAndView mav = new ModelAndView("template/queryParam");
        List<InterParam> paramList = reportBiz.getTemplateParamsList(tmpId);
        mav.addObject("paramList", paramList);
        mav.addObject("id", tmpId);
        return mav;
    }

    @RequestMapping("/report/{id}")
    @ResponseBody
    public AjaxCommonResp creditReport(@PathVariable("id") final Integer id, @RequestBody final Map<String, Object> param, final HttpSession session){
        AjaxCommonResp resp = new AjaxCommonResp();
        ParamValidateDto validateDto = null;
        try {
            final Consumer user = WebUtils.handlerConsumer(session);

            validateDto = reportBiz.validateParams(id, param);
            if(!CollectionUtils.isEmpty(validateDto.getValiateInfos())){
                throw new RiskRunTimeException(RiskConstants.VALIDATE_ERROR);
            }

            //异步提交请求
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    reportBiz.invoke(id, param, user, session.getId());
                }
            });

        } catch (RiskRunTimeException e){
            resp.setCode(e.getErrorCode());
            resp.setData(validateDto.getValiateInfos());
        } catch (Exception e){
            resp.setCode(RiskConstants.ERROR);
            logger.error("error msg={}", e);
        }
        return resp;
    }

    @RequestMapping("/manage-index")
    public ModelAndView manageIndex(HttpSession session) {
        ModelAndView mav = new ModelAndView("template/manage");
        //管理员用户能查到本公司所有模板，普通用户只能查询自己创建的模板
        Template dto = handlerQueryDto(session);
        List<Template> list = templateBiz.queryUserAllTemplate(dto);
        mav.addObject("templateList", list);
        return mav;
    }

    private Template handlerQueryDto(HttpSession session) {
        Template dto = new Template();
        Consumer user = WebUtils.handlerConsumer(session);
        dto.setCompanyid(user.getCompanyid());
        //不是管理员就把user限制下
        if(RiskConstants.ADMIN_SIGN != Integer.valueOf(user.getRanklevel())){
            dto.setUserid(user.getId());
        }
        return dto;
    }

    @RequestMapping("/update-status")
    public String updateStatus(@Valid TemplateUpdateForm form, BindingResult result){
        if(result.hasErrors()) {
            String msg = BidResultUtils.handlerErrMsg(result);
            logger.error("验证错误 {}", msg);
            return "500";
        }

        Template temp = new Template();
        temp.setStatus(form.getStatus());
        temp.setId(form.getId());

        templateBiz.updateTemplate(temp);
        return "redirect:manage-index";
    }

    @RequestMapping("/add-init")
    public String initTemplate(ModelMap mmap){
        List<Product> allActivePros = productBiz.queryAllActiveProduct();
        mmap.addAttribute("proList", allActivePros);
        return "template/add";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxCommonResp saveUserTemplate(@RequestBody TemplateForm form, HttpSession session){
        AjaxCommonResp resp = new AjaxCommonResp();
        try {

            Consumer consumer = WebUtils.handlerConsumer(session);
            //template
            Template template = new Template();
            BeanUtils.copyProperties(form, template);
            template.setStatus(RiskConstants.STATUS_NORMAL_INT);//正常状态
            template.setUserid(consumer.getId());
            template.setCompanyid(consumer.getCompanyid());

            //list inter
            List<TemplateInter> detailList = ObjectUtils.copyListObj(form.getDetailList(), TemplateInter.class);

            templateBiz.saveTemplateAndDetail(template, detailList);
        } catch (Exception e) {
            resp.setMsg(e.getMessage());
            resp.setCode(RiskConstants.ERROR);
            logger.error("保存用户模板发生错误, msg = {}", e);
        }


        return resp;

    }

    @RequestMapping("/report-template/{id}")
    public ModelAndView queryReportTemplate(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView("/template/reportTemplate");

        List<TemplateInter> list = templateBiz.queryTemplateDetailById(id);

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
        Map<String, Map<String, TemplateInter>> itMap = new HashMap<>();
        for (TemplateInter dto : list) {
            if (itMap.get(dto.getInfotype()) == null) {
                itMap.put(dto.getInfotype(), new HashMap<String, TemplateInter>());
            }
            itMap.get(dto.getInfotype()).put(dto.getProductid()+"", dto);
        }

        mav.addObject("prodMap", itMap);
        return mav;
    }

}
