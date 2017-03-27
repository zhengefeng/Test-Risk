package com.risk.utils;

import com.common.utils.constant.RiskConstants;
import com.risk.dal.credit.entity.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/8/25.
 */
public class WebUtils {

    public static Consumer handlerConsumer(HttpSession session) {
        if(session == null){
            throw new RuntimeException("session 为毛为空");
        }
        return (Consumer) session.getAttribute(RiskConstants.USER_SESSION_KEY);
    }

    public static Consumer handlerConsumer(HttpServletRequest request) {
        if(request == null){
            throw new RuntimeException("request 为毛为空");
        }
        return (Consumer) request.getSession().getAttribute(RiskConstants.USER_SESSION_KEY);
    }
    
    public static Object getSessionAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		return (session != null ? session.getAttribute(name) : null);
	}
}
