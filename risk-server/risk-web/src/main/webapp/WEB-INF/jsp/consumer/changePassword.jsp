<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<title>修改登录密码</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<div class="changeP_content">
		<p class="changeP_titel"><a href="#">首页</a>>&nbsp<a href="#" style="color:#f24a39;">修改登录密码</a></p>
	   
	   <div class="set_pw">
	   	  <div class="inst1">
				<label for="pass_org"><em style="color: red;">*</em>原密码：</label>
				<input type="password" id="pass_org" placeholder="请输入原密码"  class="required" onblur="checkOrgPassword(this)"/>
				<p  class="err_tips" id="pass_org_tips" style="display:none;">请输入原密码</p>
          </div>

          <div class="inst1">
				<label for="pass_new"><em style="color: red;">*</em>新密码：</label>
				<input type="password" id="pass_new" placeholder="6-20位数字，字母"  class="required" onblur="checkNewPassword(this)"/>
				<p  class="err_tips" id="pass_new_tips" style="display:none;">请输入新密码</p>
          </div>

          <div class="inst1" style="margin-bottom:40px;">
				<label for="pass_again"><em style="color: red;">*</em>重复新密码：</label>
				<input type="password" id="pass_again" placeholder="请重复输入新密码"  class="required" onblur="checkAgainPassword(this)"/>
				<p  class="err_tips" id="pass_again_tips" style="display:none;margin-left:-71px;">请重复输入新密码</p>
          </div>
         
          <button class="confirm" onclick="okClick()">确认修改</button>
	   </div>

	</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function okClick(){
		var oldPassword = $("#pass_org").val();
		var newPassword = $("#pass_new").val();
		var confirmPassword = $("#pass_again").val();
		if($.trim(oldPassword).length <= 0){
			$("#pass_org_tips").show();
			return;
		}
		if($.trim(newPassword).length <= 0){
			$("#pass_new_tips").show();
			return;
		}else if($.trim(newPassword).length > 0 && $.trim(newPassword).length < 6){
			var message = "请输入6-20位数字，字母！";
			$("#pass_new_tips").html(message);
			$("#pass_new_tips").show();
			return;
		}
			
		if($.trim(confirmPassword).length <= 0){
			$("#pass_again_tips").show();
			return;
		}
		
		if(newPassword != confirmPassword){
			$("#pass_again_tips").html("新密码和重复新密码输入不一致！");
			$("#pass_again_tips").show();
			return;
		}
		
		// 前端校验完成，提交后台
		$.ajax({
			cache : true,
			type : "POST",
			dataType : 'json',
			url : basePath + "/consumer/changePassword",
			data : {oldPassword:oldPassword,newPassword:newPassword},
			async : false,
			error : function(request) {
				alert("修改失败！");
			},
			success : function(data) {
				if (data.code == "0000") {
					$("#addConsumer").hide();
					alert(data.msg);
				} else if (data.code == "0001") {
					alert(data.msg);
				} else {
					alert("修改失败！");
				}
			}
		});
	}
	
	// 原密码
	function checkOrgPassword(obj){
		if($.trim(obj.value).length > 0){
			$("#pass_org_tips").hide();
		}else{
			$("#pass_org_tips").show();
		}
	}
	
	// 新密码
	function checkNewPassword(obj){
		if($.trim(obj.value).length > 0){
			$("#pass_new_tips").hide();
		}else{
			$("#pass_new_tips").show();
		}
	}
	
	// 重复新密码
	function checkAgainPassword(obj){
		if($.trim(obj.value).length > 0){
			$("#pass_again_tips").hide();
		}else{
			$("#pass_again_tips").show();
		}
	}
</script>
</html>