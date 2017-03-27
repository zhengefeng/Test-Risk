<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量查询个人信用报告</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<div class="middle-width">
    <h3 class="title"><a href="#">首页<span>></span></a><a href="#" class="current">批量查询</a></h3>
    <div class="content-bg" style="background-color: #fff;">
        <form id="fileForm" action="${basePath}/batch/submitBatchQuery" method="post" enctype="multipart/form-data">
        <div class="batch-width">
            <p>（请选择批量查询请求文件）</p>
            <p class="mt15"><input type="file" id="file" name="file"/></p>
            <p><button class="form-button" style="width: 270px;" onclick="return false">提交批量查询</button></p>
            <p class="mt15"><a href="${basePath }/resources/file/征信批量查询报告模板.xlsx">下载批量查询模板</a></p>
            
        </div>
        </form>
    </div>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
<script type="text/javascript">
	$(".form-button").click(function (){
		var filePath = $("#file").val();
		if(filePath != null && filePath != ""){
			if(filePath.indexOf(".xls") > 0 || filePath.indexOf(".xlsx") > 0){
				var index = layer.load("处理中...",3, {
                    shade: [0.5,'#fff'] //0.1透明度的白色背景
                });
				$("#fileForm").ajaxSubmit(function(message) {
					layer.close(index);
					layer.msg("提交成功！", {icon:1}); 
				});
			}else{
				layer.msg("文件格式不正确，请重新选择！", {icon:7});
			}
		}else{
			layer.msg("请选择查询文件！", {icon:7});
		}
		
	});
</script>
</body>
</html>