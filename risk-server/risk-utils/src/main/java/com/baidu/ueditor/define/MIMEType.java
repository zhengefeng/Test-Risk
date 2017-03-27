package com.baidu.ueditor.define;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MIMEType {
	@SuppressWarnings("serial")
	public static final Map<String, String> types = new HashMap<String, String>() {
		{
			put("image/gif", ".gif");
			put("image/jpeg", ".jpg");
			put("image/jpg", ".jpg");
			put("image/png", ".png");
			put("image/bmp", ".bmp");
		}
	};

	public static String getSuffix(String mime) {
		if (StringUtils.contains(mime, ";")) {
			mime = StringUtils.substringBefore(mime, ";");
		}
		
		return MIMEType.types.get(mime);
	}
}
