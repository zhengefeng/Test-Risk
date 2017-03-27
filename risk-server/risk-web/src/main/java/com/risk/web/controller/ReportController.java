package com.risk.web.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.risk.biz.credit.ReportBiz;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 生成报告
 * Created by zhenge.feng.
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final static private String orgSecretKey = "co0Pq1v1Zp2P4MI";//机构API私钥 co0Pq1v1Zp2P4MI
    final static private String orgcode = "20310103201608001";//机构号 20310103201608001
    final static private String apiURL2 = "https://test.suanhua.org/cpcs/api/v2/";
    final static private String channel = "/channel/";

    @Autowired
    private ReportBiz reportBiz;


    @RequestMapping(value = "/{templateId}/report",method = RequestMethod.GET)
    public String getTemplateParams(@PathVariable Integer templateId, Model model){
        String params = null;
        if(templateId!=null){
            params = reportBiz.getTemplateParams(templateId);
        }
        model.addAttribute("params",params);

        return "redirect:/report/params";
    }

    @RequestMapping(value = "/{templateId}/production",method = RequestMethod.POST)
    public String invoke(@PathVariable Integer templateId, @RequestParam String paramJson, String userId, Model model,
                         HttpServletRequest request){
        List reportJson = null;
        HttpSession httpSession = request.getSession();
        Map paramMap = JSON.parseObject(paramJson,TreeMap.class);
        if(templateId!=null){
            reportJson = reportBiz.invoke(templateId,paramMap, null, request.getSession().getId());
        }
        model.addAttribute("reportJson",reportJson);

        return "redirect:/report/production";
    }
}
