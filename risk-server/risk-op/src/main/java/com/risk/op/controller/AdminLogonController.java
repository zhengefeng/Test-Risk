package com.risk.op.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.common.utils.constant.GlobalConstance;
import com.common.utils.msg.RiskConfigSeting;
import com.common.utils.web.WebTools;
import com.risk.biz.admin.AdminUserBiz;

/**
 * 管理员登录后台登录，授权，修改账号,系统退出
 * 
 * @author zhuxinyu.carter
 * @version $Id: AdminLogonController.java, v 0.1 2016年1月16日 下午4:32:47 zhuxinyu.carter Exp $
 */
@Controller
public class AdminLogonController {

	@Autowired
	private AdminUserBiz adminUserBiz;
	
//	@Autowired
//	private RiskConfigSeting setting;

	private static final Logger logger = LoggerFactory.getLogger(AdminLogonController.class);

	@RequestMapping(value = "admin_index", method = RequestMethod.GET)
	public String goAmdinLogin(HttpServletRequest httpRequest, ModelMap modelMap) {
		String returnPage = "admin_index";


		return returnPage;
	}

	
	@RequestMapping("logonOut")
	public String logonOut(HttpServletRequest httpRequest, String jid) {
		if (StringUtils.equalsIgnoreCase(httpRequest.getSession().getId(), jid)) {
			WebUtils.setSessionAttribute(httpRequest, GlobalConstance.CURRENT_USER, null);
		}

		return "redirect:" + WebTools.getBasePath(httpRequest);
	}
	
	
}
