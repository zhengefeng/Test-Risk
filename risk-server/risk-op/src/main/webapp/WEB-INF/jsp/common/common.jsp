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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${basePath}/resources/ui/amazeui/i/qmcaifu.jpg">
<link rel="stylesheet" href="${basePath}/resources/ui/amazeui/css/amazeui.min.css" />
<link rel="stylesheet" href="${basePath}/resources/ui/amazeui/css/admin.css">
<!-- <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.css"> -->
<link rel="stylesheet" href="${basePath}/resources/ui/amazeui/datatables/amazeui.datatables.css"/>
<link type="text/css" rel="stylesheet" href="${basePath}/resources/js/uploadify/css/uploadify.css">
<link type="text/css"  rel="stylesheet" href="${basePath}/resources/ui/amazeui/datetimepicker/css/amazeui.datetimepicker.css"/>
<script>
	basePath = '${basePath}';
</script>