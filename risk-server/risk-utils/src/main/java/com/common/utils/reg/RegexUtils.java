package com.common.utils.reg;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 正则表达式相关工具类
 * 
 * @author wangle
 * @version $Id: RegexUtils.java, v 0.1 2016年1月20日 下午2:25:00 wangle Exp $
 */
public final class RegexUtils {
	/** 常规正则表达式 */
	public final static String MOBILE = "^\\d{11}$";
	public final static String EMAIL = "^*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

	/** 正则表达式句柄 */
	private final static Pattern MOBILE_PATTERN = Pattern.compile(MOBILE);
	private final static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL);

	/**
	 * 私有构造函数防止外部实例化
	 */
	private RegexUtils() {
	}

	/**
	 * 判断是否是手机号
	 */
	public static boolean isMobile(String input) {
		boolean rs = false;
		if (StringUtils.isNotBlank(input)) {
			rs = MOBILE_PATTERN.matcher(input).find();
		}
		return rs;
	}

	/**
	 * 判断是否是邮箱
	 */
	public static boolean isEmail(String input) {
		boolean rs = false;
		if (StringUtils.isNotBlank(input)) {
			rs = EMAIL_PATTERN.matcher(input).find();
		}
		return rs;
	}
}
