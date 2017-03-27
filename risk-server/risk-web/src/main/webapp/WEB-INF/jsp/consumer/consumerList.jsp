<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.risk.dal.credit.entity.Consumer,com.common.utils.page.Pagination"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理</title>
</head>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<body>
	<div class="black-bg" style="display: none;"></div>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<div class="middle-width">
		<h3 class="title">
			<a href="#">首页<span>></span></a><a href="#">用户管理<span></span></a>
		</h3>
		<div class="content-bg">
			<div class="content-bg-middle">
				<div class="content-user-top" style="height: 110px;">
					<form class="form-import" id="searchForm" style="height: 80px;"
						action="${basePath }/consumer/consumerList">
						<div class="form-box">
							<p>
								<label>用户名</label><input type="text" name="loginname" />
							</p>
							<p>
								<label>姓名</label><input type="text" name="name" />
							</p>
						</div>
						<div class="form-box">
							<p>
								<label>手机号</label><input type="text" name="phone" />
							</p>
							<p>
								<label>邮箱</label><input type="text" name="mail" />
							</p>
						</div>
					</form>
					<div class="form-box-button" align="center" style="margin-left: 200px;">
						<p>
							<label></label>
							<button class="form-button" onclick="searchConsumers()">查询</button>
						</p>
						<p>
							<button class="form-button form-box-button-add"
								onclick="showAddConsumerWindow()">新增用户</button>
						</p>
					</div>

				</div>
				<div class="content-table" id="tableList">
					<table cellpadding="0" cellspacing="0" class="content-table-grid">
						<tr>
							<th>用户名</th>
							<th>姓名</th>
							<th>手机号</th>
							<th>邮箱</th>
							<th>公司</th>
							<th>角色</th>
							<th>状态</th>
							<th>处理</th>
						</tr>
						<c:forEach items="${data}" var="consumer">
							<tr>
								<input type="hidden" name="consumerId" id="consumerId" value='${consumer.id }'>
								<td id="loginname">${consumer.loginname}</td>
								<td id="name">${consumer.name}</td>
								<td>${consumer.phone}</td>
								<td>${consumer.mail}</td>
								<td>${consumer.companyname}</td>
								<td>
									<c:if test='${consumer.ranklevel ==1}'>管理员</c:if> 
	                        		<c:if test='${consumer.ranklevel ==2}'>普通用户</c:if>
	                        	</td>
								<td>
									<c:if test='${consumer.status==1}'>正常</c:if> 
									<c:if test='${consumer.status==2}'>已禁用</c:if>
								</td>
								<td class="dispose">
									<a onclick="showUpdateConsumerWindow(this,${consumer.id})">修改用户</a>
									<a onclick="showResetPasswordWindow(this,${consumer.id})">重置密码</a>
									<a onclick="disableConsumer(this,${consumer.id},${consumer.status})">${consumer.status == 1 ? '禁用':'启用'}用户</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="page" id="pageDiv">
					<% 
				    Pagination<Consumer, Consumer> pageView = (Pagination<Consumer, Consumer>)request.getAttribute("page");
				    if(pageView.getTotalCount() > 0){
				    	Integer pageSizeView = (Integer)request.getAttribute("pageSize");
				    	String jsp  = "";
					    String webContextPath = (String)request.getAttribute("basePath");
					    Integer pageCount = (pageView.getTotalCount()+pageSizeView-1)/pageSizeView ;
					    Integer currentPage = pageView.getCurrentPage();
					    Integer prePage = currentPage - 1;
					    Integer nextPage = currentPage +1;
					    jsp += "<a href='"+webContextPath+"/consumer/consumerList?currentPage="+prePage+"'";
					    if(currentPage == 1){
					    	jsp += " onclick='return false;'";
					    }
					    jsp += ">&lt;</a>&nbsp;";
					    if(pageCount <= 5 || currentPage <= 3){
					    	for(int i=0;i<pageCount;i++){
						    	int currentPageView = i+1;
						    	jsp += "<a href='"+webContextPath+"/consumer/consumerList?currentPage="+currentPageView+"'";
						    	if(currentPage == currentPageView){
						    		jsp += " class='current'>";
						    	}else{
						    		jsp += ">";
						    	}
						    	jsp += currentPageView;
						    	jsp += "</a>&nbsp;";
						    }
					    }else{
					    	for(int i=0;i<5;i++){
					    		int currentPageView = 1;
					    		if(pageCount-currentPage<2){
					    			currentPageView = pageCount-4+i;
					    		}else{
					    			currentPageView = currentPage-2+i;
					    		}
					    		
					    		jsp += "<a href='"+webContextPath+"/consumer/consumerList?currentPage="+currentPageView+"'";
						    	if(currentPage == currentPageView){
						    		jsp += " class='current'>";
						    	}else{
						    		jsp += ">";
						    	}
						    	jsp += currentPageView;
						    	jsp += "</a>&nbsp;";
					    	}
					    }
				    	
					    jsp += "<a href='"+webContextPath+"/consumer/consumerList?currentPage="+nextPage+"'";
					    if(currentPage == pageCount){
					    	jsp += " onclick='return false'";
					    }
					    jsp += ">&gt;</a>&nbsp;";
					    jsp += "<span>";
					    jsp += "共<label id='pageCount'>"+pageCount+"</label>页&nbsp;, 跳转到&nbsp;";
					    jsp += "</span>";
					    out.write(jsp);
				    }
 				    %>
				    
				    <input type="text" id="gotoPageNumber" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " 
				    	onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " style="text-align: center;"/>&nbsp;
				    <a class="page-confirm" onclick="goPage()">确定</a>
				</div>
			</div>
			<!--content-bg-middle-->
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
	<!--新增系统用户弹窗-->
	<div class="popup" style="display: none;"
		id="addConsumer">
		<img src="${basePath}/resources/images/popup-close.png"
			class="popup-close" onclick="addCloseClick()" />
		<h2 class="pop-title">新增系统用户</h2>
		<form class="form-import popup-form-import" id="addForm">
			<div class="form-box">
				<p>
					<label><em>*</em>用户名</label><input type="text" name="loginname" />
				</p>
				<p>
					<label><em>*</em>姓名</label><input type="text" name="name" />
				</p>
			</div>
			<div class="form-box">
				<p>
					<label>手机号</label><input type="tel" name="phone" maxlength="11"  
						onkeyup="this.value=this.value.replace(/[^\d]/g,'') " 
				    	onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
				</p>
				<p>
					<label>邮箱</label><input type="email" name="mail" maxlength="30" />
				</p>
			</div>
			<div class="form-box">
				<p class="mt15">
					<label>所属公司</label>
					<span>${___user.companyname}</span> 
				</p>
				<p>
					<label><em>*</em>角色</label> <select name="ranklevel">
						<option value="1">管理员</option>
						<option value="2" selected="selected">普通用户</option>
					</select>
				</p>
			</div>
			<div class="form-box">
				<p>
					<label><em>*</em>初始密码</label><input type="password" name="password" />
				</p>
				<p>
					<label><em>*</em>确认密码</label><input type="password" name="confirmpassword" />
				</p>
			</div>
		</form>
		<p>
			<button class="form-button" onclick="addConsumer()"
				style="margin-left: 250px; margin-top: 50px;">保存</button>
		</p>
	</div>



	<!--修改用户弹窗-->
	<div class="popup" style="display: none;" id="updateConsumerWindow">
		<img src="${basePath}/resources/images/popup-close.png"
			class="popup-close" onclick="updateCloseClick()" />
		<h2 class="pop-title">修改用户</h2>
		<form class="form-import popup-form-import" id="updateForm">
			<input type="hidden" name="updateId" id="updateId"></input>
			<div class="form-box">
				<p class="mt15">
					<label>用户名</label><span name="updateLoginName" id="updateLoginName"></span>
				</p>
				<p>
					<label>姓名</label><input type="text" name="updateName"
						id="updateName" />
				</p>
			</div>
			<div class="form-box">
				<p>
					<label>手机号</label><input type="tel" name="updatePhone" maxlength="11"
						id="updatePhone" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " 
				    	onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
				</p>
				<p>
					<label>邮箱</label><input type="email" name="updateMail"
						id="updateMail" />
				</p>
			</div>
			<p>
				<button class="form-button" onclick="updateConsumer()">保存</button>
			</p>
		</form>
	</div>


	<!--重置用户密码弹窗-->
	<div class="popup" style="display: none;" id="resetPasswordWindow">
		<img src="${basePath}/resources/images/popup-close.png"
			class="popup-close" onclick="resetPasswordCloseClick()" />
		<h2 class="pop-title">重置用户密码</h2>
		<form class="form-import popup-form-import" id="resetForm">
			<input type="hidden" id="resetPasswordConsumerId"></input>
			<div class="form-box">
				<p class="mt15">
					<label>用户名</label><span name="resetLoginName" id="resetLoginName"></span>
				</p>
				<p class="mt15">
					<label>姓名</label><span name="resetName" id="resetName"></span>
				</p>
			</div>
			<div class="form-box">
				<p>
					<label>重置密码</label><input type="password" name="resetPassword"
						id="resetPassword" />
					<p  class="err_tips" id="pass_new_tips" style="display:none;">请输入密码</p>
				</p>
				<p>
					<label>确认密码</label><input type="password"
						name="resetConfirmPassword" id="resetConfirmPassword" />
				</p>
				<p  class="err_tips" id="pass_again_tips" style="display:none;margin-left:-71px;">请输入确认密码</p>
			</div>
		</form>
			<p>
				<button class="form-button" style="margin-left: 250px;margin-top: 50px;" onclick="saveResetPassword()">保存</button>
			</p>
		
	</div>
	<script type="text/javascript">
	
		// 新增用户显示弹框
		function showAddConsumerWindow() {
			// 查询所述公司
			$.ajax({
				cache : true,
				type : "POST",
				dataType : 'json',
				url : basePath + "/company/companyList",
				async : false,
				success : function(data) {
					alert(data.data);
					if (data.code == "0000") {
						$("#addConsumer").hide();
						layer.msg(data.msg, {icon: 1});
						window.location.href = "${basePath}/consumer/consumerList";
					} else if (data.code == "0001") {
						layer.msg(data.msg, {icon: 2});
					} else {
						layer.msg("新增失败！", {icon: 2});
					}
				}
			});
			var option = "<option value='1'>上海欣亨22</option><option value='2'>江苏悦达22</option>";
			$("#companyid").html("");
			$("#companyid").html(option);
			$("#addConsumer").show();
			$(".black-bg").show();
		}

		// 新增用户
		function addConsumer() {
			$.ajax({
				cache : true,
				type : "POST",
				dataType : 'json',
				url : basePath + "/consumer/addConsumer",
				data : $('#addForm').serialize(),
				async : false,
				error : function(request) {
					layer.msg("新增失败！", {icon: 2});
				},
				success : function(data) {
					if (data.code == "0000") {
						$("#addConsumer").hide();
						layer.msg(data.msg, {icon: 1});
						window.location.href = "${basePath}/consumer/consumerList";
					} else if (data.code == "0001") {
						layer.msg(data.msg, {icon: 2});
					} else {
						layer.msg("新增失败！", {icon: 2});
					}
				}
			});
		}
		
		// 显示修改用户弹框
		function showUpdateConsumerWindow(obj,consumerId){
			var loginName = obj.parentNode.parentNode.cells[0].innerText;
			var name = obj.parentNode.parentNode.cells[1].innerText;
			var phone = obj.parentNode.parentNode.cells[2].innerText;
			var mail = obj.parentNode.parentNode.cells[3].innerText;
			$("#updateLoginName").html(loginName);
			$("#updateName").val(name);
			$("#updatePhone").val(phone);
			$("#updateMail").val(mail);
			$("#updateId").val(consumerId);
			$("#updateConsumerWindow").show();
			$(".black-bg").show();
		}
		
		// 修改用户
		function updateConsumer() {
			var updateId = $("#updateId").val();
			var updateName = $("#updateName").val();
			var updatePhone = $("#updatePhone").val();
			var updateMail = $("#updateMail").val();
			$.ajax({
				cache : true,
				type : "POST",
				dataType : 'json',
				url : basePath + "/consumer/updateConsumer",
				data : {id:updateId,name:updateName,phone:updatePhone,mail:updateMail},
				async : false,
				error : function(request) {
					layer.msg("修改失败！", {icon: 2});
				},
				success : function(data) {
					if (data.code == "0000") {
						$("#addConsumer").hide();
						layer.msg(data.msg, {icon: 1});
						setTimeout(function(){							
							window.location.href = "${basePath}/consumer/consumerList";
						}, 1000);
					} else if (data.code == "0001") {
						layer.msg(data.msg, {icon: 2});
					} else {
						layer.msg("修改失败！", {icon: 2});
					}

				}
			});
		}

		// 查询用户列表
		function searchConsumers() {
			$.ajax({
				cache : true,
				type : "POST",
				dataType : 'json',
				url : basePath + "/consumer/queryConsumerList",
				data : $('#searchForm').serialize(),
				success : function(data) {
					$("#tableList").html("");
					var html = "";
					html += '<table cellpadding="0" cellspacing="0" class="content-table-grid">';
					html += '<tr>';
					html += '<th>用户名</th>';
					html += '<th>姓名</th>';
					html += '<th>手机号</th>';
					html += '<th>邮箱</th>';
					html += '<th>公司</th>';
					html += '<th>角色</th>';
					html += '<th>状态</th>';
					html += '<th>处理</th>';
					html += '</tr>';
					if(data.data.length > 0){
						var dataObj = data.data;
						for(var i=0;i<dataObj.length;i++){
							html += '<tr>';
							html += '	<input type="hidden" name="consumerId" id="consumerId" value='+dataObj[i].id+'>';
							html += '	<td id="loginname">'+dataObj[i].loginname+'</td>';
							html += '	<td id="name">'+dataObj[i].name+'</td>';
							html += '	<td>'+ (dataObj[i].phone == undefined ? "" : dataObj[i].phone) +'</td>';
							html += '	<td>'+(dataObj[i].mail == undefined ? "" : dataObj[i].mail)+'</td>';
							html += '	<td>'+(dataObj[i].companyname == undefined ? "" : dataObj[i].companyname)+'</td>';
							html += '	<td>';
								if(dataObj[i].ranklevel == 1){
									html += '管理员';
								}else if(dataObj[i].ranklevel == 2){
									html += '普通用户';
								}
	                        html += '	</td>';
							html += '	<td>';
								if(dataObj[i].status == 1){
									html += '正常';
								}else if(dataObj[i].status == 2){
									html += '已禁用';
								}
							html += '	</td>';
							html += '	<td class="dispose">';
							html += '		<a onclick="showUpdateConsumerWindow(this,'+dataObj[i].id+')">修改用户</a>';
							html += '		<a onclick="showResetPasswordWindow(this,'+dataObj[i].id+')">重置密码</a>';
							html += '		<a onclick="disableConsumer(this,'+dataObj[i].id+','+dataObj[i].status+')">';
								if(dataObj[i].status == 1){
									html += '禁用用户';
								}else if(dataObj[i].status == 2){
									html += '启用用户';
								}
							html += '		</a>';
							html += '	</td>';
							html += '</tr>';
						}
						// ********分页******************* //
						$("#pageDiv").html("");
						var pageObj = data.page;
						var paging = "";
						var pageSizeView = Number('${pageSize}');
					    var pageCount = parseInt((pageObj.totalCount + pageSizeView - 1) / pageSizeView);
					    var currentPage = Number(pageObj.currentPage);
					    var prePage = currentPage - 1;
					    var nextPage = currentPage +1;
					    paging += "<a href='"+basePath+"/consumer/consumerList?currentPage="+prePage+"'";
					    if(currentPage == 1){
					    	paging += " onclick='return false;'";
					    }
					    paging += ">&lt;</a>&nbsp;";
					    if(pageCount <= 5 || currentPage <= 3){
					    	for(var i=0;i<pageCount;i++){
						    	var currentPageView = i+1;
						    	paging += "<a href='"+basePath+"/consumer/consumerList?currentPage="+currentPageView+"'";
						    	if(currentPage == currentPageView){
						    		paging += " class='current'>";
						    	}else{
						    		paging += ">";
						    	}
						    	paging += currentPageView;
						    	paging += "</a>&nbsp;";
						    }
					    }else{
					    	for(var i=0;i<5;i++){
					    		var currentPageView = 1;
					    		if(pageCount-currentPage<2){
					    			currentPageView = pageCount-4+i;
					    		}else{
					    			currentPageView = currentPage-2+i;
					    		}
					    		
					    		paging += "<a href='"+basePath+"/consumer/consumerList?currentPage="+currentPageView+"'";
						    	if(currentPage == currentPageView){
						    		paging += " class='current'>";
						    	}else{
						    		paging += ">";
						    	}
						    	paging += currentPageView;
						    	paging += "</a>&nbsp;";
					    	}
					    }
				    	
					    paging += "<a href='"+basePath+"/consumer/consumerList?currentPage="+nextPage+"'";
					    if(currentPage == pageCount){
					    	paging += " onclick='return false'";
					    }
					    paging += ">&gt;</a>&nbsp;";
					    paging += "<span>";
					    paging += "共<label id='pageCount'>"+pageCount+"</label>页&nbsp;, 跳转到&nbsp;";
					    paging += "</span>";
					    paging += "<input type='text' id='gotoPageNumber' onkeyup='this.value=this.value.replace(/[^\d]/g,\"\")'"; 
					    paging += "	onafterpaste='this.value=this.value.replace(/[^\d]/g,\"\")' style='text-align: center;'/>&nbsp;";
					    paging += "<a class='page-confirm' onclick='goPage()'>确定</a>";
					    $("#pageDiv").html(paging);
						////////////////////////////////////
						
						
					}else{
						$("#pageDiv").html("");
					}
					html += '</table>';
					$("#tableList").html(html);
				},
				error : function(request) {
					layer.msg("查询失败！", {icon: 2});
				}
			});
		}
		
		// 显示重置密码弹框
		function showResetPasswordWindow(obj, consumerId){
			var loginName = obj.parentNode.parentNode.cells[0].innerText;
			var name = obj.parentNode.parentNode.cells[1].innerText;
			$("#resetLoginName").html(loginName);
			$("#resetName").html(name);
			$("#resetPasswordConsumerId").val(consumerId);
			$("#resetPasswordWindow").show();
			$(".black-bg").show();
		}
		
		// 保存重置密码
		function saveResetPassword(){
			var resetId = $("#resetPasswordConsumerId").val();
			var resetPassword = $("#resetPassword").val();
			var resetConfirmPassword = $("#resetConfirmPassword").val();
// 			if($.trim(resetPassword).length <= 0){
// 				$("#pass_new_tips").show();
// 				return;
// 			}else if($.trim(resetPassword).length > 0 && $.trim(resetPassword).length < 6){
// 				var message = "请输入6-20位数字，字母！";
// 				$("#pass_new_tips").html(message);
// 				$("#pass_new_tips").show();
// 				return;
// 			}
// 			if(resetPassword != resetConfirmPassword){
// 				$("#pass_again_tips").html("2次密码输入不一致！");
// 				$("#pass_again_tips").show();
// 				return;
// 			}
			$.ajax({
				cache : true,
				type : "POST",
				dataType : 'json',
				url : basePath + "/consumer/resetConsumer",
				data : {id:resetId, password:resetPassword},
				error : function(request) {
					layer.msg("重置失败1！", {icon: 2});
				},
				success : function(data) {
					if (data.code == "0000") {
						layer.msg("重置成功！", {icon: 1});
						$("#resetPasswordConsumerId").val(null);
						$("#resetPassword").val(null);
						$("#resetConfirmPassword").val(null);
						$("#resetPasswordWindow").hide();
						$(".black-bg").hide();
					} else {
						layer.msg("重置失败2！", {icon: 2});
					}
				}
			});	
		}
		
		function disableConsumer(obj, consumerId, currentStatus){
			var messageTitle = "";
			var status = 1;
			var returnSuccessMessage = "";
			var returnFailMessage = "";
			if(currentStatus == '1'){
				messageTitle = "您确定要禁用该用户吗？";
				status = 2;
				returnSuccessMessage = "禁用成功！";
				returnFailMessage = "禁用失败！";
			}else if(currentStatus == '2'){
				messageTitle = "您确定要启用该用户吗？";
				status = 1;
				returnSuccessMessage = "启用成功！";
				returnFailMessage = "启用失败！";
			}
			//确认框
	        layer.confirm(messageTitle, {
	        	skin: 'layui-layer-lan',
	            btn: ['确定','取消'] //按钮
	        }, function(){
				var id = 0;
				$.ajax({
					cache : true,
					type : "POST",
					dataType : 'json',
					url : basePath + "/consumer/disableConsumer",
					data : {id:consumerId, status:status},
					error : function(request) {
						layer.msg(returnFailMessage, {icon: 2});
					},
					success : function(data) {
						if (data.code == "0000") {
							layer.msg(returnSuccessMessage, {icon: 1});	
							setTimeout(function(){
								window.location.href = "${basePath}/consumer/consumerList";
							}, 1000);
						} else {
							layer.msg(returnFailMessage, {icon: 2});
						}
					}
				});	
	            
	        }, function(){
	        	
	        });
		}
		
		
		// 添加用户关闭弹出
		function addCloseClick() {
			$("#addConsumer").hide();
			$(".black-bg").hide();
		}
		
		// 修改用户关闭弹出
		function updateCloseClick() {
			$("#updateConsumerWindow").hide();
			$(".black-bg").hide();
		}
		
		// 重置密码关闭弹出
		function resetPasswordCloseClick() {
			$("#resetPasswordWindow").hide();
			$(".black-bg").hide();
		}
		
		function goPage(){
			var gotoPage = $("#gotoPageNumber").val();
			var pageCount = $("#pageCount").html();
			if($.trim(gotoPage).length<=0){
				layer.msg("请输入跳转的页数！", {icon: 3});
			}else{
				if(parseInt(gotoPage) > parseInt(pageCount)){
					layer.msg("您输入的页数不存在！", {icon: 5});
				}else{
					window.location.href = "${basePath}/consumer/consumerList?currentPage="+gotoPage;
				}
			}
		}
	</script>
</body>
</html>
