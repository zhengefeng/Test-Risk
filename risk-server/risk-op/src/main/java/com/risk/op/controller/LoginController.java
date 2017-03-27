package com.risk.op.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.codec.Md5Utils;
import com.common.utils.constant.RiskConstants;
import com.risk.biz.admin.AdminUserBiz;
import com.risk.dal.credit.entity.AdminUser;

/**
 * 
 * @author chenwenhai
 * @version $Id: LoginController.java, v 0.1 2016年8月30日 下午2:48:59 chenwenhai Exp $
 */
@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private AdminUserBiz adminUserBiz;

	@RequestMapping("main")
	public String mainPage(){
		return "main";
	}
	
	@RequestMapping("doLogin")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, AdminUser adminUser) {
		ModelAndView model = new ModelAndView();
		// 判断session中是否存在user;
		
		AdminUser user = (AdminUser) request.getSession().getAttribute("user");
		if (user != null) {
			request.getSession().removeAttribute(RiskConstants.USER_SESSION_KEY);
		}
		// 判断输入的用户名和密码是否为空
		if (StringUtils.isNotBlank(adminUser.getUserName()) && StringUtils.isNotBlank(adminUser.getPassword())) {
			// 判断验证码是否正确
//			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String validImgCode = request.getParameter("validImgCode");
//			String validCode = (String) WebUtils.getSessionAttribute(request, GlobalConstance.USER_AUTH_CODE);
			String validCode = (String) request.getSession().getAttribute("USER_AUTH_CODE");
			if (StringUtils.isBlank(validImgCode) || !StringUtils.equalsIgnoreCase(validCode, validImgCode)) {
				model.addObject("isLoginSuccess", false);
				model.addObject("errorMessage", "验证码输入错误！");
				model.setViewName("index");
				return model;
			}

			// 判断用户名和密码是否正确
			adminUser.setPassword(Md5Utils.md5Encrypt(adminUser.getPassword()));
			List<AdminUser> adminUsers = adminUserBiz.queryAdminUsers(adminUser);
			if (adminUsers != null && adminUsers.size() > 0) {
				AdminUser loginAdminUser = adminUsers.get(0);
				// 判断用户是否被禁用
				if (loginAdminUser.getStatus() == 2) {
					// 锁定
					model.addObject("isLoginSuccess", false);
					model.addObject("errorMessage", "用户被禁用！");
					model.setViewName("index");
				} else {
					// 3、如果判断用户正确则把用户信息设置到session，返回首页
					HttpSession session = request.getSession();
					session.setAttribute(RiskConstants.USER_SESSION_KEY, loginAdminUser);
//					model.addObject("isLoginSuccess", true);
//					model.addObject("message", "登录成功！");
					model.addObject("user", loginAdminUser);
					model.setViewName("redirect:/template/query");
				}
			} else {
				// 3、 如果判断用户不正确则转到登录页面返回错误信息
				model.addObject("isLoginSuccess", false);
				model.addObject("errorMessage", "用户名或密码不正确！");
				model.setViewName("index");
			}
		} else {
			model.addObject("isLoginSuccess", false);
			model.addObject("errorMessage", "用户名和密码不能为空！");
			model.setViewName("index");
		}

		return model;
	}

	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		request.getSession().removeAttribute(RiskConstants.USER_SESSION_KEY);
		return "redirect:/login_index.jsp";
	}
}
