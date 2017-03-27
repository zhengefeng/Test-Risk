<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%><html>
<!doctype html>
<html>
<head>
    <title>信用报告查询记录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css">
    <link rel="stylesheet" href="${ctx}/resources/css/credit.css">
    <link rel="stylesheet" href="${ctx}/resources/css/jquery.datetimepicker.min.css">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="${ctx}/resources/js/jquery.datetimepicker.full.min.js"></script>
    <script src="${ctx}/resources/js/layer2/layer.js"></script>

    <script type="text/javascript">
	    function viewDetail(currentElement, templateId){
	    	var orderId = currentElement.parentNode.parentNode.cells[0].innerText;
	    	var personName = currentElement.parentNode.parentNode.cells[2].innerText;
	    	var consumerName = currentElement.parentNode.parentNode.cells[5].innerText;
	    	var totalPrice = currentElement.parentNode.parentNode.cells[4].innerText;
	    	$.ajax({
	            type: "POST",
	            url: "${ctx}/template-log/queryTemplateSearchDetail",
	            data: {templateId:templateId},
	            success: function(data){
	            	var detail = "<div class='dispose-pop'>";
	            	detail += "<p><img src='${ctx}/resources/images/popup-arrow.png' /></p>";
	            	detail += "<p><span>查询编号：</span>"+orderId+"</p>";
	            	detail += "<p><span>查询姓名：</span>"+personName+"</p>";
	            	detail += "<p><span>操作人：</span>"+consumerName+"</p>";
	            	detail += "<p><span>总费用：</span>"+totalPrice+"元</p>";
	            	detail += "<p style='padding-bottom: 20px;'><span>明细费用：</span></p>";
	            	detail += "<table cellpadding='0' cellspacing='0'>";
            		detail += "    <tr>";
	            	detail += "        <th>查询内容</th>";
	            	detail += "        <th>费用</th>";
	            	detail += "    </tr>";
	            	var detailList = data.data;
	            	for(var i=0;i<detailList.length;i++){
	            		detail += "    <tr>";
		            	detail += "        <td>"+detailList[i].name+"</td>";
		            	detail += "        <td>"+detailList[i].marketPrice+"元</td>";
		            	detail += "    </tr>";
	            	}
	                detail += "</table>";
	                detail += "</div>";
	                $(currentElement.parentElement).append(detail);
	                $(".black-bg").show();
	            },
	            error: function () {
	            }
	        });
	    	
	    }
	    function bodyOnclick(){
	    	$(".black-bg").hide();
	    	$(".dispose-pop").hide();
	    }
        $(document).ready(function () {
            var pageSize = 15, startPage = 1;

            $.datetimepicker.setLocale('ch');//设置中文
            var dateParam = {
                format:"Y-m-d",      //格式化日期
                timepicker:false   //关闭时间选项
            }

            $('#startDateId').datetimepicker(dateParam);
            $('#endDateId').datetimepicker(dateParam);

            function nextPage(currentPage) {
                var index = layer.load(3, {
                    shade: [0.5,'#fff'] //0.1透明度的白色背景
                });
                if(currentPage != null){
                    startPage = currentPage;
                }

                $.ajax({
                    type: "POST",
                    url: "${ctx}/template-log/list-data",
                    data: handlerQueryParam(),
                    success: function(data){
                        layer.close(index);
                        fuckIt(data);
                    },
                    error: function () {
                        layer.close(index);
                    }
                });
            }

            function handlerQueryParam() {
                var param = {};
                $(".form-box input").each(function (i, e) {
                   param[$(e).attr("name")] = $(e).val();
                });

                param['startPage'] = startPage;
                param['pageSize'] = pageSize;

                return param;
            }

            function fuckIt(data) {
                generatorRowsAndTotalPrice(data);
                generatorPageBottom(data);
            }

            function generatorRowsAndTotalPrice(data) {
                //查询编号 查询时间 被查询姓名 被查询证件号码 费用 操作人 处理
                var row = '', allTemplateTotalPrice = 0;
                for(var i=0;i<data.dataList.length;i++){
                    var obj = data.dataList[i];
                    allTemplateTotalPrice += parseFloat((typeof obj.totalprice) == 'undefined' ? 0 : obj.totalprice );
                    var orderId = getObjVal(obj, 'orderid');
                    var createTime = getObjVal(obj, 'createtime');
                    var personName = getObjVal(obj, 'personname');
                    var cardId = getObjVal(obj, 'cardid');
                    var totalPrice = getObjVal(obj, 'totalprice'); 
                    var consumerName = getObjVal(obj, 'consumername');
                    row += '<tr>'+
                            '<td>'+ orderId +'</td>'+
                            '<td>'+ createTime +'</td>'+
                            '<td>'+ personName +'</td>'+
                            '<td>'+ cardId +'</td>'+
                            '<td>'+ totalPrice +'</td>'+
                            '<td>'+ consumerName +'</td>'+
                            '<td class="dispose"  style="position: relative">'+
                            '	<a href="${ctx}/template-log/report/'+obj.id +'" target="_blank">下载报告</a>'+
                            '	<a onclick="viewDetail(this, \''+getObjVal(obj,'templateid')+'\')">计费明细</a>'+
                            '</td>'+
                            '</tr>' ;
                }

                $(".content-table-grid tbody tr").remove();
                $(".content-table-grid tbody").append(row);
                $("h4 span").html(allTemplateTotalPrice);

            }

            function getObjVal(obj, key){
                return (typeof obj[key]) == 'undefined' ? '' : obj[key];
            }

            function generatorPageBottom(data) {
                var tmpPage = parseInt(data.totalCount / pageSize);
                var totalPage = (data.totalCount % pageSize == 0) ? tmpPage : tmpPage+1;

                var disMin = startPage<=3 ? 1 : startPage-2;
                var disMax = startPage<=3 ? 5 : startPage+2;//1 2 ===>>> 12345
                disMax = disMax >= totalPage ? totalPage : disMax;//maxPage is totalPage;

                var prevPage = (startPage-1>0 ? startPage-1 : 1);
                var nextPagevar = startPage+1>totalPage ? totalPage : startPage - 1;
                var bottom = '<a href="javascript:void(0)" val="'+prevPage+'"><</a>&nbsp;';
                for(var i = disMin;i<=disMax;i++){
                    bottom += '<a href="javascript:void(0)" val="'+i+'">'+i+'</a>&nbsp;';
                }

                if(totalPage > disMax){
                    bottom += '<span>...</span>';
                }

                bottom += '<a href="javascript:void(0)" val="'+nextPagevar+'">></a>&nbsp;';
                bottom += '<span>共'+totalPage+'页&nbsp;, 跳转到&nbsp;</span>'+
                              '<input type="text" id="jumpPageId">&nbsp;'+
                              '<a class="page-confirm" href="javascript:void(0);">确定</a>';
                $(".page").children().remove();
                $(".page").html(bottom);

                $(".page a").click(function () {
                    if($(this).html().trim() != '确定'){
                        nextPage($(this).attr("val"));
                    }
                });
            }

            $(".page-confirm").click(function () {
                nextPage($("#jumpPageId").val());
            });


            $(".form-button").click(function () {
                pageSize = 15, startPage = 1;
                nextPage();
            });

            nextPage(1);
            
            

        });
        
    </script>
