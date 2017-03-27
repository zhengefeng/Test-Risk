package com.common.utils.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * web 工具类
 * 
 * @author zhuxinyu.carter
 * @version $Id: WebTools.java, v 0.1 2013-8-15 下午1:13:41 Administrator Exp $
 */
public class WebTools {
	
	public static String getBasePath(HttpServletRequest httpRequest) {
		String basePath = httpRequest.getScheme() + "://" + httpRequest.getServerName();
		if (httpRequest.getServerPort() != 80) {
			basePath = basePath + ":" + httpRequest.getServerPort();
		}
		
		return basePath  + httpRequest.getContextPath() + "/";
	}

	/**
	 * 获取系统的refer地址， 如果获取不到则直接返回 首页， 并且去掉是否
	 */
	public static String getReferUrl(HttpServletRequest httpRequest) {
		String referUrl = httpRequest.getHeader("referer");

		return referUrl;
	}

	/**
	 * 获取客户端IP
	 */
	public static String getClientIp(HttpServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		String ip = req.getHeader("X-Forwarded-For");
		if (StringUtils.isBlank(ip)) {
			ip = req.getHeader("X-Real-IP");
		}
		if (StringUtils.isBlank(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ip)) {
			ip = StringUtils.EMPTY;
		}

		return ip;
	}
}
