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
	request.setAttribute("requestURI", request.getRequestURI());
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${basePath}/resources/images/qmcaifu.jpg">
<link rel="stylesheet" href="${basePath}/resources/css/common.css" />
<link rel="stylesheet" href="${basePath}/resources/css/credit.css" />
<link rel="stylesheet" href="${basePath}/resources/css/info.css" />
<script src="${basePath}/resources/script/jquery-1.10.2.min.js"></script>
<script src="${basePath}/resources/js/jquery-form.js"></script>
<script src="${basePath}/resources/js/layer2/layer.js"></script>
<script src="${basePath}/resources/js/layer2/extend/layer.ext.js"></script>
<script>
	basePath = '${basePath}';
</script>