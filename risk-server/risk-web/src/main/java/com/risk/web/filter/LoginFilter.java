package com.risk.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.common.utils.constant.RiskConstants;
import com.risk.dal.credit.entity.Consumer;
import com.risk.utils.WebUtils;

/**
 * 
 * @author chenwenhai
 * @version $Id: LoginFilter.java, v 0.1 2016年8月25日 上午10:44:03 chenwenhai Exp $
 */
public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// 判断是否为请求资源文件
		if (isResources(request)) {
			filterChain.doFilter(request, response);
			return;
		}
		// 判断是否登录
		if (isLogin(request)) {
			request.setAttribute("user", request.getSession().getAttribute(RiskConstants.USER_SESSION_KEY));
			String requestURI = request.getRequestURI();
			if(requestURI.endsWith("web/") || requestURI.endsWith("pc/")){
				request.getRequestDispatcher("/template/query").forward(request, response);
			}else{
				filterChain.doFilter(request, response);				
			}
		} else {
			// 获取请求用户的URI
			String requestURI = request.getRequestURI();
			if(requestURI.contains("login_index") || requestURI.contains("login/doLogin") || requestURI.contains("login/index") || requestURI.contains("/validateImg") ){
				filterChain.doFilter(request, response);
			}else{
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath+"/login_index.jsp");
			}
		}
	}

	/**
	 * 是否登录
	 * 
	 * @param request
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		Consumer user = WebUtils.handlerConsumer(request);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 是否为资源文件
	 * 
	 * @param request
	 * @return
	 */
	private boolean isResources(HttpServletRequest request) {
		request.getServletPath();
		String servletPath = request.getServletPath();
		if (servletPath.startsWith("/resources") || servletPath.contains("/common.jsp")) {
			return true;
		} else {
			return false;
		}
	}
}
