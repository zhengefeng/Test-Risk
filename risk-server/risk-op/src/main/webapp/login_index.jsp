<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<title>Login Page | 全民征信后台管理系统</title>
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="am-g">
			<h1>征信 后台管理平台</h1>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录&nbsp;&nbsp;&nbsp;&nbsp;<label style="color: red">*</label></h3>
			<hr>
			<form method="post" class="am-form" action="" id="logonForm" onsubmit="return dosubmit()">
				<label for="email">用户名:</label> <input type="text" name="userName" id="userName" autocomplete="off" autofocus="autofocus"> <br> 
				
				<label for="password">密码:</label> <input type="password" name="password" id="password" > <br> 
				
					<label for="validImgCode">验证码:</label>
				<div class="am-form-inline">
					<div class="am-form-group" style="width: 80%">
						<input type="text" name="validImgCode" id="validImgCode" autocomplete="off">
					</div>
					<div class="am-form-group" style="width: 18%">
						<img alt="验证码" src="${basePath}/helper/validateImg?random=1" id="validImg">
					</div>
				</div>
				<br><br>

				<label for="remember-me"><input id="remember-me" type="checkbox" checked="checked">记住用户名</label> <br />
				
				<div class="am-cf">
					<input type="submit" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl" id="logonButton"> 
					<input type="button" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr" data-am-popover="{content: '不要想了，联系管理员吧,哈哈'}">
				</div>
			</form>
			<hr>
			<p>版权所有 上海欣亨金融信息服务有限公司 沪ICP备 15000682号-1</p>
		</div>
	</div>

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="${basePath}/resources/ui/amazeui/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="${basePath}/resources/ui/amazeui/js/amazeui.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>