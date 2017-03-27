package com.common.utils.exception;

/**
 * 商城运行异常，和系统业务息息相关
 * 
 * @author zhuxinyu.carter
 * @version $Id: MallException.java, v 0.1 2016年1月17日 下午1:28:09 zhuxinyu.carter Exp $
 */
public class RiskRunTimeException extends RuntimeException {

	private static final long serialVersionUID = -1376645320861107365L;

	private String errorCode;

	private String errorMsg;

	public RiskRunTimeException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public RiskRunTimeException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public RiskRunTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public String toString() {
		return "P2PRunTimeException[errorCode = " + errorCode + ",errorMsg = " + errorMsg + "]";
	}
}
