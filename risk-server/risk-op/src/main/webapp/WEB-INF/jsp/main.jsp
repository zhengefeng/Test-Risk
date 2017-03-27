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
<!doctype html>
<html class="no-js">
<head>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<title>全民财富征信后台管理平台</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<jsp:include page="/WEB-INF/jsp/common/menuPage.jsp"></jsp:include>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">首页</strong> / <small>快速导航</small>
				</div>
			</div>
			
			<h2 style="margin-left:2rem;margin-top:0rem">运营管理</h2>
			<ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
				<li><a href="${basePath}/goods/goods_info_query" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br />产品管理<br /></a></li>
				<li><a href="${basePath}/goods/goods_audit_query" class="am-text-secondary"><span class="am-icon-btn am-icon-product-hunt"></span><br />模板管理<br /></a></li>
				<li><a href="${basePath}/goods/goods_shelves_query" class="am-text-secondary"><span class="am-icon-btn am-icon-product-hunt"></span><br />商户管理<br /></a></li>
				<li><a href="${basePath}/member/userinfo/userinfo_query" class="am-text-success"><span class="am-icon-btn am-icon-user"></span><br />商户会员<br /></a></li>

			</ul>

		</div>
	</div>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
</html>
