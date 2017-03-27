<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!--[if lte IE 9]>
	<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
	  以获得更好的体验！</p>
	<![endif]-->

<header class="am-topbar admin-header">
	<div class="am-topbar-brand" onclick="window.location.href='${basePath}'" style="cursor: pointer;">
		<strong>全民财富</strong> <small>征信后台管理平台</small>
	</div>

	<button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
			<li class="am-dropdown" data-am-dropdown>
				<a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;"> 
					<span class="am-icon-users"></span>您好，${CURRENT_USER.userName}
					<span class="am-icon-caret-down"></span>
				</a>
				<ul class="am-dropdown-content">
					<!-- 
					<li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
					 -->
					<li><a href="${basePath}/updateSec"><span class="am-icon-cog"></span> 更改密码</a></li>
					
					<li><a href="${basePath}/logonOut?jid=<%=session.getId()%>"><span class="am-icon-power-off"></span> 安全退出</a></li>
				</ul></li>
			<li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-align-left"></span> <span class="admin-fullText" id="topFull">隐藏菜单栏</span></a></li>
		</ul>
	</div>
</header>