<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp" %>
<%@ page import="com.common.utils.gate.EnumMap" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css"/>
    <link rel="stylesheet" href="${ctx}/resources/css/credit.css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

    <script src="${ctx}/resources/script/tableExport.js"></script>
    <script src="${ctx}/resources/script/jquery.base64.js"></script>

    <script src="${ctx}/resources/script/jspdf/libs/sprintf.js"></script>
    <script src="${ctx}/resources/script/jspdf/jspdf.js"></script>
    <script src="${ctx}/resources/script/jspdf/libs/base64.js"></script>
    <title>个人信用报告</title>
</head>

<body>
<div class="black-bg" style="display:none;"></div>

<%@include file="/WEB-INF/jsp/common/header.jsp"%>

<div class="middle-width" style="padding-bottom: 200px;">
    <h3 class="title"><a href="#">首页<span>></span></a><a href="#">报告查询<span>></span></a><a href="#" class="current">个人信用报告</a>
    </h3>
    <div class="report-download">
        <a href="#">返回查询</a>
        <a href="#" onClick ="$('#reportPDF').tableExport({type:'pdf',escape:'false'})">下载报告</a>
    </div>
    <div id="reportPDF">
    <div class="report-top">
        <div class="report-top-box">
            <div><p>报告生成时间：<span><fmt:formatDate value="${detail.createtime}" pattern="yyyy-MM-dd"/> </span></p></div>
            <div><p>查询编号：<span>${detail.orderid}</span></p></div>
            <div><p>操作员：<span>${detail.consumername}</span></p></div>
        </div>
        <div class="report-top-box">
            <div><p>被查询者姓名：<span>${detail.personname}</span></p></div>
            <div><p>被查询者证件类型：<span>身份证</span></p></div>
            <div><p>被查询者身份证号码：<span>${detail.cardid}</span></p></div>
        </div>
    </div>

    <%--信息验证开始--%>
    <c:if test="${!empty prodMap['1']}">
    <div class="report-message">
        <h2>信息验证类</h2>
        <c:if test="${!empty prodMap['1']['1']}">
            <div class="report-message-table">
                <p class="report-message-title">身份证核实</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table2">
                    <tr>
                        <td colspan="2">查询条件</td>
                        <td colspan="2">结果</td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td>${detail.personname}</td>
                        <td colspan="2" rowspan="2" style="width: 50%">
                                ${EnumMap.baseIDVerifyMap[prodMap['1']['1'].productData.result] }
                        </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td>${detail.cardid}</td>
                    </tr>
                </table>
            </div>
        </c:if>

        <c:if test="${!empty prodMap['1']['3']}">
            <div class="report-message-table">
                <p class="report-message-title">银行四要素</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table2">
                    <tr>
                        <td colspan="2">查询条件</td>
                        <td colspan="2">结果</td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td>${prodMap['1']['3'].productParam.name}</td>
                        <td colspan="2" rowspan="4" style="width: 50%">
                                ${EnumMap.statusMap[prodMap['1']['3'].productData.status]}
                        </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td>${prodMap['1']['3'].productParam.idCard}</td>
                    </tr>
                    <tr>
                        <td>卡号</td>
                        <td>${prodMap['1']['3'].productParam.cardNum}</td>
                    </tr>
                    <tr>
                        <td>手机号</td>
                        <td>${prodMap['1']['3'].productParam.mobileNum}</td>
                    </tr>
                </table>
            </div>
        </c:if>

        <c:if test="${!empty prodMap['1']['4']}">
            <div class="report-message-table">
                <p class="report-message-title">驾驶证状态查询</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table3">
                    <tr>
                        <td>驾驶证号码</td>
                        <td>状态</td>
                    </tr>
                    <tr>
                        <td>${prodMap['1']['4'].productParam.drivingNo}</td>
                        <td>${prodMap['1']['4'].productData.zt}</td>
                    </tr>
                </table>
            </div>
        </c:if>

        <c:if test="${!empty prodMap['1']['5']}">
        <div class="report-message-table">
            <p class="report-message-title">行驶证状态查询</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table3">
                <tr>
                    <td>车牌号</td>
                    <td>发动机号</td>
                    <td>号牌种类</td>
                    <td>状态</td>
                </tr>
                <tr>
                    <td>${prodMap['1']['5'].productParam.carNo}</td>
                    <td>${prodMap['1']['5'].productParam.engineNo}</td>
                    <td>${prodMap['1']['5'].productParam.carType}</td>
                    <td>${prodMap['1']['5'].productData.zt}</td>
                </tr>
            </table>
        </div>
        </c:if>
        <%--信息验证结束--%>
    </div>
</c:if>

