package com.risk.op.helper;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.common.utils.constant.GlobalConstance;
import com.common.utils.exception.RiskRunTimeException;
import com.google.code.kaptcha.Producer;

@Controller
@RequestMapping("helper")
public class SystemHelperController {

	@Autowired
	@Qualifier("kaptchaProducer")
	private Producer kaptchaProducer;

	@RequestMapping("validateImg")
	public void showValidateImg(HttpServletRequest httpRequest, HttpServletResponse httpResponse, String random) throws IOException {
		try {
			System.setProperty("java.awt.headless", "true");
			
			httpResponse.setDateHeader("Expires", 0L);
			httpResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			httpResponse.addHeader("Cache-Control", "post-check=0, pre-check=0");
			httpResponse.setHeader("Pragma", "no-cache");
			httpResponse.setContentType("image/jpeg");

			String capText = (String) WebUtils.getSessionAttribute(httpRequest, GlobalConstance.USER_AUTH_CODE);
			if (StringUtils.isBlank(capText) || !StringUtils.equalsIgnoreCase("random", "1")) {// 暂时不清楚为什么在火狐浏览器下会产生重复加载的事情,后期这种判断必须干掉
				capText = kaptchaProducer.createText();
			}

			WebUtils.setSessionAttribute(httpRequest, GlobalConstance.USER_AUTH_CODE, capText);

			BufferedImage bi = this.kaptchaProducer.createImage(capText);
			ServletOutputStream out = httpResponse.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			try {
				out.flush();
			} finally {
				out.close();
			}
		} catch (Exception e) {
			throw new RiskRunTimeException("验证码生成错误", e);
		} catch (Throwable e) {
			throw new RiskRunTimeException("验证码生成错误", e);
		}
	}
}
