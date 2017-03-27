package com.common.utils.cache;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.common.utils.cache.redis.RedisManager;

@Component
public class CacheFacade {

	@Autowired
	private RedisManager redisManager;

	private static final Logger logger = LoggerFactory.getLogger(CacheFacade.class);

	/*
	 * public CacheFacade(RedisManager redisManager) { this.redisManager = redisManager; }
	 */

	/**
	 * 设置值
	 * 
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 * @param second
	 *            - 值缓存时间
	 */
	public void setValue(String key, String value, int second) {
		try {
			redisManager.setex(key, second, value);
		} catch (Exception e) {
			logger.error("cacheValue - error", e);
		}
	}

	/**
	 * 设置值(javaBean, List)
	 * 
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 * @param second
	 *            - 值缓存时间 (0 永不失效)
	 */
	public boolean setObject(String key, Object object, int second) {
		boolean flag = true;
		try {
			String json = JSON.toJSONString(object);
			if (second <= 0) {
				redisManager.set(key, json);
			} else {
				redisManager.setex(key, second, json);
			}
		} catch (Exception e) {
			logger.error("cacheBean - error", e);
			flag = false;
		}

		return flag;
	}

	/**
	 * 设置值(javaBean, List)
	 * 
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 * @param second
	 *            - 值缓存时间 (0 永不失效)
	 */
	public boolean setStringMap(String key, Map<String, String> stringMap, int second) {
		boolean flag = true;
		try {
			redisManager.hmset(key, stringMap);
			if (second > 0) {
				redisManager.expire(key, second);
			}
		} catch (Exception e) {
			logger.error("cacheBean - error", e);
			flag = false;
		}
		return flag;
	}

	/**
	 * 设置值(javaBean, List)
	 * 
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 * @param second
	 *            - 值缓存时间 (0 永不失效)
	 */
	public <T> boolean setKeyFiedlBean(String key, String field, T bean, int second) {
		boolean flag = true;
		try {
			String json = JSON.toJSONString(bean);
			redisManager.hset(key, field, json);
			if (second > 0) {
				redisManager.expire(key, second);
			}
		} catch (Exception e) {
			logger.error("cacheBean - error", e);
			flag = false;
		}
		return flag;
	}

	/**
	 * 根据key获取对应的字符串value信息
	 * 
	 * @param key
	 *            - 键
	 * @return String - 值
	 */
	public String getValue(String key) {
		String value = null;
		try {
			value = redisManager.get(key);
		} catch (Exception e) {
			logger.error("getValue - error", e);
		}
		return value;
	}

	/**
	 * 根据key获取对应的Bean对象信息
	 * 
	 * @param key
	 *            - 键
	 * @return T - 对应键的Bean
	 */
	public <T> T getBean(String key, Class<T> clazz) {
		T object = null;
		try {
			String json = redisManager.get(key);
			object = JSON.parseObject(json, clazz);
		} catch (Exception e) {
			logger.error("getBean - error", e);
		}

		return object;
	}

	public <T> List<T> getListBean(String key, Class<T> beanClazz) {
		List<T> list = null;
		try {
			String json = redisManager.get(key);
			list = JSON.parseArray(json, beanClazz);
		} catch (Exception e) {
			logger.error("getListBean - error", e);
		}

		return list;
	}

	public Map<String, String> getStringMap(String key) {
		Map<String, String> map = null;
		try {
			map = redisManager.hgetAll(key);
		} catch (Exception e) {
			logger.error("getStringMap - error", e);
		}
		return map;
	}

	public String getStringMapValue(String key, String field) {
		String value = null;
		try {
			value = redisManager.hget(key, field);
		} catch (Exception e) {
			logger.error("getStringMapValue - error", e);
		}
		return value;
	}

	public <T> T getKeyFiedlBean(String key, String field, Class<T> beanClazz) {
		T bean = null;
		try {
			String json = redisManager.hget(key, field);
			bean = JSON.parseObject(json, beanClazz);
		} catch (Exception e) {
			logger.error("getKeyFiedlBean - error", e);
		}
		return bean;
	}
}
