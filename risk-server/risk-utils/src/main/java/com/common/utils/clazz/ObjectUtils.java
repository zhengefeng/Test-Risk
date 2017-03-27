package com.common.utils.clazz;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类对象工具类
 * 
 * @author zhuxinyu.carter
 * @version $Id: ObjectUtils.java, v 0.1 2016 下午6:02:22 zhuxinyu.carter Exp $
 */
public class ObjectUtils {

	private static final Logger logger = LoggerFactory.getLogger(ObjectUtils.class);

	/**
	 * 将源对象转换成目标对象
	 * 
	 * @param source
	 *            - 源对象
	 * @param clazz
	 *            - 目标对象的类
	 * @return T - 目标对象
	 */
	public static <T> T convertSourceToTarget(Object source, Class<T> clazz) {
		T target = null;
		try {
			target = clazz.newInstance();
			BeanUtils.copyProperties(target, source);
		} catch (Exception e) {
			logger.error("bean convert error", e);
			throw new RuntimeException("参数转换错误");
		}

		return target;
	}

	/**
	 * 将Map对象转换成指定的类对象，该类必须是public的类
	 * 
	 * @param map
	 *            - map数据
	 * @param clazz
	 *            - 将要把map转换成的目标类
	 * @return T - 目标类
	 */
	public static <T> T parseMapToObject(Map<String, String> map, Class<T> clazz) {
		T obj = null;
		try {
			obj = clazz.newInstance();
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			logger.error("parseMapToObject - 失败", e);
			throw new RuntimeException("参数转换错误");
		}

		return obj;
	}

	/**
	 * 将object对象转换成map对象
	 * 
	 * @param object
	 *            - object对象
	 * @param ignores
	 *            - object对象中忽略的参数
	 * @return map - 转换出来的map对象
	 */
	public static Map<String, Object> objectToMap(Object object, String... ignores) {
		Map<String, Object> map = null;

		try {
			if (object != null) {
				Field fs[] = object.getClass().getDeclaredFields();
				map = new LinkedHashMap<String, Object>();
				for (Field f : fs) {
					f.setAccessible(true);
					if (!StringUtils.equalsIgnoreCase("serialVersionUID", f.getName())) {
						map.put(f.getName(), f.get(object));
					}
				}
			} else {
				map = Collections.emptyMap();
			}
		} catch (Exception e) {
			logger.error("toStringMap - 失败", e);
			throw new RuntimeException("参数转换错误");
		}

		return map;
	}
	
	/**
	 * 将object对象转换成map对象,map中key的首字母大写
	 * 
	 * @param object
	 *            - object对象
	 * @param ignores
	 *            - object对象中忽略的参数
	 * @return map - 转换出来的map对象
	 */
	public static Map<String, Object> objectToCapitalizeKeyMap(Object object, String... ignores) {
		Map<String, Object> map = null;

		try {
			if (object != null) {
				Field fs[] = object.getClass().getDeclaredFields();
				map = new LinkedHashMap<String, Object>();
				for (Field f : fs) {
					f.setAccessible(true);
					if (!StringUtils.equalsIgnoreCase("serialVersionUID", f.getName())) {
						map.put(StringUtils.capitalize(f.getName()), f.get(object));
					}
				}
			} else {
				map = Collections.emptyMap();
			}
		} catch (Exception e) {
			logger.error("toStringMap - 失败", e);
			throw new RuntimeException("参数转换错误");
		}

		return map;
	}
	
	public static <T> List<T> copyListObj(List<?> list, Class<T> target) {
		List<T> result = new ArrayList<T>(30);
		for(Object obj : list) {
			try {
				T res = target.newInstance();
				BeanUtils.copyProperties(res, obj);
				result.add(res);
			} catch (Exception e) {
				logger.error("转换error " + e);
				throw new RuntimeException("参数转换错误");
			}
		}
		return result;
	}
}
