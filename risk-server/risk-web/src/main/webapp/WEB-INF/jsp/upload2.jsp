<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World</title>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <!--使用cdn 获取公共js http://www.bootcdn.cn/-->
    <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <!-- jQuery countDown倒计时插件-->
    <script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
    <%--<script type="text/javascript" src="<c:url value='/resources/3rdparty/jquery/jquery-2.1.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/3rdparty/jquery/jquery.form.js'/>"></script>--%>
</head>
<body>
<div>
    <div><span>文件名:</span><span>${filename }</span></div>
    <div><span>文件大小:</span><span>${size }</span></div>
    <form enctype="multipart/form-data" method="post" action="uploadfile">
        <input type="file" name="file"/>
        <input type="submit" value="submit"/>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $("form").submit(function(evt){
            evt.preventDefault();
            $("form").ajaxSubmit({
                url:"uploadfile",
                dataType:"json",
                type:"POST",
                success: function(data){
                    console.log("data",data);
                },
                error: function(error){
                    console.log("error",error);
                }
            });
        });
    });

    $("form").ajaxSubmit({
        url:"uploadfile",
        dataType:"json",
        type:"POST",
        uploadProgress: function(event,position,total,percentComplete){
            console.log("event",event);
            console.log("position",position);
            console.log("total",total);
            console.log("percentComplete",percentComplete);
        },
        success: function(data){
            console.log("data",data);
        },
        error: function(error){
            console.log("error",error);
        }
    });
</script>
</body>
</html>