</head>

<body>
<div class="black-bg" style="display: none;"  onclick="bodyOnclick()"></div>
<%@include file="/WEB-INF/jsp/common/header.jsp"%>

<div class="middle-width">
    <h3 class="title"><a href="#">首页<span>></span></a><a href="#" class="current">查询记录</a></h3>
    <div class="content-bg">
        <div class="content-bg-middle">
            <div class="content-user-top">
                <form class="form-import">
                    <div class="form-box">
                        <p><label>查询编号</label><input type="text" name="orderid"/></p>
                        <p><label>查询姓名</label><input type="text" name="personname"/></p>
                        <p><label>身份证号</label><input type="text" name="cardid"/></p>
                    </div>
                    <div class="form-box">
                        <p><label>操作人</label><input type="text" name="consumername"/></p>
                        <p><label>开始日期</label><input type="text" name="startDate" id="startDateId"/></p>
                        <p><label>结束日期</label><input type="text" name="endDate" id="endDateId"/></p>
                    </div>
                    <div class="form-box-button">
                        <p><label></label><button class="form-button" onclick="return false;">查询</button></p>
                    </div>
                </form>
            </div>
            <div class="content-table">
                <table cellpadding="0" cellspacing="0" class="content-table-grid">
                    <thead>
                        <th>查询编号</th>
                        <th>查询时间</th>
                        <th>被查询姓名</th>
                        <th>被查询证件号码</th>
                        <th>费用</th>
                        <th>操作人</th>
                        <th>处理</th>
                    </thead>

                    <tbody>
                    <tr>
                        <td>yuedaadmin</td>
                        <td>悦达管理员</td>
                        <td>evvevevev</td>
                        <td>geeeeeggwwwwwwwwwwwwg</td>
                        <td>江苏悦达</td>
                        <td>管理员</td>
                        <td class="dispose"><a href="#">下载报告</a><a href="#">计费明细</a></td>
                    </tr>
                    <tr>
                        <td>yuedaadmin</td>
                        <td>悦达管理员</td>
                        <td>evvevevev</td>
                        <td>geeeeeggwwwwwwwwwwwwg</td>
                        <td>江苏悦达</td>
                        <td>管理员</td>
                        <td class="dispose dispose-gray"><a href="#">下载报告</a><a href="#">计费明细</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <h4>根据查询条件，本次查询的所有报告费用合计：<span>0</span> 元</h4>
            <div class="page">
                <a href="#"><</a>&nbsp;
                <a href="#">1</a>&nbsp;
                <a href="#">2</a>&nbsp;
                <a href="#">3</a>&nbsp;
                <a href="#">4</a>&nbsp;
                <span>...</span>
                <a href="#">></a>&nbsp;
                <span>共7页&nbsp;, 跳转到&nbsp;</span>
                <input type="text">&nbsp;
                <a class="page-confirm">确定</a>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>
