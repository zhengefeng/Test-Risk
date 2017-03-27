<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" href="${ctx}/resources/css/common.css"/>
	<link rel="stylesheet" href="${ctx}/resources/css/info.css"/>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="${ctx}/resources/js/layer2/layer.js"></script>
	<title>选择报告模板</title>

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
	<p class="changeP_titel">首页>&nbsp<a href="#" style="color:#f24a39;">查询个人信用报告</a></p>
	   
	   <div class="modle_shoose">
	   	<span style="color:#fff;">选择报告模板</span>
	   	<span>输入被查询者信息</span>
	   	<span >生成信用报告</span>
	   </div>

	   <ul>
		   <c:forEach items="${templateList}" var="it">
	    	<li class="li_mode"> 
	   	        <h3>${it.tempname}</h3>

                <div class="allP">
				<c:forEach items="${it.types}" var="typeObj" varStatus="stat">
					<p style="font-size:18px;color:#666;line-height:30px;${stat.index == 0 ? 'margin-top:25px;' : ''}">
						${	typeObj.infoType==1 ? "信息验证" :
							typeObj.infoType==2 ? "信息查询" :
							typeObj.infoType==3 ? "风险名单" : "行为报告"}
					</p>
				</c:forEach>
                </div>

	   	        <p style="margin-top:10px;font-size:18px;color:#666;">
					<span style="font-size:50px;color:#f24a39;">${it.totalprice}</span>元
				</p>
				<a href="${ctx}/template/query-param/${it.id}">
	   	        	<button class="check_soon" style="cursor: pointer;">立即查询</button>
				</a>
	   	        <div class="demo_detail"><a href="javascript:void(0);" onclick="fukcLoadIt(${it.id})" style="cursor: pointer;">查看报告样例</a></div>
	   	    </li>
		   </c:forEach>
	   </ul>
	</div>

<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
<script type="text/javascript">
            $(document).ready(function() {
                $(".changeP_content ul li:nth-child(3n)").css("margin-right",0);
            });
</script>
</script>