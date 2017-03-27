package com.risk.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.codec.Md5Utils;
import com.common.utils.constant.RiskConstants;
import com.common.utils.exception.RiskRunTimeException;
import com.common.utils.msg.RiskCodeEnum;
import com.common.utils.page.Pagination;
import com.risk.biz.credit.ConsumerBiz;
import com.risk.dal.credit.entity.Consumer;
import com.risk.dto.AjaxCommonResp;
import com.risk.utils.WebUtils;

@Controller
@RequestMapping("consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerBiz consumerBiz;
	
	@ResponseBody
	@RequestMapping("addConsumer")
	public AjaxCommonResp addConsumer(HttpServletRequest request, Consumer consumer){
		AjaxCommonResp resp = new AjaxCommonResp();
		validate(consumer);
		if(consumer != null && consumer.getLoginname() != null && consumer.getPassword() != null){
			Consumer currentConsumer = WebUtils.handlerConsumer(request);
			consumer.setCompanyid(currentConsumer.getCompanyid());
			consumer.setOpername(currentConsumer.getName());
			consumerBiz.insert(consumer);
			resp.setCode("0000");
			resp.setMsg("新增成功！");
		}else{
			resp.setCode("0001");
			resp.setMsg("用户信息不能为空！");
		}
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("updateConsumer")
	public AjaxCommonResp updateConsumer(Consumer consumer){
		AjaxCommonResp resp = new AjaxCommonResp();
		if(consumer != null && consumer.getId() != null){
			consumerBiz.insert(consumer);
			resp.setCode("0000");
			resp.setMsg("修改成功！");
		}else{
			resp.setCode("0001");
			resp.setMsg("用户信息不能为空！");
		}
		return resp;
	}
	
	@RequestMapping("getConsumerById")
	public ModelAndView getConsumerById(Integer id){
		ModelAndView model = new ModelAndView();
		model.addObject("data", consumerBiz.selectByPrimaryKey(id));
		return model;
	}
	
	@RequestMapping(value = "consumerList", method = RequestMethod.GET)
	public ModelAndView consumerList(HttpServletRequest request, Integer pageSize, Integer currentPage, Consumer consumer){
		pageSize = 5;
		if(currentPage == null || currentPage == 0){
			currentPage = 1;
		}
		Pagination<Consumer, Consumer> page = new Pagination<Consumer, Consumer>(consumer, pageSize, currentPage);
		ModelAndView model = new ModelAndView();
		model.setViewName("consumer/consumerList");
		Consumer currentConsumer = WebUtils.handlerConsumer(request);
		consumer.setCompanyid(currentConsumer.getCompanyid());  // 当前登录用户所在的公司
		page = consumerBiz.queryConsumers(page);
		model.addObject("data", page.getDataList());
		model.addObject("page", page);
		model.addObject("pageSize", pageSize);
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryConsumerList", method = RequestMethod.POST)
	public Map<String,Object> queryConsumerList(HttpServletRequest request,  Integer pageSize, Integer currentPage, Consumer consumer){
		pageSize = 5;
		if(currentPage == null || currentPage == 0){
			currentPage = 1;
		}
		Pagination<Consumer, Consumer> page = new Pagination<Consumer, Consumer>(consumer, pageSize, currentPage);
		Consumer currentConsumer = WebUtils.handlerConsumer(request);
		consumer.setCompanyid(currentConsumer.getCompanyid());  // 当前登录用户所在的公司
		page = consumerBiz.queryConsumers(page);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("data", page.getDataList());
		map.put("page", page);
		map.put("pageSize", pageSize);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("disableConsumer")
	public AjaxCommonResp disableConsumer(Consumer consumer){
		AjaxCommonResp resp = new AjaxCommonResp();
		if(consumer != null && consumer.getId() != null){
			consumerBiz.insert(consumer);
			resp.setCode("0000");
			resp.setMsg("禁用成功！");
		}
		return resp;
	}
	
	@ResponseBody
	@RequestMapping("resetConsumer")
	public AjaxCommonResp resetConsumer(Consumer consumer){
		AjaxCommonResp resp = new AjaxCommonResp();
		if(consumer != null && consumer.getId() != null && consumer.getPassword() != null){
			consumer.setPassword(Md5Utils.md5Encrypt(consumer.getPassword()));
			consumerBiz.insert(consumer);
			resp.setCode("0000");
			resp.setMsg("重置密码成功！");
		}
		return resp;
	}
	
	@RequestMapping("changePasswordPage")
	public String changePasswordPage(){
		return "consumer/changePassword";
	}
	
	@ResponseBody
	@RequestMapping("changePassword")
	public AjaxCommonResp changePassword(HttpServletRequest request, String oldPassword, String newPassword){
		AjaxCommonResp resp = new AjaxCommonResp();
		Consumer con = (Consumer)request.getSession().getAttribute(RiskConstants.USER_SESSION_KEY);
		if(newPassword != null && newPassword.length() > 5){
			if(Md5Utils.md5Encrypt(oldPassword).equals(con.getPassword())){
				Consumer param = new Consumer();
				param.setId(con.getId());
				param.setPassword(Md5Utils.md5Encrypt(newPassword));
				consumerBiz.insert(param);
				con.setPassword(Md5Utils.md5Encrypt(newPassword));
				request.getSession().setAttribute(RiskConstants.USER_SESSION_KEY, con);
				resp.setCode("0000");
				resp.setMsg("修改成功！");
			}else{
				resp.setCode("0001");
				resp.setMsg("原密码输入有误！");
			}
		}else{
			resp.setCode("0002");
			resp.setMsg("请输入6-20位数字，字母！");
		}
		return resp;
	}
	
	/**
	 * 验证
	 */
	private void validate(Consumer consumer) {
		if (StringUtils.isBlank(consumer.getLoginname())) {
			throw new RiskRunTimeException(RiskCodeEnum.CUST_1010.getCode(), RiskCodeEnum.CUST_1010.getName());
		}

		if (null == consumer.getId() && StringUtils.isBlank(consumer.getPassword())) {
			throw new RiskRunTimeException(RiskCodeEnum.CUST_1027.getCode(), RiskCodeEnum.CUST_1027.getName());
		}

		if (null == consumer.getId() && StringUtils.isBlank(consumer.getConfirmpassword())) {
			throw new RiskRunTimeException(RiskCodeEnum.CUST_1028.getCode(), RiskCodeEnum.CUST_1028.getName());
		}

		if (null == consumer.getId() && !consumer.getPassword().equals(consumer.getConfirmpassword())) {
			throw new RiskRunTimeException(RiskCodeEnum.CUST_1006.getCode(), RiskCodeEnum.CUST_1006.getName());
		}
	}

}
