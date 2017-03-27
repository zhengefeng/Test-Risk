package com.risk.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.codec.Md5Utils;
import com.common.utils.constant.GlobalConstance;
import com.common.utils.constant.RiskConstants;
import com.risk.biz.credit.ConsumerBiz;
import com.risk.dal.credit.entity.Consumer;
import com.risk.utils.WebUtils;

/**
 * 
 * @author chenwenhai
 * @version $Id: UserLoginController.java, v 0.1 2016年8月25日 上午10:44:17 chenwenhai Exp $
 */
@Controller
@RequestMapping("login")
public class UserLoginController {

	@Autowired
	private ConsumerBiz consumerBiz;

	@RequestMapping("/index")
	public String goIndex() {
		return "consumer/login_index";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, Consumer consumer) {
		ModelAndView model = new ModelAndView();
		// 判断session中是否存在user;
		Consumer user = WebUtils.handlerConsumer(request);
		if (user != null) {
			request.getSession().removeAttribute(RiskConstants.USER_SESSION_KEY);
		}
		model.addObject("userLoginName", consumer.getLoginname());
		model.addObject("userLoginPassword", consumer.getPassword());
		// 判断输入的用户名和密码是否为空
		if (StringUtils.isNotBlank(consumer.getLoginname()) && StringUtils.isNotBlank(consumer.getPassword())) {
			// 判断验证码是否正确
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String validImgCode = httpRequest.getParameter("validImgCode");
			if (StringUtils.isBlank(validImgCode)) {
				model.addObject("isLoginSuccess", false);
				model.addObject("errorMessage", "请输入图片中的验证码！");
				model.setViewName("consumer/login_index");
				return model;
			}
			String validCode = (String) WebUtils.getSessionAttribute(httpRequest, GlobalConstance.USER_AUTH_CODE);
			if (StringUtils.isBlank(validImgCode) || !StringUtils.equalsIgnoreCase(validCode, validImgCode)) {
				model.addObject("isLoginSuccess", false);
				model.addObject("errorMessage", "您输入的验证码错误，请重新输入！");
				model.setViewName("consumer/login_index");
				return model;
			}

			// 判断用户名和密码是否正确
			consumer.setPassword(Md5Utils.md5Encrypt(consumer.getPassword()));
			List<Consumer> consumers = consumerBiz.queryConsumers(consumer);
			if (consumers != null && consumers.size() > 0) {
				Consumer loginConsumer = consumers.get(0);
				// 判断用户是否被禁用
				if (loginConsumer.getStatus() == 2) {
					// 锁定
					model.addObject("isLoginSuccess", false);
					model.addObject("errorMessage", "您登录的账户状态有误，请联系系统管理员！");
					model.setViewName("consumer/login_index");
				} else {
					// 3、如果判断用户正确则把用户信息设置到session，返回首页
					HttpSession session = request.getSession();
					session.setAttribute(RiskConstants.USER_SESSION_KEY, loginConsumer);
					// model.addObject("isLoginSuccess", true);
					// model.addObject("message", "登录成功！");
					model.addObject("user", loginConsumer);
					model.setViewName("forward:/template/query");
				}
			} else {
				// 3、 如果判断用户不正确则转到登录页面返回错误信息
				model.addObject("isLoginSuccess", false);
				model.addObject("errorMessage", "您输入的用户名和密码错误，请重新输入！");
				model.setViewName("consumer/login_index");
			}
		} else {
			model.addObject("isLoginSuccess", false);
			model.addObject("errorMessage", "请输入用户名或密码！");
			model.setViewName("consumer/login_index");
		}

		return model;
	}

	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		request.getSession().removeAttribute(RiskConstants.USER_SESSION_KEY);
		return "redirect:/login_index.jsp";
	}
}
