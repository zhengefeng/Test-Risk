package com.common.utils.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * @author zhuqiang
 * @version $Id: Base64Util.java, v 0.1 2015年12月31日 上午10:30:40 zhuqiang Exp $
 */
public class Base64Util {

	public static final String charset = "UTF-8";

	/**
	 * 编码
	 * 
	 * @param s
	 * @return
	 */
	public static String encoder(String s) {
		String result = null;
		try {
			result = new String(Base64.encodeBase64(s.getBytes(charset)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 解码
	 * 
	 * @param s
	 * @return
	 */
	public static String decoder(String s) {
		String result = null;
		try {
			result = new String(Base64.decodeBase64(s.getBytes(charset)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
