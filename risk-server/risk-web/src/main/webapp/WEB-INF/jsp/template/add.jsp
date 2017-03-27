<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新增报告模板</title>
    <link rel="stylesheet" href="${ctx}/resources/css/common.css">
    <link rel="stylesheet" href="${ctx}/resources/css/credit.css">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var toggle = false;
            var toggleAll = false;

            // block checkbox
            $("th a").click(function () {
                $(this).closest("table").find("input[type='checkbox']").prop("checked", (toggle = !toggle));
                calculateCountAndMoney();
            });

            // all checkbox
            $(".report-title input[type='checkbox']").click(function () {
               $("td input[type='checkbox']").prop("checked", (toggleAll = !toggleAll));
                calculateCountAndMoney();
            });

            $("table input[type='checkbox']").click(function () {
                calculateCountAndMoney();
            });

            //计算金额和选中项目
            function calculateCountAndMoney() {
                var totalMoney = 0, totalCount = 0;
                var selectEles = $("td input[type='checkbox']:checked");
                $.each(selectEles, function (i, e) {
                    totalMoney += parseFloat($(e).closest("tr").find("td span").attr("value"));
                });

                totalCount = selectEles.length;

                $($(".added-mould-select span").get(0)).html(totalCount);
                $($(".added-mould-select span").get(1)).html(totalMoney.toFixed(2));
                $("#totalpriceId").val(totalMoney.toFixed(2));
            }

            $(".form-button").click(function () {
                var checkEles = $("td input[type='checkbox']:checked");
                if(checkEles.length <= 0) {
                    $("#errorTip").html("请勾选模板内容");
                    return;
                }

                var tmpName = $("#tempnameId").val();
                if($.trim(tmpName).length <=0 ){
                    $("#errorTip").html("请填写模板名称");
                    return;
                }

                //cons submit param
                var detailList = [];
                var data = {};
                $.each(checkEles, function (i, e) {
                    var tmpMap = {};
                    tmpMap["productid"] = $(e).attr("productid");
                    tmpMap["infotype"] = $(e).attr("infotype");
                    detailList.push(tmpMap);
                })

                var buttonText = $(".form-button").html();
                $(".form-button").html("处理中...");
                $.ajax({
                    type: "POST",
                    url: "${ctx}/template/save",
                    dataType: "json",
                    contentType : 'application/json;charset=UTF-8',
                    data: JSON.stringify({
                        "tempname": $("#tempnameId").val(),
                        "totalprice": $("#totalpriceId").val(),
                        "detailList": detailList
                    }),
                    success: function(data){
                        $(".form-button").html(buttonText);
                        if(data.code = '000000'){
                            window.location.href="${ctx}/template/manage-index";
                        } else {
                            alert("保存失败");
                        }
                    },
                    error: function () {
                        $(".form-button").html(buttonText);
                    }
                });

            });

        });

    </script>
</head>

<body>

<%@include file="/WEB-INF/jsp/common/header.jsp"%>

<div class="middle-width">
    <h3 class="title"><a href="#">首页<span>></span></a><a href="#">系统管理<span>></span></a><a href="#">模板管理<span>></span></a><a href="#" class="current">新增报告模板</a></h3>
    <p class="report-title"><span style="">自定义报告内容</span><input type="checkbox" />全选所有内容</p>
    <div class="content-bg" style="margin-top: 5px; margin-bottom: 0;">
        <form method="post" action="">
        <div class="added-mould-width">

            <%--1信息验证 2信息查询 3风险名单 4行为报告--%>
            <c:forEach begin="1" end="4" step="1" var="type">
                <h3>
                    <c:choose>
                        <c:when test="${type == 1}">信息验证类</c:when>
                        <c:when test="${type == 2}">信息查询类</c:when>
                        <c:when test="${type == 3}">风险名单类</c:when>
                        <c:when test="${type == 4}">行为报告类</c:when>
                    </c:choose>
                </h3>
            <table cellpadding="0" cellspacing="0" class="content-table-grid mt15">
                <tr>
                    <th><a href="javascript:void(0);" style=" color: #283C6C;">全选</a></th>
                    <th>查询内容</th>
                    <th>所需查询条件</th>
                    <th>费用</th>
                </tr>

                <c:forEach items="${proList}" var="pro">
                    <c:if test="${pro.infotype == type}">
                        <tr>
                            <td><input type="checkbox" productid="${pro.id}" infotype="${type}"/></td>
                            <td>${pro.name}</td>
                            <td title="${pro.description}">${fn:substring(pro.description, 0, 20)}...</td>
                            <td><span value="${pro.marketprice}">${pro.marketprice}元</span>/次</td>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>

                <br/>

            </c:forEach>

            <h3 style="margin-top: 30px;">确认自定义模板</h3>
            <div class="added-mould-select">
                您已选择<span> 0</span> 项报告内容，总费用 <span>0</span> 元（不包含查得费用）
                    <div class="form-box form-import popup-form-import" style="margin-left: 328px; margin-top: 30px;">
                        <p>
                            <label>模板名称</label>
                            <input type="text" name="tempname" id="tempnameId"/>
                            <input type="hidden" name="totalprice" id="totalpriceId"/>
                            <span id="errorTip"></span>
                        </p>
                    </div>
                <p style="margin-left: 60px; margin-top: 20px;"><button class="form-button" onclick="return false;">确认新增</button></p>
            </div>
        </div>
        </form>
    </div>

    <div class="back-page">
    </div>

</div>
<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</body>
</html>

