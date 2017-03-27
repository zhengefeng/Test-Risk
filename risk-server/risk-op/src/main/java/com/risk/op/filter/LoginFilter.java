package com.risk.op.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 
 * @author chenwenhai
 * @version $Id: LoginFilter.java, v 0.1 2016年8月12日 下午4:08:41 chenwenhai Exp $
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
			filterChain.doFilter(request, response);
		} else {
			// 获取请求用户的URI
//			String requestURI = request.getRequestURI();
//			if(requestURI.contains("login_index")){
//				filterChain.doFilter(request, response);
//			}else{
//				String contextPath = request.getContextPath();
//				response.sendRedirect(contextPath+"/login_index.jsp");
//			}
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * 是否登录
	 * 
	 * @param request
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
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
		System.out.println(servletPath);
		if (servletPath.startsWith("/resources")) {
			return true;
		} else {
			return false;
		}
	}
}
