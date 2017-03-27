package com.common.utils.codec;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

/**
 * MD5加密工具
 * 
 * @author Super Jens Wang
 * @version 1.0 $id: Md5Utils.java 2016年6月20日 下午4:15:54 Wang Le $
 */
public class Md5Utils {

	public static String md5Encrypt(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte buffer[] = input.getBytes();
			md.update(buffer);
			byte bDigest[] = md.digest();
			md.reset();
			BigInteger bi = new BigInteger(1, bDigest);
			return bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String md5Encrypt32(String input) {
		String decString = md5Encrypt(input);
		String declowerStr = decString.toLowerCase();
		if (StringUtils.isNotBlank(decString)) {
			return StringUtils.leftPad(declowerStr, 32);
		}
		return null;
	}

	/**
	 * 约定
	 * 
	 * @param input
	 * @return
	 */
	public static String md5Encrypt4Dist(String validKey, String requestTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(validKey).append("$qmcf$").append(requestTime);
		String decString = md5Encrypt(sb.toString());
		String declowerStr = decString.toLowerCase();
		if (StringUtils.isNotBlank(decString)) {
			return StringUtils.leftPad(declowerStr, 32);
		}
		return null;
	}

	public static String md5Encrypt4Dist4weijin(String validKey, String requestTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(validKey).append("$qmcf$").append(requestTime);
		String decString = md5Encrypt(sb.toString());
		String declowerStr = decString.toLowerCase();
		if (StringUtils.isNotBlank(decString)) {
			return StringUtils.leftPad(declowerStr, 32, '0');
		}
		return null;
	}

	/**
	 * 约定
	 * 
	 * @param
	 * @return
	 */
	public static String md5Encrypt4DistSpe(String validKey, String bd, String ed) {
		StringBuilder sb = new StringBuilder();
		sb.append(validKey).append(bd).append(ed);
		String decString = md5Encrypt(sb.toString());
		String declowerStr = decString.toLowerCase();
		if (StringUtils.isNotBlank(decString)) {
			return StringUtils.leftPad(declowerStr, 32);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(md5Encrypt4Dist("1c8512ca204b43c2a73323b3c4aee5d6", "20150601115807"));
		char cn = 'A';
		System.out.println(cn);
		int cnInt = 155;
		System.out.println((char) cnInt);
	}
}