<%--信息查询报告开始--%>
<c:if test="${!empty prodMap['2']}">
    <div class="report-message">
        <h2>信息查询报告</h2>

        <c:if test="${!empty prodMap['2']['6']}">
        <div class="report-message-table">
            <p class="report-message-title">多项身份信息</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>姓名</td>
                    <td>${prodMap['2']['6'].productData.name}</td>
                    <td>曾用名</td>
                    <td>${prodMap['2']['6'].productData.formerName}</td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td>${prodMap['2']['6'].productData.nation}</td>
                    <td>性别</td>
                    <td>${prodMap['2']['6'].productData.formerName}</td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td>${prodMap['2']['6'].productData.idCard}</td>
                    <td>出生日期</td>
                    <td>${prodMap['2']['6'].productData.birthday}</td>
                </tr>
                <tr>
                    <td>文化程度</td>
                    <td>${prodMap['2']['6'].productData.education}</td>
                    <td>婚姻状况</td>
                    <td>${prodMap['2']['6'].productData.maritalStatus}</td>
                </tr>
                <tr>
                    <td>籍贯</td>
                    <td>${prodMap['2']['6'].productData.nativePlace}</td>
                    <td>出生地</td>
                    <td>${prodMap['2']['6'].productData.birthPlace}</td>
                </tr>
                <tr>
                    <td>工作单位</td>
                    <td>${prodMap['2']['6'].productData.company}</td>
                    <td>住址</td>
                    <td>${prodMap['2']['6'].productData.address}</td>
                </tr>
                <tr>
                    <td>校验结果</td>
                    <td>${EnumMap.baseIDVerifyMap[prodMap['2']['6'].productData.verify]}</td>
                    <td>原始发证地</td>
                    <td>${prodMap['2']['6'].productData.issuingArea}</td>
                </tr>
            </table>
        </div>
        </c:if>

        <c:if test="${!empty prodMap['2']['7']}">
            <div class="report-message-table">
                <p class="report-message-title">移动通讯数据</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table1">
                    <tr>
                        <td>姓名</td>
                        <td>${prodMap['2']['7'].productParam.name}</td>
                        <td>身份证号码</td>
                        <td>${prodMap['2']['7'].productParam.idCard}</td>
                    </tr>
                    <tr>
                        <td>手机号</td>
                        <td>${prodMap['2']['7'].productParam.mobileNum}</td>
                        <td>欠费标识</td>
                        <td>${prodMap['2']['7'].productData.hfBalSign}</td>
                    </tr>
                    <tr>
                        <td>品牌代码</td>
                        <td>${prodMap['2']['7'].productData.hfSegCardType}</td>
                        <td>运营商</td>
                        <td>${prodMap['2']['7'].productData.telecomOperator}</td>
                    </tr>
                    <tr>
                        <td>在网时长(月份)</td>
                        <td>${prodMap['2']['8'].productData.onlineTimes}</td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </c:if>

    <c:if test="${!empty prodMap['2']['8']}">
        <div class="report-message-table">
            <p class="report-message-title">固话信息查询</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>姓名</td>
                    <td>${prodMap['2']['8'].productParam.name}</td>
                    <td>身份证号码</td>
                    <td>${prodMap['2']['8'].productParam.idCard}</td>
                </tr>
                <tr>
                    <td>固定电话</td>
                    <td>${prodMap['2']['8'].productParam.telephone}</td>
                    <td>名称</td>
                    <td>${prodMap['2']['8'].productData.nameInput}</td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td>${prodMap['2']['8'].productData.addressInput}</td>
                    <td>查得电话</td>
                    <td>${prodMap['2']['8'].productData.corpTel}</td>
                </tr>
                <tr>
                    <td>查得名称</td>
                    <td>${prodMap['2']['8'].productData.corpName}</td>
                    <td>查得地址</td>
                    <td>${prodMap['2']['8'].productData.corpAddress}</td>
                </tr>
            </table>
        </div>
        </c:if>


    <c:if test="${!empty prodMap['2']['9']}">
    <div class="report-message-table">
            <p class="report-message-title">学历信息</p>
            <table border="0" cellpadding="0" cellspacing="0" style="height: 40px; width: 1180px;" class="report-message-table6">
                <tbody>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">姓名</td>
                    <td width="260">${prodMap['2']['9'].productData.name}</td>
                    <td width="210" style="background-color:#f9f9f9;">学历</td>
                    <td width="230">${prodMap['2']['9'].productData.education}</td>
                    <td rowspan="5">
                        <table  cellpadding="0" cellspacing="0" width="270" height="200" style="border:0;">
                            <tbody>
                            <tr>
                                <td width="270" height="200" style="border:0;text-align:center;">
                                    <img src="data:image/jpg;base64,${prodMap['2']['9'].productData.photo}" height="177" width="126" style="vertical-align: top; margin-top: 20px;">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">身份证号码</td>
                    <td width="260">${prodMap['2']['9'].productData.idCard}</td>
                    <td width="210" style="background-color:#f9f9f9;">专业</td>
                    <td>${prodMap['2']['9'].productData.specialityName}</td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">入学时间</td>
                    <td width="260">${prodMap['2']['9'].productData.enrolDate}</td>
                    <td style="background-color:#f9f9f9;">毕业时间</td>
                    <td>${prodMap['2']['9'].productData.graduateTime}</td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">毕业院校</td>
                    <td width="260">${prodMap['2']['9'].productData.graduate}</td>
                    <td style="background-color:#f9f9f9;">毕业结论&nbsp;</td>
                    <td>${prodMap['2']['9'].productData.studyResult}</td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">院校性质</td>
                    <td width="260">${prodMap['2']['9'].productData.education}</td>
                    <td style="background-color:#f9f9f9;">学历类型</td>
                    <td>${prodMap['2']['9'].productData.studyStyle}</td>
                </tr>
                </tbody>
            </table>
        </div>
        </c:if>

    <c:if test="${!empty prodMap['2']['10']}">
        <div class="report-message-table">
            <p class="report-message-title">职业资格信息</p>

            <c:forEach items="${prodMap['2']['10'].productData.certificateList}" var="career">
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>姓名</td>
                    <td>${career.name}</td>
                    <td>身份证号</td>
                    <td>${career.idCard}</td>
                </tr>
                <tr>
                    <td>证书编号</td>
                    <td>${career.certificateID}</td>
                    <td>证书职业名称</td>
                    <td>${career.occupation}</td>
                </tr>
                <tr>
                    <td>输出证书级别</td>
                    <td>${career.clevel}</td>
                    <td>颁证日期</td>
                    <td>${career.banZhengRiQi}</td>
                </tr>
                <tr>
                    <td>上报单位</td>
                    <td colspan="3">${career.submitOrgName}</td>
                </tr>
            </table>
            </c:forEach>
        </div>
        </c:if>

    <c:if test="${!empty prodMap['2']['11']}">
        <div class="report-message-table">
            <p class="report-message-title">个人股权投资信息</p>


            <table cellpadding="0" cellspacing="0" class="report-message-table6">
                <tbody>
                <tr>
                    <td class="tdLeft" style="background-color:#f9f9f9;">投资人</td>
                    <td colspan="4" rowspan="1" width="968" height="40">${prodMap['2']['11'].productParam.name}</td>
                </tr>

                <c:set var="enterPCount" value="0"/>
                <c:set var="enterPMoney" value="0"/>
                <c:forEach items="prodMap['2']['1'].productData.shareholderList}" var="shareholder" varStatus="vstat">
                    <c:set var="enterPCount" value="${vstat.index + enterPCount}"/>
                    <c:set var="enterPMoney" value="${shareholder.subConAm + enterPMoney}"/>
                </c:forEach>

                <tr class="success">
                    <td class="tdLeft" height="40" style="background-color:#f9f9f9;">累计投资企业（机构）数</td>
                    <td colspan="4" rowspan="1" height="40">

                        <table cellpadding="0" cellspacing="0" style="border:0;">
                            <tbody>
                            <tr>
                                <td width="322" height="40" style="border:0;border-right:1px solid #ccc;">${enterPMoney>0 ? enterPCount+1 : enterPCount}</td>
                                <td width="322" height="40" style="border:0; border-right:1px solid #ccc; background-color:#f9f9f9;">
                                    累计投资总额
                                </td>
                                <td width="322" height="40" style="border:0;">${enterPMoney}</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>

                <c:forEach items="prodMap['2']['1'].productData.shareholderList}" var="shareholder">
                    <tr class="error">
                        <td colspan="1" rowspan="4" class="tdLeft" height="160" style="line-height: 160px; vertical-align: middle;">
                            ${shareholder.entName}
                        </td>
                        <td width="243" height="40" style="background-color:#f9f9f9;">注册资本</td>
                        <td width="230" height="40">${shareholder.regCap}</td>
                        <td width="230" height="40" style="background-color:#f9f9f9;">认缴出资额(万元)</td>
                        <td width="257" height="40">${shareholder.subConAm}</td>
                    </tr>
                    <tr class="warning">
                        <td height="40" style="background-color:#f9f9f9;">注册资本币种</td>
                        <td>${shareholder.regCapCur}</td>
                        <td style="background-color:#f9f9f9;">认缴出资币种</td>
                        <td>${shareholder.currency}</td>
                    </tr>
                    <tr class="info">
                        <td height="40" style="background-color:#f9f9f9;">注册号</td>
                        <td height="40">${shareholder.regNo}</td>
                        <td height="40" style="background-color:#f9f9f9;">企业状态</td>
                        <td height="40">${shareholder.entStatus}</td>
                    </tr>
                    <tr>
                        <td height="40" style="background-color:#f9f9f9;">企业(机构)类型</td>
                        <td colspan="3" rowspan="1" height="40">${shareholder.entType}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>

        </div>

        <div class="report-message-table">
            <p class="report-message-title">个人担任法定代表人信息</p>
            <table border="0" cellpadding="0" cellspacing="0" class="report-message-table6">
                <tbody>
                <tr>
                    <td style="width: 20%; background-color: #f9f9f9;">法定代表人姓名</td>
                    <td colspan="4" rowspan="2">
                        <table border="0" cellpadding="0" cellspacing="0" style="width:972px; border:0;">
                            <tbody>
                            <tr>
                                <td style="border-width: 0px 1px 0px 0px;width:323px;">${prodMap['2']['11'].productParam.name}</td>
                                <td style="border-width: 0px 1px 0px 0px; width: 25%; background-color: #f9f9f9;">
                                    累计担任法定代表人企业（机构）数
                                </td>
                                <td style="border-width: 0px 0px 0px 0px;">1家</td>
                            </tr>
                            <tr>
                                <td style="border-width: 1px 1px 0px 0px;">2家</td>
                                <td style="border-width: 1px 1px 0px 0px; width: 25%; background-color: #f9f9f9;">
                                    累计投资总额
                                </td>
                                <td style="border-width: 1px 0px 0px 0px;">人民币**万元；美元**万元</td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td style="width: 20%; background-color: #f9f9f9;">累计投资企业（机构）数</td>
                </tr>

                <c:forEach items="prodMap['2']['1'].productData.frList}" var="fr">
                    <tr>
                        <td colspan="1" rowspan="3" style=" background-color: #f9f9f9; vertical-align: middle;">
                            ${fr.entName}
                        </td>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本</td>
                        <td width="230">${fr.regCap}</td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)类型</td>
                        <td width="267">${fr.entType}</td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本币种</td>
                        <td width="230">${fr.regCapCur}</td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)状态</td>
                        <td width="267">${fr.entStatus}</td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">工商注册号</td>
                        <td colspan="3" rowspan="1" width="727">${fr.regNo}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>

        <div class="report-message-table">
            <p class="report-message-title">个人担任高管信息</p>
            <table border="0" cellpadding="0" cellspacing="0" class="report-message-table6">
                <tbody>
                <tr>
                    <td style="width: 20%; background-color: #f9f9f9;">法定代表人姓名</td>
                    <td colspan="4" rowspan="2">
                        <table border="0" cellpadding="0" cellspacing="0" style="width:972px; border:0;">
                            <tbody>
                            <tr>
                                <td style="border-width: 0px 1px 0px 0px;width:323px;">${prodMap['2']['11'].productParam.name}</td>
                                <td style="border-width: 0px 1px 0px 0px; width: 25%; background-color: #f9f9f9;">
                                    累计担任法定代表人企业（机构）数
                                </td>
                                <td style="border-width: 0px 0px 0px 0px;">1家</td>
                            </tr>

                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                </tr>

                <c:forEach items="prodMap['2']['1'].productData.managementList}" var="manage">
                    <tr>
                        <td colspan="1" rowspan="3" style=" background-color: #f9f9f9; vertical-align: middle;">
                            ${manage.entName}
                        </td>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本</td>
                        <td width="230">${manage.regCap}</td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)类型</td>
                        <td width="267">${manage.entType}</td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本币种</td>
                        <td width="230">${manage.regCapCur}</td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)状态</td>
                        <td width="267">${manage.entStatus}</td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">工商注册号</td>
                        <td>${manage.regNo}</td>
                        <td width="243" style=" background-color: #f9f9f9;">职务</td>
                        <td>${manage.position}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        </c:if>
        <%--信息查询报告结束--%>
    </div>
    </c:if>

