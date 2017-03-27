<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%>
<div class="header">
    <div class="header-top-bg">
        <div class="middle-width">
            <ul class="header-top">
                <li><a href="#">${___user.name}</a>|</li>
                <li><a href="${ctx}/consumer/changePasswordPage">修改密码</a>|</li>
                <c:if test="${___user.ranklevel == 1}" >
                    <li class="system"><a href="#" style="" name="sysManage">系统管理</a>|
                        <ul class="system-nav" id="sysManageMenu" style="display: none">
                            <img src="${ctx}/resources/images/nav-top.png" style="position: absolute; top:-9px; left: 50px;" />
                            <li class="system-nav-user"><a href="${ctx}/consumer/consumerList">用户管理</a></li>
                            <li class="system-nav-mould"><a href="${ctx}/template/manage-index">模板管理</a></li>
                        </ul>
                    </li>
                </c:if>
                <li><a href="${basePath }/login/loginOut">退出</a></li>
            </ul>
        </div>
    </div>
    <div class="header-nav-bg">
        <div class="middle-width">
            <div class="header-nav-logo">
                <img src="${ctx}/resources/images/logo.png" />
            </div>
            <ul class="header-nav"> 
                <li id="templateMenu"><a href="${ctx}/template/query">报告查询</a></li>
                <li id="batchQueryMenu"><a href="${ctx}/batch/batchQuery">批量查询</a></li>
                <li id="queryRecordMenu"><a href="${ctx}/template-log/index">查询记录</a></li>
               
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
	
	$('a[name=sysManage]').hover(function(){
		$('#sysManageMenu').show();
	});
	
	$(".system").hover(function(){
	},function(){
		$(".system-nav").hide();
	})
	
	// 根据请求的uri设置菜单选中状态
	var requestURI = window.location.href;
	if(requestURI.indexOf("/template/") > 0){
	    $("#templateMenu").addClass('current');
	}else if(requestURI.indexOf("/batch/") > 0){
        $("#batchQueryMenu").addClass('current');
	}else if(requestURI.indexOf("/template-log/index") > 0){
        $("#queryRecordMenu").addClass('current');
	}
	
</script>
