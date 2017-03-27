<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	int port = request.getServerPort();
	String basePath = null;
	if (port == 80) {
		basePath = request.getScheme() + "://"
				+ request.getServerName() + path + "";
	} else {
		basePath = request.getScheme() + "://"
				+ request.getServerName() + ":"
				+ request.getServerPort() + path + "";
	}

	request.setAttribute("basePath", basePath);
%>
<footer>
	<hr>
	<p class="am-padding-left">版权所有 上海欣亨金融信息服务有限公司 沪ICP备 15000682号-1</p>
</footer>


<script src="${basePath}/resources/ui/amazeui/js/jquery.min.js"></script>
<script src="${basePath}/resources/ui/amazeui/js/amazeui.min.js"></script>
<script src="${basePath}/resources/ui/amazeui/js/app.js"></script>
<script src="${basePath}/resources/js/layer2/layer.js"></script>
<script src="${basePath}/resources/js/layer2/extend/layer.ext.js"></script>
<script
	src="${basePath}/resources/ui/amazeui/datatables/amazeui.datatables.min.js"></script>
<script
	src="${basePath}/resources/ui/amazeui/datatables/dataTables.responsive.min.js"></script>
<script src="${basePath}/resources/ui/amazeui/datetimepicker/js/amazeui.datetimepicker.min.js"></script>
<script src="${basePath}/resources/ui/amazeui/datetimepicker/js/locales/amazeui.datetimepicker.zh-CN.js"></script>
<script src="${basePath}/resources/js/common-utils.js"></script>
<script src="${basePath}/resources/js/uploadify/js/jquery.uploadify.js"></script>
<script>
	$(document).ready(function() {
		initHeight();
	});


	
	function initHeight() {
		$('.admin-main .admin-content').css('min-height', $('.admin-main').height() + 'px');
	}
</script>