<%--风险信息报告开始--%>
<c:if test="${!empty prodMap['3']}">
    <div class="report-message">
        <h2>风险信息报告</h2>

    <c:if test="${!empty prodMap['3']['12']}">
        <div class="report-message-table">
            <p class="report-message-title">手机黑名单信息</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>姓名</td>
                    <td>${detail.personname}</td>
                    <td>查询号码</td>
                    <td>${prodMap['3']['12'].productParam.mobileNum}</td>
                </tr>

                <c:forEach items="${prodMap['3']['12'].productData.others}" var="oList">
                    <tr>
                        <td>IMSI(MD5)</td>
                        <td colspan="3">${oList.matchId}</td>
                    </tr>
                    <tr>
                        <td>机构失联</td>
                        <td>${oList.orgLostContact}</td>
                        <td>银行失联</td>
                        <td>${oList.bankLostContact}</td>
                    </tr>
                    <tr>
                        <td>机构诉讼</td>
                        <td>${oList.orgLitigation}</td>
                        <td>银行诉讼</td>
                        <td>${oList.orgLitigation}</td>
                    </tr>
                    <tr>
                        <td>列为黑名单的机构</td>
                        <td>${oList.orgBlackList}</td>
                        <td>开户30天有逾期</td>
                        <td>${oList.orgOneMonthOvedue}</td>
                    </tr>
                    <tr>
                        <td>机构逾期期数</td>
                        <td>${oList.orgOverduePeriord}</td>
                        <td>银行逾期期数</td>
                        <td>${oList.bankOverduePeriord}</td>
                    </tr>
                    <tr>
                        <td>查询条件</td>
                        <td>${oList.matchType}</td>
                        <td>查询号码</td>
                        <td>${oList.matchValue}</td>
                    </tr>
                </c:forEach>

            </table>
            <p class="state">(本表信息基于对手机行为的数据分析)</p>
        </div>
    </c:if>

    <c:if test="${!empty prodMap['3']['15']}">
        <div class="report-message-table">
            <p class="report-message-title">涉诉风险（汇总）</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>序号</td>
                    <td>涉诉类型</td>
                    <td>涉诉数量</td>
                    <td>汇总</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>裁判文书</td>
                    <td>${prodMap['3']['15'].productData.cpws}</td>
                    <td rowspan="7" class="report-message-sums">
                        <c:set var="ctotalCount" value="0"/>
                        <c:forEach items="${prodMap['3']['15'].productData}" var="it">
                            <c:set var="ctotalCount" value="${ctotalCount + it.value}"/>
                        </c:forEach>
                        ${ctotalCount}
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>执行公告</td>
                    <td>${prodMap['3']['15'].productData.zxgg}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>失信公告</td>
                    <td>${prodMap['3']['15'].productData.sxgg}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>开庭公告</td>
                    <td>${prodMap['3']['15'].productData.ktgg}</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>法院公告</td>
                    <td>${prodMap['3']['15'].productData.fygg}</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>网贷黑名单</td>
                    <td>${prodMap['3']['15'].productData.wdhmd}</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>案件流程信息</td>
                    <td>${prodMap['3']['15'].productData.ajlc}</td>
                </tr>
            </table>
        </div>
    </c:if>

    <c:if test="${!empty prodMap['3']['16']}">
        <div class="report-message-details">
            <div class="report-message-details-table">
                <p>涉诉风险明细信息</p>
                <p>裁判文书（${fn:length(prodMap['3']['16'].productData.cpwsList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>当事人类型</th>
                        <th>审理机构</th>
                        <th>案由</th>
                        <th>案件受理费</th>
                        <th>判决金额</th>
                        <th>判决时间</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.cpwsList}" var="cpwsObj">
                        <tr>
                            <td style="width: 14.6%;">${cpwsObj.cpwsId}</td>
                            <td style="width: 14.6%;">${cpwsObj.partyTitle}</td>
                            <td style="width: 14.6%;">${cpwsObj.court}</td>
                            <td style="width: 14.6%;">${cpwsObj.caseCause}</td>
                            <td style="width: 14.6%;">${cpwsObj.caf}</td>
                            <td style="width: 14.6%;">${cpwsObj.fee}</td>
                            <td style="width: 14.6%;">${cpwsObj.sortTime}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div class="report-message-details-table">
                <p>执行公告（${fn:length(prodMap['3']['16'].productData.zxggList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>执行时间</th>
                        <th>被执行人</th>
                        <th>法院名称</th>
                        <th>案号</th>
                        <th>案件状态</th>
                        <th>执行标的</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.zxggList}" var="zxggObj">
                        <tr>
                            <td style="width: 14.6%;">${zxggObj.zxggId}</td>
                            <td style="width: 14.6%;">${zxggObj.sortTime}</td>
                            <td style="width: 14.6%;">${zxggObj.pname}</td>
                            <td style="width: 14.6%;">${zxggObj.court}</td>
                            <td style="width: 14.6%;">${zxggObj.caseNo}</td>
                            <td style="width: 14.6%;">${zxggObj.caseStatus}</td>
                            <td style="width: 14.6%;">${zxggObj.execMoney}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>


            <div class="report-message-details-table">
                <p>失信公告（${fn:length(prodMap['3']['16'].productData.sxggList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>发布时间</th>
                        <th>被执行人</th>
                        <th>执行法院名称</th>
                        <th colspan="2" style="width: 50%;">案号</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.sxggList}" var="sxggObj">
                        <tr>
                            <td>${sxggObj.sxggId}</td>
                            <td>${sxggObj.sortTime}</td>
                            <td>${sxggObj.pname}</td>
                            <td>${sxggObj.court}</td>
                            <td colspan="2" style="width: 50%;">${sxggObj.caseNo}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


            <div class="report-message-details-table">
                <p>法院公告（${fn:length(prodMap['3']['16'].productData.fyggList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>发布时间</th>
                        <th>当事人</th>
                        <th>法院名称</th>
                        <th colspan="2" style="width: 50%;">公告类型</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.fyggList}" var="fyggObj">
                        <tr>
                            <td>${fyggObj.fyggId}</td>
                            <td>${fyggObj.sortTime}</td>
                            <td>${fyggObj.pname}</td>
                            <td>${fyggObj.court}</td>
                            <td colspan="2" style="width: 50%;">${fyggObj.ggType}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>


            <div class="report-message-details-table">
                <p>网贷黑名单（${fn:length(prodMap['3']['16'].productData.wdhmdList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>贷款时间</th>
                        <th>姓名</th>
                        <th colspan="3" style="width: 68%;">身份证号</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.wdhmdList}" var="wdhmdObj">
                        <tr>
                            <td>${wdhmdObj.wdhmdId}</td>
                            <td>${wdhmdObj.sortTime}</td>
                            <td>${wdhmdObj.pname}</td>
                            <td colspan="3" style="width: 68%;">${wdhmdObj.idcardNo}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div class="report-message-details-table">
                <p>案件流程信息（${fn:length(prodMap['3']['16'].productData.ajlcList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>立案时间</th>
                        <th>案件进度</th>
                        <th>当事人</th>
                        <th>法院名称</th>
                        <th>案号</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.ajlcList}" var="ajlcObj">
                        <tr>
                            <td>${ajlcObj.ajlcId}</td>
                            <td>${ajlcObj.sortTime}</td>
                            <td>${ajlcObj.caseStatus}</td>
                            <td>${ajlcObj.pname}</td>
                            <td>${ajlcObj.court}</td>
                            <td>${ajlcObj.caseNo}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>

            <div class="report-message-details-table">
                <p>开庭公告（${fn:length(prodMap['3']['16'].productData.ktggList)}）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>开庭时间</th>
                        <th>案由</th>
                        <th>被执行人</th>
                        <th>法院名称</th>
                        <th>案号(文书字号)</th>
                    </tr>

                    <c:forEach items="${prodMap['3']['16'].productData.ktggList}" var="ktggObj">
                        <tr>
                            <td>${ktggObj.ktggId}</td>
                            <td>${ktggObj.sortTime}</td>
                            <td>${ktggObj.caseCause}</td>
                            <td>${ktggObj.pname}</td>
                            <td>${ktggObj.court}</td>
                            <td>${ktggObj.caseNo}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>


        <c:if test="${!empty prodMap['3']['18']}">
            <div class="report-message-table">
                <p class="report-message-title">不良信息</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table1">
                    <tr>
                        <td>姓名</td>
                        <td>${prodMap['3']['18'].productData.name}</td>
                        <td>身份证号</td>
                        <td>${prodMap['3']['18'].productData.idCard}</td>
                    </tr>
                    <tr>
                        <td>核查代码</td>
                        <td>${EnumMap.badPersonInfoMap[prodMap['3']['18'].productData.checkCode]}</td>
                        <td>核查信息</td>
                        <td>${prodMap['3']['18'].productData.checkMsg}</td>
                    </tr>
                    <tr>
                        <td>发案时间</td>
                        <td colspan="3">${prodMap['3']['18'].productData.caseTime}</td>
                    </tr>
                </table>
            </div>
        </c:if>

            <%--风险信息报告结束--%>
        </div>
    </c:if>
    </div>
</c:if>

    <%--行为报告开始--%>
    <c:if test="${!empty prodMap['4']}">
    <div class="report-message">
        <h2>行为报告</h2>

        <c:if test="${!empty prodMap['4']['19']}">
        <div class="report-message-table">
            <p class="report-message-title">个人消费特征信息</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table5">
                <tr>
                    <td>卡号</td>
                    <td style="background-color: #F9F9F9">${prodMap['4']['19'].productData.cardNum}</td>
                    <td style="background-color: #F9F9F9">姓名</td>
                    <td>${prodMap['4']['19'].productData.name}</td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">卡类型</td>
                    <td>${prodMap['4']['19'].productData.cardType}</td>
                    <td>近6个月发生交易月份数</td>
                    <td>${prodMap['4']['19'].productData.MON_6_var1}</td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">近6个月交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_6_var1}</td>
                    <td>近6个月交易笔数</td>
                    <td>${prodMap['4']['19'].productData.RFM_6_var2}</td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">近6个月最大交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_6_var3}</td>
                    <td>近6个月笔均交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_6_var5}</td>
                </tr>


                <tr>
                    <td style="background-color: #F9F9F9">近6个月发生交易的MCC种类数</td>
                    <td>${prodMap['4']['19'].productData.MCC_6_var1}</td>
                    <td>常用地区</td>
                    <td>${prodMap['4']['19'].productData.LOC_6_var11}</td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">交易金额稳定性</td>
                    <td>${prodMap['4']['19'].productData.RFM_6_var6}</td>
                    <td>12个月取现交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_12_var30}</td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">12个月跨境交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_12_var40}</td>
                    <td>12个月转入交易金额</td>
                    <td>${prodMap['4']['19'].productData.RFM_12_var47}</td>
                </tr>

            </table>
        </div>
        </c:if>

        <c:if test="${!empty prodMap['4']['20']}">
            <div class="report-message-table">
                <p class="report-message-title">信贷报告</p>
                <table border="0" cellpadding="0" cellspacing="0" class="report-message-table6">
                    <tbody>
                    <tr>
                        <td style="width: 20%; background-color: #f9f9f9;">姓名</td>
                        <td colspan="4" rowspan="2">
                            <table border="0" cellpadding="0" cellspacing="0" style="width:972px; border:0;">
                                <tbody>
                                <tr>
                                    <td style="border-width: 0px 1px 0px 0px;width:323px;">${prodMap['4']['20'].productParam.name}</td>
                                    <td style="border-width: 0px 1px 0px 0px; width: 25%; background-color: #f9f9f9;">
                                        证号
                                    </td>
                                    <td style="border-width: 0px 0px 0px 0px;">${prodMap['4']['20'].productParam.certno}</td>
                                </tr>

                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    </tr>

                    <c:forEach items="${prodMap['4']['20'].productData.data}" var="credit">
                        <c:set var="acctInfo" value="${credit.acctInfo}"/>
                        <tr>
                            <td colspan="1" rowspan="16" style=" background-color: #f9f9f9; vertical-align: middle;">
                                合同信息
                            </td>
                            <td width="243" style=" background-color: #f9f9f9;">姓名</td>
                            <td width="230">${acctInfo.sname}</td>
                            <td width="230" style=" background-color: #f9f9f9;">证件类型</td>
                            <td width="267">${acctInfo.scerttype}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">证件号码</td>
                            <td width="230">${acctInfo.sname}</td>
                            <td width="230" style=" background-color: #f9f9f9;">业务合同号</td>
                            <td width="267">${acctInfo.scerttype}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">上报机构</td>
                            <td width="230">${acctInfo.org}</td>
                            <td width="230" style=" background-color: #f9f9f9;">信贷业务类型</td>
                            <td width="267">${acctInfo.scredittype}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">信贷业务用途</td>
                            <td width="230">${acctInfo.spurpose}</td>
                            <td width="230" style=" background-color: #f9f9f9;">合同金额</td>
                            <td width="267">${acctInfo.icreditlimit}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">币种</td>
                            <td width="230">${acctInfo.scurrency}</td>
                            <td width="230" style=" background-color: #f9f9f9;">还款频率</td>
                            <td width="267">${acctInfo.stermsfreq}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">生效日期</td>
                            <td width="230">${acctInfo.ddateopened}</td>
                            <td width="230" style=" background-color: #f9f9f9;">终止日期</td>
                            <td width="267">${acctInfo.ddateclosed}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">担保方式</td>
                            <td width="230">${acctInfo.iguaranteeway}</td>
                            <td width="230" style=" background-color: #f9f9f9;">发生地点名称</td>
                            <td width="267">${acctInfo.sareaname}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">性别</td>
                            <td width="230">${acctInfo.igender}</td>
                            <td width="230" style=" background-color: #f9f9f9;">出生日期</td>
                            <td width="267">${acctInfo.dbirthday}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">证件号码</td>
                            <td width="230">${acctInfo.sname}</td>
                            <td width="230" style=" background-color: #f9f9f9;">业务合同号</td>
                            <td width="267">${acctInfo.scerttype}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">婚姻状态</td>
                            <td width="230">${acctInfo.imarriage}</td>
                            <td width="230" style=" background-color: #f9f9f9;">最高学历</td>
                            <td width="267">${acctInfo.iedulevel}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">联系手机</td>
                            <td width="230">${acctInfo.smobiletel}</td>
                            <td width="230" style=" background-color: #f9f9f9;">通讯地址</td>
                            <td width="267">${acctInfo.scontactaddress}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">居住地址</td>
                            <td width="230">${acctInfo.saddress}</td>
                            <td width="230" style=" background-color: #f9f9f9;">居住状态</td>
                            <td width="267">${acctInfo.scondition}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">职业性质</td>
                            <td width="230">${acctInfo.sestatus}</td>
                            <td width="230" style=" background-color: #f9f9f9;">单位名称</td>
                            <td width="267">${acctInfo.scompany}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">单位地址</td>
                            <td width="230">${acctInfo.scompanyaddress}</td>
                            <td width="230" style=" background-color: #f9f9f9;">职务 </td>
                            <td width="267">${acctInfo.iposition}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">年收入</td>
                            <td width="230">${acctInfo.iannualincome}</td>
                            <td width="230" style=" background-color: #f9f9f9;">第一联系人姓名</td>
                            <td width="267">${acctInfo.sfirstcontactname}</td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">第一联系人关系</td>
                            <td width="230">${acctInfo.sfirstcontactrelation}</td>
                            <td width="230" style=" background-color: #f9f9f9;">第一联系人电话</td>
                            <td width="267">${acctInfo.sfirstcontacttel}</td>
                        </tr>



                        <c:set var="repayInfo" value="${credit.repayInfo}"/>
                        <c:forEach items="${repayInfo}" var="repay" varStatus="vstat">
                            <tr>
                                <td colspan="1" rowspan="6" style=" background-color: #f9f9f9; vertical-align: middle;">
                                还款信息列表${vstat.index+1}
                                </td>
                                <td width="243" style=" background-color: #f9f9f9;">还款期数(从1开始)</td>
                                <td width="230">${repay.iperiodnumber}</td>
                                <td width="230" style=" background-color: #f9f9f9;">逾期标志</td>
                                <td width="267">${repay.soverdue}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">本期应还日期</td>
                                <td width="230">${repay.dbillingdate}</td>
                                <td width="230" style=" background-color: #f9f9f9;">本期应还金额</td>
                                <td width="267">${repay.iactualpayamount}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">本期实还金额</td>
                                <td width="230">${repay.ischeduledamount}</td>
                                <td width="230" style=" background-color: #f9f9f9;">当前负债余额</td>
                                <td width="267">${repay.ibalance}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">合同状态</td>
                                <td width="230">${repay.iaccountstat}</td>
                                <td width="230" style=" background-color: #f9f9f9;">最高逾期的金额</td>
                                <td width="267">${repay.imaxoverdueamount}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">最高逾期的期数</td>
                                <td width="230">${repay.imaxoverduetimes}</td>
                                <td width="230" style=" background-color: #f9f9f9;">当前逾期的期数</td>
                                <td width="267">${repay.inowoverduetimes}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">当前逾期的金额总和</td>
                                <td width="230">${repay.inowoverdueamount}</td>
                                <td width="230" style=" background-color: #f9f9f9;"></td>
                                <td width="267"></td>
                            </tr>

                        </c:forEach>

                        <c:set var="guarenteeInfo" value="${credit.guarenteeInfo}"/>
                        <c:forEach items="${guarenteeInfo}" var="guarentee" varStatus="vstat">
                            <tr>
                                <td colspan="1" rowspan="4" style=" background-color: #f9f9f9; vertical-align: middle;">
                                    担保信息列表${vstat.index+1}
                                </td>
                                <td width="243" style=" background-color: #f9f9f9;">担保人姓名</td>
                                <td width="230">${guarentee.sname}</td>
                                <td width="230" style=" background-color: #f9f9f9;">担保人证件类型</td>
                                <td width="267">${guarentee.scerttype}</td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">担保人证件号</td>
                                <td width="230">${guarentee.scertno}</td>
                                <td width="230" style=" background-color: #f9f9f9;">担保状态</td>
                                <td width="267">${guarentee.istate}</td>
                            </tr>
                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">担保金额</td>
                                <td width="230">${guarentee.ioccursum}</td>
                                <td width="230" style=" background-color: #f9f9f9;">上报机构</td>
                                <td width="267">${guarentee.org}</td>
                            </tr>
                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">合同号</td>
                                <td width="230">${guarentee.saccount}</td>
                                <td width="230" style=" background-color: #f9f9f9;"></td>
                                <td width="267"></td>
                            </tr>
                        </c:forEach>


                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
    <%--行为报告结束--%>
    </c:if>

    <c:if test="${!empty statisticsDto}">
    <div class="report-message" style="margin-top: 50px;">
        <h2>查询记录</h2>
        <p style="text-align: center;">（统计过去24个月的查询信息）</p>
        <div class="report-message-table">
            <p class="report-message-title">全民个人报告</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>查询机构数</td>
                    <td>${statisticsDto.allQueryCompanyCount}</td>
                    <td>查询次数</td>
                    <td>${statisticsDto.allQueryCount}</td>
                </tr>
                <tr>
                    <td>最近三个月查询机构数</td>
                    <td>${statisticsDto.threeMonthQueryCompanyCount}</td>
                    <td>最近三个月查询查询次数</td>
                    <td>${statisticsDto.threeMonthQueryCount}</td>
                </tr>
                <tr>
                    <td>近六个月查询机构数</td>
                    <td>${statisticsDto.sixMonthQueryCompanyCount}</td>
                    <td>最近六个月查询查询次数</td>
                    <td>${statisticsDto.sixMonthQueryCount}</td>
                </tr>
            </table>
        </div>
    </div>
    </c:if>
    </div>

    <div class="notice">
        <p>阅读须知：
        <p>1. 本报告的著作权属于全民财富，未经书面许可，不得擅自复制、摘录、编辑、转载、披露和发表。
        <p>2. 使用本报告，需经过被查询人授权，全民财富不承担因授权不充分引起的任何法律责任。
        <p>3. 本报告中，除全民财富的特殊标注外，报告中的信息均由相关数据来源机构和信息主体提供，全民财富不保证其真实性和准确性， 但承诺在信息整合、汇总、展示的全过程中保持客观、中立的地位。
        <p>4. 请妥善保管本报告，并注意保密。</p>
    </div>
    <div class="report-download">
        <a href="#">返回查询</a>
        <a href="#" onClick ="$('#reportPDF').tableExport({type:'pdf',escape:'false'})">下载报告</a>
    </div>
</div><!--middle-width-->

<%@include file="/WEB-INF/jsp/common/footer.jsp"%>

</body>
</html>
