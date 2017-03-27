<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/info.css">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="${ctx}/resources/js/layer2/layer.js"></script>
	<title>模板管理</title>
	<script type="text/javascript">

		function fukcLoadIt(id) {
			var url = '${ctx}/template/report-template/'+id;
			layer.open({
				type: 2,
				title: '报告样例',
				shadeClose: true,
                offset: ['100px', '200px'],
				shade: 0.8,
				area: ['80%', '80%'],
				content: url
			});
		}

	</script>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>

	<div class="changeP_content">
		<p class="changeP_titel">&nbsp<a href="#">首页</a>>&nbsp<a href="#">报告查询</a>>&nbsp<a style="color:#f24a39;" href="#">模板管理</a></p>
	   
	   <ul>
		   <c:forEach items="${templateList}" var="it">
			   <c:choose>
				   <c:when test="${it.status == 1}">
					   <%--正常模板--%>
					   <li>
						   <h3>${it.tempname}</h3>

						   <p style="margin-top:20px;font-size:18px;color:#666;"><span style="font-size:40px;color:#f24a39;">${it.totalprice}</span>元</p>
						   <a href="${ctx}/template/update-status?id=${it.id}&status=2">
							   <button class="stop_modle" style="cursor: pointer;">停用模板</button>
						   </a>
						   <div class="demo_detail"><a href="javascript:void(0);" onclick="fukcLoadIt(${it.id})" style="cursor: pointer;">查看报告样例</a></div>
					   </li>
				   </c:when>

				   <%--禁用的模板--%>
				   <c:when test="${it.status == 2}">
					   <li style="background-color:#f9f9f9;">
						   <h3 >${it.tempname}</h3>

						   <p style="margin-top:20px;font-size:18px;color:#ccc;"><span style="font-size:40px;color:#f24a39;">${it.totalprice}</span>元</p>
						   <a href="${ctx}/template/update-status?id=${it.id}&status=1">
							   <button class="open_modle11" style="cursor: pointer;">启用模板</button>
						   </a>
						   <div class="demo_detail"><a href="javascript:void(0);" onclick="fukcLoadIt(${it.id})" style="cursor: pointer;">查看报告样例</a></div>
					   </li>

				   </c:when>
			   </c:choose>

		   </c:forEach>

	   	   <li style="background-color:#f9f9f9;">
			   <a href="${ctx}/template/add-init">
	   	   	<p style="font-size:80px;color:#ccc;margin-top:80px;">+</p>
	   	   	<p style="font-size:14px;color:#999;">新增模板</p>
			   </a>
	   	       
	   	   </li>

	   </ul>

	</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>

</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		$(".changeP_content ul li:nth-child(4n)").css("margin-right",0);
	});
</script>