<%@ page language="java" import="java.util.*,org.springframework.web.util.UrlPathHelper,org.apache.commons.lang3.StringUtils" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<style>
li.selected {
  background-color: #F8F8F8;
}
li.selected2 {
  background-color: #F8F8F0;
}
</style>
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
	<div class="am-offcanvas-bar admin-offcanvas-bar">
		<ul class="am-list admin-sidebar-list" id="pli">
			<li><a href="${basePath}/login/main"><span class="am-icon-home"></span> 首页</a></li>
			<li><a href="${basePath}/product/list"><span class="am-icon-file"></span> 产品管理</a></li>
			<li><a href="${basePath}/template/list"><span class="am-icon-file"></span> 模板管理</a></li>
			<li><a href="${basePath}/company/list"><span class="am-icon-file"></span> 商户管理</a></li>
			<li><a href="${basePath}/consumer/list"><span class="am-icon-file"></span> 商户用户管理</a></li>
			<li><a href="${basePath}/adminuser/list"><span class="am-icon-file"></span> 后台用户管理</a></li>
		</ul>
		<div class="am-panel am-panel-default admin-sidebar-panel">
			<div class="am-panel-bd">
				<p>
					<span class="am-icon-bookmark"></span> 公告
				</p>
				<p>人生没有地图，<br>我们一路走，一路被辜负，一路点燃希望，一路寻找答案！—— 全民财富</p>
			</div>
		</div>
	</div>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
<script>
var showMenu = sessionStorage.getItem("showMenu");
if(showMenu=="1"){
	document.getElementById("admin-offcanvas").style.display="none";
	document.getElementById("topFull").innerHTML="显示菜单栏";
}else{
	document.getElementById("admin-offcanvas").style.display="";
	document.getElementById("topFull").innerHTML="隐藏菜单栏";
}
</script>