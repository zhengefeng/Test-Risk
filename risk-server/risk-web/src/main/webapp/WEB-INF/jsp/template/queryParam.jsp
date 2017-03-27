<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/common.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/info.css">
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="${ctx}/resources/js/layer2/layer.js"></script>
    <script src="https://cdn.jsdelivr.net/sockjs/1.1.1/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

    <title>查询者信息</title>

	<script type="text/javascript">
		$(document).ready(function () {

		    var sock = null;
		    function checkORopenSock() {
		        if(sock!=null) return;
                sock = new SockJS('${ctx}/ws');
                sock.onopen = function() {
                    console.log('open');
                };
                sock.onmessage = function(resp) {
                    console.log(resp.data);
                    var returnObj = JSON.parse(resp.data);
                    if(returnObj != null && ((typeof returnObj.id) != 'undefined')) {
                        window.location.href = "${ctx}/template-log/report/"+returnObj.id;
                    }
                };
                sock.onclose = function() {
                    console.log('close');
                };

            }

			$(".confirm_check").click(function () {
			    var data = {}

                $.each($("#iForm").serializeArray(), function (i, field) {
                    data[field.name] = field.value;
                });

                var index = layer.load(3, {
                    shade: [0.5,'#fff'] //0.1透明度的白色背景
                });

                checkORopenSock();
                $.ajax({
                    "type": "POST",
                    "url": "${ctx}/template/report/${id}",
                    "contentType" : 'application/json;charset=UTF-8',
                    "data": JSON.stringify(data),
                    "success": function(data){
                        layer.close(index);
                        if(data.code == "000000"){
                            layer.load(3, {
                                shade: [0.5,'#fff'], //0.1透明度的白色背景
                                content: "数据提交成功，报告努力生成中，请耐心等待或者稍后到查询记录中查看生成模板"
                            });

						} else if(data.code == "999990") {
                            $("input").siblings(".err_tips").hide();
                            $.each(data.data, function (index, msg) {
                                $("input[name="+msg.name+"]").siblings(".err_tips").html(msg.msg).show();
                            });
                        } else {
							layer.msg("提交失败，系统开小差了~");
                            sock.close();
                        }

                    },
                    "error": function () {
                        layer.close(index);
                    }
                });

			});
		});

	</script>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>
	<div class="changeP_content">
	<p class="changeP_titel">首页>&nbsp<a href="#" style="color:#f24a39;">批量查询</a></p>
	  
	   <div class="modle_shoose2">
	   	<span style="color:#fff;">选择报告模板</span>
	   	<span style="color:#fff;">输入被查询者信息</span>
	   	<span>生成信用报告</span>
	   </div>
	   
	   <div class="base_info">
	   	  <h3>请填写被查询人的基本信息：</h3>

		   <form method="post" id="iForm">
		   <c:forEach items="${paramList}" var="it">

			   <c:choose>
					<c:when test="${it.name == 'caseType'}">
						<div class="inst">
							<label>涉诉详情-涉诉类型</label>
							<select class="selectDown" name="caseType">
								<option value="cpws">裁判文书</option>
								<option value="zxgg">执行公告</option>
								<option value="sxgg">失信公告</option>
								<option value="ktgg">开庭公告</option>
								<option value="fygg">法院公告</option>
								<option value="wdhmd">网贷黑名单</option>
								<option value="ajlc">案件流程信息</option>
							</select>
							<p  class="err_tips" style="display:block;"></p>
						</div>
					</c:when>

				   <c:when test="${it.name == 'keyType'}">
					   <div class="inst">
						   <label>个人工商法信息-查询类型</label>
						   <select class="selectDown" name="keyType">
							   <option value="gl">个人担任高管信息</option>
							   <option value="fr">个人担任法定代表人信息</option>
							   <option value="gd">个人股权投资信息</option>
						   </select>
						   <p  class="err_tips" style="display:block;"></p>
					   </div>
				   </c:when>


				   <c:otherwise>
					   <div class="inst">
						   <label>${it.description}</label>
						   <input type="text" name="${it.name}" placeholder="${it.description}" class="required"/>
						   <p  class="err_tips" style="display:block;"></p>
					   </div>
				   </c:otherwise>

			   </c:choose>
		   </c:forEach>

		   </form>

        <button class="confirm_check" onclick="return false;" style="cursor: pointer;">确认查询</button>

	   </div>
	 
	</div>

	   <div class="back_page">
        <a href="#">&lt; 返回上一页</a>
       </div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
