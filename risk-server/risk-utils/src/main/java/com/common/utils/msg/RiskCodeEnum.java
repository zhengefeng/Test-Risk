package com.common.utils.msg;

/**
 * 
 * @author chenwenhai
 *
 */
public enum RiskCodeEnum {
	// 全局成功和失败
	SUC("0000", "suc"),

	// 添加全局失败
	FAIL("1000", "fail"),

	ERR_LOGIN("0001", "用户未登录"),

	ERR("9999", "系统异常，请稍后尝试"),

	INVOKE_PNR_SYSTEM_ERROR("9998", "调用存管系统出现网络异常"),

	COMMON_9996("9996", "未找到参数配置项"),

	ERR_FROZE_LOGIN_PASSWORD("0002", "用户登陆密码错误被锁定"),

	ERR_LOGIN_LOCKED("0003", "用户被锁定"),

	ERR_FROZE_RISK("0004", "您的账户已被冻结，如需帮助请咨询客服！"),

	ERR_USER_DEFINED_COMMON("9898", "系统异常"),

	ERR_VALIDATE_COMMON("5555", "参数验证错误"),

	ERR_UNAUTHORIZED("403", "请咨询管理员进行授权"),

	ERR_UPGRADE("407", "根据当前版本号找不到任何版本信息！"),

	// 客户：
	CUST_1001("1001", "输入手机号和发送验证码的手机号不匹配"),

	CUST_1002("1002", "请输入正确的手机号"),

	CUST_1003("1003", "发送短信校验失败"),

	CUST_1004("1004", "用户注册失败"),

	CUST_1005("1005", "用户名已经存在"),

	CUST_1006("1006", "两次新密码输入不一致"),

	CUST_1007("1007", "短信验证码校验失败"),

	CUST_1008("1008", "手机号码已被注册"),

	CUST_1009("1009", "用户查询失败"),

	CUST_1010("1010", "请输入用户名"),

	CUST_1011("1011", "短信发送失败,请重试"),

	CUST_1012("1012", "未查到用户信息"),

	CUST_1013("1013", "账号或密码错误"),

	CUST_1015("1015", "新密码和旧密码一样"),

	CUST_1016("1016", "修改登陆密码错误"),

	CUST_1017("1017", "用户登陆失败"),

	CUST_1018("1018", "短信验证码已经失效"),

	CUST_1019("1019", "身份证校验错误"),

	CUST_1020("1020", "修改登录密码失败"),

	CUST_1021("1021", "登录密码有误"),

	CUST_1022("1022", "重置登录密码失败"),

	CUST_1023("1023", "请输入本人注册手机号"),

	CUST_1024("1024", "请输入正确的手机号码"),

	CUST_1025("1025", "请指定短信类型"),

	CUST_1026("1026", "请输入正确的手机号码"),

	CUST_1027("1027", "请输入密码"),

	CUST_1028("1028", "请输入确认密码"),

	CUST_1029("1029", "请输入验证码"),

	CUST_1030("1030", "请指定验证码id"),

	CUST_1031("1031", "用户名已经存在"),

	CUST_1032("1032", "请输入登录密码"),

	CUST_1033("1033", "该用户不存在"),

	CUST_1034("1034", "请输入正确的验证码"),

	CUST_1035("1035", "两次密码输入不一致"),

	CUST_1036("1036", "请输入身份证号码"),

	CUST_1037("1037", "您输入的验证码不正确，请重新输入！"),

	CUST_1038("1038", "您输入的身份证信息不正确！"),

	CUST_1039("1039", "您输入的手机号与密码不匹配"),

	CUST_1040("1040", "您输入的密码不正确,您还有3次机会！"),

	CUST_1041("1041", "您输入的密码不正确,您还有2次机会！"),

	CUST_1042("1042", "您输入的密码不正确,您还有1次机会！"),

	CUST_1043("1043", "由于您连续5次输错登录密码，您的账户被锁定2个小时！"),

	CUST_1084("1084", "用户未绑卡!"),

	CUST_1086("1086", "当前页数不能为空!"),

	CUST_1087("1087", "每页大小不能为空!");

	private String code, name;

	RiskCodeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String toString() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public static RiskCodeEnum valueByKey(String code) {
		for (RiskCodeEnum enu : RiskCodeEnum.values()) {
			if (enu.getCode().equals(code)) {
				return enu;
			}
		}
		return null;
	}
}
