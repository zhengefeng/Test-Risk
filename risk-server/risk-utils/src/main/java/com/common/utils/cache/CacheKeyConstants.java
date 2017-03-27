package com.common.utils.cache;

/**
 * 全站通用的缓存key
 * 
 * @author zhuxinyu.carter
 * 
 * @version CacheKeyConstants.java - 2015年 下午1:12:17 zhuxinyu.carter Exp
 */
public class CacheKeyConstants {

	public static final int FIVE_MINS = 5 * 60;

	public static final int TEN_MINS = 10 * 60;

	public static final int HALF_HOUR = 30 * 60;

	public static final int TWENTY_MINS = 20 * 60;

	public static final int ONE_HOUR = 60 * 60;

	public static final int THREE_HOUR = 3 * 60 * 60;

	/**
	 * 两分钟
	 */
	public static final int TWO_MINS = 2 * 60;

	/**
	 * 一天的时间
	 */
	public static final int ONE_DAY = 24 * 60 * 60;

	/**
	 * 半天的时间
	 */
	public static final int HALF_DAY = 12 * 60 * 60;

	/**
	 * 两天的时间
	 */
	public static final int TOW_DAY = 2 * 24 * 60 * 60;

	/**
	 * 一个周
	 */
	public static final int ONE_WEEK = 7 * 24 * 60 * 60;

	/**
	 * 一个月
	 */
	public static final int ONE_MONTH = 30 * 24 * 60 * 60;

	/**
	 * 二个月
	 */
	public static final int TWO_MONTH = 2 * 30 * 24 * 60 * 60;

	/**
	 * <pre>
	 * 	key = CUSTOMER
	 * 
	 * 	采用 key ,field , bean 的形式存储 CUSTOMERDO的信息,field是 (ID + customer_id)字段, bean CustomerDO对象
	 * </pre>
	 */
	public static final String CUSTOMER = "CUSTOMER";

	/**
	 * <pre>
	 * 	key = PRODUCT_VO, 考虑以后只存储PRODUCTDO 的bean?
	 * 
	 * 	采用 key ,field , bean 的形式存储 CUSTOMERDO --> CustomerVO的信息,field是 (ID + customer_id)字段, bean CustomerVO对象
	 * </pre>
	 */
	public static final String PRODUCT_VO = "PRODUCT_VO";

	/**
	 * <pre>
	 * 	key = PRODUCT, 只存储PRODUCTDO 的bean
	 * 
	 * 	采用 key ,field , bean 的形式存储 CUSTOMERDO的信息,field是 (ID + customer_id)字段, bean CustomerDO对象
	 * </pre>
	 */
	public static final String PRODUCT = "PRODUCT";
}
