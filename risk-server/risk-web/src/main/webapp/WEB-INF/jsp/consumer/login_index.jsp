<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	int port = request.getServerPort();
	String basePath = null;
	if (port == 80) {
		basePath = request.getScheme() + "://" + request.getServerName() + path + "";
	} else {
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
	}

	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script type="text/javascript" src="${basePath}/resources/js/jquery-1.10.2.min.js"></script>
<link rel="icon" type="image/png" href="${basePath}/resources/images/qmcaifu.jpg">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/login.css">
<title>征信登录页</title>
</head>
<body>
	<div class="login_content">
		<!--  ------------------------>
		<h1>全民财富征信系统</h1>
		<div class="login_enter">
		<form action="${basePath}/login/doLogin" method="post" id="loginForm" name="loginForm">
			<div class="login_left">
				<p class="p1">登录</p>

				<div class="inst">
					<label for="username">用户名：</label> <input type="text" id="username" value="${userLoginName}"
						placeholder="请输入用户名" class="required" name="loginname"/>
				</div>

				<div class="inst">
					<label for="pass1">密 &nbsp 码：</label> <input type="password"  value="${userLoginPassword}"
						id="pass1" placeholder="6-20位数字，字母" class="required" name="password" autocomplete="off"/>
				</div>

				<div class="inst inst-special">
					<label for="validImgCode">验证码：</label> <input type="text" name="validImgCode"
						id="validImgCode" placeholder="图形验证码" class="required" autocomplete="off"/>
					<p class="changedCode">
						<img alt="验证码" src="${basePath}/helper/validateImg?random=1" id="validImg">
					</p>
					<p class="change" onclick="changeImage()" style="cursor: pointer;margin-left: 200px;">换一个</p>
				</div>

				<!-- 这里放所有的错误提示 -->
				<p class="err_tips" style="display: none;">请输入图片中的验证码请输</p>
				<p class="err_tips" ><label style="color: red">${errorMessage}</label></p>
				<button type="submit" style="cursor:pointer">登录</button>
				<p class="forget_pass">忘记密码或申请账号</p>
			</div>
		</form>
			<div class="login_right">
				<p class="title">全民财富征信系统</p>
				<img src="${basePath}/resources/images/check.png" height="25" width="154">
			</div>
		</div>
		<!-- ------------------ -->
	</div>


	<div class="public_footer">
		<p>版权所有&nbsp&nbsp上海欣亨金融信息服务有限公司&nbsp&nbsp沪ICP备&nbsp&nbsp15000682号-1</p>
	</div>

	<!-- 遮罩 -->
	<div class="black-bg" style="display: none" id="blackbg"
		onclick="closePop()"></div>

	<!-- 去登录 -->
	<div class="popup" style="display: none" id="tips">
		<img src="${basePath}/resources/images/popup-close.png" width="13" height="13"
			class="popup-close" onclick="closePop()" /> <img src="${basePath}/resources/images/tip.png"
			height="64" width="64" / style="display: block; margin: 20px auto;">

		<p>
			如您忘记密码或者需要申请新系统账号<br>请联系公司系统管理员
		</p>

	</div>

	<script type="text/javascript">
		//弹窗
		function closePop() {
			$('#blackbg').hide();
			$('.popup').hide();
		}

		function openPop(id) {
			$('#blackbg').show();
			$('#' + id).show();

		}

		$(document).ready(function() {
			var a = document.documentElement.clientHeight;
			if (parseInt(a) < 750) {
				$(".login_enter").css("top", "20%");
				$(".public_footer").css("height", "50px");
				$(".login_content h1").css("top", "50px");
			}

			$(".forget_pass").click(function(event) {
				openPop("tips");
			});
			
			$('#validImg').click(function() {
				$(this).attr('src', "${basePath}/helper/validateImg?random=" + new Date());
			});

		});
		
		function changeImage(){
			$("#validImg").attr('src', "${basePath}/helper/validateImg?random=" + new Date());
		}
	</script>

</body>
</html>