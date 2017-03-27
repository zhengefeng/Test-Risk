package com.common.utils.clazz;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象验证器
 * 
 * @author zhuqiang
 * @version $Id: ValidateUtil.java, v 0.1 2016年2月2日 上午10:25:51 zhuqiang Exp $
 */
public class ValidateUtil {

	private static final Logger logger = LoggerFactory.getLogger(ValidateUtil.class);

	private static Validator validator;

	static {
		try {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			validator = factory.getValidator();
		} catch (Exception e) {
			logger.error("初始化验证器失败了， msg={}", e);
		}
	}

	/**
	 * 验证对象
	 * 
	 * @param obj
	 *            - 不为null 说明验证有错误，前提是注解验证错误信息一定要写
	 */
	public static String validate(Object obj) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
		if (constraintViolations == null || constraintViolations.size() <= 0) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		for (ConstraintViolation<Object> cons : constraintViolations) {
			sb.append(cons.getMessage()).append(", ");
		}

		return sb.toString().substring(0, sb.length() - 2);
	}
}
