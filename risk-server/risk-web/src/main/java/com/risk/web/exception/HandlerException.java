package com.risk.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/24.
 */
public class HandlerException implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(HandlerException.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        logger.error("哎呦出异常了 {}", ex);
        return new ModelAndView("500");
    }
}
