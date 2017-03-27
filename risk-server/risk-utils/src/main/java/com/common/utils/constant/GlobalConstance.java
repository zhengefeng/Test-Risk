package com.common.utils.constant;

/**
 * 全局静态变量
 * 
 * @author zhuxinyu.carter
 * @version $Id: GlobalConstance.java, v 0.1 2016年1月17日 下午1:52:12 zhuxinyu.carter Exp $
 */
public class GlobalConstance {

	/** 登录session key */
	public static final String CURRENT_USER = "CURRENT_USER";
	
	/**登录用户类型*/
	public static final String USER_TYPE_NAME = "USER_TYPE_NAME" ;

	/** 用户登录注册图形验证码 */
	public static final String USER_AUTH_CODE = "USER_AUTH_CODE";

	/** 通用信息标识 */
	public static final String COMMON_MESSAGE_TIP = "commonMessageTip";

	/** 错误信息标识 */
	public static final String ERROR_MESSAGE_TIP = "errorMessageTip";

	/** 密码盐 */
	public static final String DEFAULT_SALT = "$1$abcd";

	/**
	 * 验证码KEY的前缀 (另加用户手机号)
	 */
	public static final String VAILDCODE = "VAILDCODE_";

	/** 1表示 信息正确,条件可用, true */
	public static Integer STATUS_OK = 1;

	/** 0表示 信息错误,条件不可用, false */
	public static Integer STATUS_FAIL = 0;

	/** 默认页偏移 */
	public final static Integer DEFAULT_OFFSET = 0;
	/** 默认条数 */
	public final static Integer DEFAULT_LENGTH = 20;

	/**
	 * 版本管理 0 android 1 ios
	 */
	public static final String APPVERSION_ANDROID = "0";
	public static final String APPVERSION_IOS = "1";

	/**
	 * 版本是否强制更新
	 */
	public static final String FORCE_UPDATE_YES = "1";
	public static final String FORCE_UPDATE_NO = "0";

	/**
	 * 0 最新 1可选 2强制 版本更新管理
	 */
	public static final String UPDATE_VERSION_NORMAL = "0";
	public static final String UPDATE_VERSION_NEW_VERSION = "1";
	public static final String UPDATE_VERSION_FORCE_VERSION = "2";

	/**
	 * date
	 */
	public static final String DATE_FORMAT_DEFAULT = "yyyyMMddHHmmss";

	/**
	 * 格式化到天的日期格式
	 */
	public static final String DATE_FORMATE_2_D = "yyyyMMdd";
	
	/**
	 * 格式化到天的日期格式
	 */
	public static final String DATE_FORMATE_NORMAL = "yyyy-MM-dd";
	
	/**
	 * 格式化到秒的日期格式
	 */
	public static final String DATE_FORMATE_2_S = "yyyyMMdd HH:mm:ss";

	/**
	 * JSON 数据格式
	 */
	public static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

	/**
	 * 编码格式 - UTF-8
	 */
	public static final String CHARSET_UTF8 = "UTF-8";
	
	/**
	 * BigDecimal小数点后位数
	 */
	public static final Integer MONEY_SCALE = 2;
}
