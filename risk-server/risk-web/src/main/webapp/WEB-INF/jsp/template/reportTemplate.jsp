<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${ctx}/resources/css/common.css"/>
    <link rel="stylesheet" href="${ctx}/resources/css/credit.css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <title>个人信用报告</title>
</head>

<body>
<div class="black-bg" style="display:none;"></div>

<div class="middle-width" style="padding-bottom: 200px;">
    <div class="report-download">
        <a href="#">返回查询</a>
        <a href="#">下载报告</a>
    </div>

    <div class="report-top">
        <div class="report-top-box">
            <div><p>报告生成时间：<span> </span></p></div>
            <div><p>查询编号：<span></span></p></div>
            <div><p>操作员：<span></span></p></div>
        </div>
        <div class="report-top-box">
            <div><p>被查询者姓名：<span></span></p></div>
            <div><p>被查询者证件类型：<span></span></p></div>
            <div><p>被查询者身份证号码：<span></span></p></div>
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
                        <td></td>
                        <td colspan="2" rowspan="2" style="width: 50%">

                        </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td></td>
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
                        <td></td>
                        <td colspan="2" rowspan="4" style="width: 50%">

                        </td>
                    </tr>
                    <tr>
                        <td>身份证号</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>卡号</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>手机号</td>
                        <td></td>
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
                        <td></td>
                        <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td>曾用名</td>
                    <td></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td></td>
                    <td>性别</td>
                    <td></td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td></td>
                    <td>出生日期</td>
                    <td></td>
                </tr>
                <tr>
                    <td>文化程度</td>
                    <td></td>
                    <td>婚姻状况</td>
                    <td></td>
                </tr>
                <tr>
                    <td>籍贯</td>
                    <td></td>
                    <td>出生地</td>
                    <td></td>
                </tr>
                <tr>
                    <td>工作单位</td>
                    <td></td>
                    <td>住址</td>
                    <td></td>
                </tr>
                <tr>
                    <td>校验结果</td>
                    <td></td>
                    <td>原始发证地</td>
                    <td></td>
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
                        <td></td>
                        <td>身份证号码</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>手机号</td>
                        <td></td>
                        <td>欠费标识</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>品牌代码</td>
                        <td></td>
                        <td>运营商</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>在网时长(月份)</td>
                        <td></td>
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
                    <td></td>
                    <td>身份证号码</td>
                    <td></td>
                </tr>
                <tr>
                    <td>固定电话</td>
                    <td></td>
                    <td>名称</td>
                    <td></td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td></td>
                    <td>查得电话</td>
                    <td></td>
                </tr>
                <tr>
                    <td>查得名称</td>
                    <td></td>
                    <td>查得地址</td>
                    <td></td>
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
                    <td width="260"></td>
                    <td width="210" style="background-color:#f9f9f9;">学历</td>
                    <td width="230"></td>
                    <td rowspan="5">
                        <table  cellpadding="0" cellspacing="0" width="270" height="200" style="border:0;">
                            <tbody>
                            <tr>
                                <td width="270" height="200" style="border:0;text-align:center;">
                                    <img src="data:image/jpg;base64," height="177" width="126" style="vertical-align: top; margin-top: 20px;">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">身份证号码</td>
                    <td width="260"></td>
                    <td width="210" style="background-color:#f9f9f9;">专业</td>
                    <td></td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">入学时间</td>
                    <td width="260"></td>
                    <td style="background-color:#f9f9f9;">毕业时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">毕业院校</td>
                    <td width="260"></td>
                    <td style="background-color:#f9f9f9;">毕业结论&nbsp;</td>
                    <td></td>
                </tr>
                <tr>
                    <td width="210" style="background-color:#f9f9f9;">院校性质</td>
                    <td width="260"></td>
                    <td style="background-color:#f9f9f9;">学历类型</td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        </c:if>

    <c:if test="${!empty prodMap['2']['10']}">
        <div class="report-message-table">
            <p class="report-message-title">职业资格信息</p>


            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>姓名</td>
                    <td></td>
                    <td>身份证号</td>
                    <td></td>
                </tr>
                <tr>
                    <td>证书编号</td>
                    <td></td>
                    <td>证书职业名称</td>
                    <td></td>
                </tr>
                <tr>
                    <td>输出证书级别</td>
                    <td></td>
                    <td>颁证日期</td>
                    <td></td>
                </tr>
                <tr>
                    <td>上报单位</td>
                    <td colspan="3"></td>
                </tr>
            </table>

        </div>
        </c:if>

    <c:if test="${!empty prodMap['2']['11']}">
        <div class="report-message-table">
            <p class="report-message-title">个人股权投资信息</p>


            <table cellpadding="0" cellspacing="0" class="report-message-table6">
                <tbody>
                <tr>
                    <td class="tdLeft" style="background-color:#f9f9f9;">投资人</td>
                    <td colspan="4" rowspan="1" width="968" height="40"></td>
                </tr>
                <tr class="success">
                    <td class="tdLeft" height="40" style="background-color:#f9f9f9;">累计投资企业（机构）数</td>
                    <td colspan="4" rowspan="1" height="40">

                        <table cellpadding="0" cellspacing="0" style="border:0;">
                            <tbody>
                            <tr>
                                <td width="322" height="40" style="border:0;border-right:1px solid #ccc;"></td>
                                <td width="322" height="40" style="border:0; border-right:1px solid #ccc; background-color:#f9f9f9;">
                                    累计投资总额
                                </td>
                                <td width="322" height="40" style="border:0;"></td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                    <tr class="error">
                        <td colspan="1" rowspan="4" class="tdLeft" height="160" style="line-height: 160px; vertical-align: middle;">

                        </td>
                        <td width="243" height="40" style="background-color:#f9f9f9;">注册资本</td>
                        <td width="230" height="40"></td>
                        <td width="230" height="40" style="background-color:#f9f9f9;">认缴出资额(万元)</td>
                        <td width="267" height="40"></td>
                    </tr>
                    <tr class="warning">
                        <td height="40" style="background-color:#f9f9f9;">注册资本币种</td>
                        <td></td>
                        <td style="background-color:#f9f9f9;">认缴出资币种</td>
                        <td></td>
                    </tr>
                    <tr class="info">
                        <td width="243" height="40" style="background-color:#f9f9f9;">注册号</td>
                        <td height="40"></td>
                        <td height="40" style="background-color:#f9f9f9;">企业状态</td>
                        <td height="40"></td>
                    </tr>
                    <tr>
                        <td height="40" style="background-color:#f9f9f9;">企业(机构)类型</td>
                        <td colspan="3" rowspan="1" height="40"></td>
                    </tr>


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
                                <td style="border-width: 0px 1px 0px 0px;width:323px;"></td>
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


                    <tr>
                        <td colspan="1" rowspan="3" style=" background-color: #f9f9f9; vertical-align: middle;">

                        </td>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本</td>
                        <td width="230"></td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)类型</td>
                        <td width="267"></td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本币种</td>
                        <td width="230"></td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)状态</td>
                        <td width="267"></td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">工商注册号</td>
                        <td colspan="3" rowspan="1" width="727"></td>
                    </tr>


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
                                <td style="border-width: 0px 1px 0px 0px;width:323px;"></td>
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


                    <tr>
                        <td colspan="1" rowspan="3" style=" background-color: #f9f9f9; vertical-align: middle;">

                        </td>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本</td>
                        <td width="230"></td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)类型</td>
                        <td width="267"></td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">注册资本币种</td>
                        <td width="230"></td>
                        <td width="230" style=" background-color: #f9f9f9;">企业(机构)状态</td>
                        <td width="267"></td>
                    </tr>
                    <tr>
                        <td width="243" style=" background-color: #f9f9f9;">工商注册号</td>
                        <td></td>
                        <td width="243" style=" background-color: #f9f9f9;">职务</td>
                        <td></td>
                    </tr>


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
                    <td></td>
                    <td>查询号码</td>
                    <td></td>
                </tr>


                    <tr>
                        <td>IMSI(MD5)</td>
                        <td colspan="3"></td>
                    </tr>
                    <tr>
                        <td>机构失联</td>
                        <td></td>
                        <td>银行失联</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>机构诉讼</td>
                        <td></td>
                        <td>银行诉讼</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>列为黑名单的机构</td>
                        <td></td>
                        <td>开户30天有逾期</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>机构逾期期数</td>
                        <td></td>
                        <td>银行逾期期数</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>查询条件</td>
                        <td></td>
                        <td>查询号码</td>
                        <td></td>
                    </tr>


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
                    <td></td>
                    <td rowspan="7" class="report-message-sums">





                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>执行公告</td>
                    <td></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>失信公告</td>
                    <td></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>开庭公告</td>
                    <td></td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>法院公告</td>
                    <td></td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>网贷黑名单</td>
                    <td></td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>案件流程信息</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </c:if>

    <c:if test="${!empty prodMap['3']['16']}">
        <div class="report-message-details">
            <div class="report-message-details-table">
                <p>涉诉风险明细信息</p>
                <p>裁判文书（）份</p>
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


                        <tr>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                        </tr>


                </table>
            </div>

            <div class="report-message-details-table">
                <p>执行公告（）份</p>
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


                        <tr>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                            <td style="width: 14.6%;"></td>
                        </tr>


                </table>
            </div>


            <div class="report-message-details-table">
                <p>失信公告（）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>发布时间</th>
                        <th>被执行人</th>
                        <th>执行法院名称</th>
                        <th colspan="2" style="width: 50%;">案号</th>
                    </tr>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td colspan="2" style="width: 50%;"></td>
                        </tr>

                </table>
            </div>


            <div class="report-message-details-table">
                <p>法院公告（）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>发布时间</th>
                        <th>当事人</th>
                        <th>法院名称</th>
                        <th colspan="2" style="width: 50%;">公告类型</th>
                    </tr>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td colspan="2" style="width: 50%;"></td>
                        </tr>


                </table>
            </div>


            <div class="report-message-details-table">
                <p>网贷黑名单（）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>贷款时间</th>
                        <th>姓名</th>
                        <th colspan="3" style="width: 68%;">身份证号</th>
                    </tr>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td colspan="3" style="width: 68%;"></td>
                        </tr>


                </table>
            </div>

            <div class="report-message-details-table">
                <p>案件流程信息（）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>立案时间</th>
                        <th>案件进度</th>
                        <th>当事人</th>
                        <th>法院名称</th>
                        <th>案号</th>
                    </tr>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>


                </table>
            </div>

            <div class="report-message-details-table">
                <p>开庭公告（）份</p>
                <table cellspacing="0" cellpadding="0">
                    <tr>
                        <th>编号</th>
                        <th>开庭时间</th>
                        <th>案由</th>
                        <th>被执行人</th>
                        <th>法院名称</th>
                        <th>案号(文书字号)</th>
                    </tr>


                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>

                </table>
            </div>



            <div class="report-message-table">
                <p class="report-message-title">不良信息</p>
                <table cellspacing="0" cellpadding="0" class="report-message-table1">
                    <tr>
                        <td>姓名</td>
                        <td></td>
                        <td>身份证号</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>核查代码</td>
                        <td></td>
                        <td>核查信息</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>发案时间</td>
                        <td colspan="3"></td>
                    </tr>
                </table>
            </div>


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
                    <td style="background-color: #F9F9F9"></td>
                    <td style="background-color: #F9F9F9">姓名</td>
                    <td></td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">卡类型</td>
                    <td></td>
                    <td>近6个月发生交易月份数</td>
                    <td></td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">近6个月交易金额</td>
                    <td></td>
                    <td>近6个月交易笔数</td>
                    <td></td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">近6个月最大交易金额</td>
                    <td></td>
                    <td>近6个月笔均交易金额</td>
                    <td></td>
                </tr>


                <tr>
                    <td style="background-color: #F9F9F9">近6个月发生交易的MCC种类数</td>
                    <td></td>
                    <td>常用地区</td>
                    <td></td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">交易金额稳定性</td>
                    <td></td>
                    <td>12个月取现交易金额</td>
                    <td></td>
                </tr>
                <tr>
                    <td style="background-color: #F9F9F9">12个月跨境交易金额</td>
                    <td></td>
                    <td>12个月转入交易金额</td>
                    <td></td>
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
                                    <td style="border-width: 0px 1px 0px 0px;width:323px;"></td>
                                    <td style="border-width: 0px 1px 0px 0px; width: 25%; background-color: #f9f9f9;">
                                        证号
                                    </td>
                                    <td style="border-width: 0px 0px 0px 0px;"></td>
                                </tr>

                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    </tr>



                        <tr>
                            <td colspan="1" rowspan="16" style=" background-color: #f9f9f9; vertical-align: middle;">
                                合同信息
                            </td>
                            <td width="243" style=" background-color: #f9f9f9;">姓名</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">证件类型</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">证件号码</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">业务合同号</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">上报机构</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">信贷业务类型</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">信贷业务用途</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">合同金额</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">币种</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">还款频率</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">生效日期</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">终止日期</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">担保方式</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">发生地点名称</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">性别</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">出生日期</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">证件号码</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">业务合同号</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">婚姻状态</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">最高学历</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">联系手机</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">通讯地址</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">居住地址</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">居住状态</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">职业性质</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">单位名称</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">单位地址</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">职务 </td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">年收入</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">第一联系人姓名</td>
                            <td width="267"></td>
                        </tr>

                        <tr>
                            <td width="243" style=" background-color: #f9f9f9;">第一联系人关系</td>
                            <td width="230"></td>
                            <td width="230" style=" background-color: #f9f9f9;">第一联系人电话</td>
                            <td width="267"></td>
                        </tr>





                            <tr>
                                <td colspan="1" rowspan="6" style=" background-color: #f9f9f9; vertical-align: middle;">
                                还款信息列表
                                </td>
                                <td width="243" style=" background-color: #f9f9f9;">还款期数(从1开始)</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">逾期标志</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">本期应还日期</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">本期应还金额</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">本期实还金额</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">当前负债余额</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">合同状态</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">最高逾期的金额</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">最高逾期的期数</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">当前逾期的期数</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">当前逾期的金额总和</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;"></td>
                                <td width="267"></td>
                            </tr>





                            <tr>
                                <td colspan="1" rowspan="4" style=" background-color: #f9f9f9; vertical-align: middle;">
                                    担保信息列表
                                </td>
                                <td width="243" style=" background-color: #f9f9f9;">担保人姓名</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">担保人证件类型</td>
                                <td width="267"></td>
                            </tr>

                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">担保人证件号</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">担保状态</td>
                                <td width="267"></td>
                            </tr>
                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">担保金额</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;">上报机构</td>
                                <td width="267"></td>
                            </tr>
                            <tr>
                                <td width="243" style=" background-color: #f9f9f9;">合同号</td>
                                <td width="230"></td>
                                <td width="230" style=" background-color: #f9f9f9;"></td>
                                <td width="267"></td>
                            </tr>





                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
    <%--行为报告结束--%>
    </c:if>


    <div class="report-message" style="margin-top: 50px;">
        <h2>查询记录</h2>
        <p style="text-align: center;">（统计过去24个月的查询信息）</p>
        <div class="report-message-table">
            <p class="report-message-title">全民个人报告</p>
            <table cellspacing="0" cellpadding="0" class="report-message-table1">
                <tr>
                    <td>查询机构数</td>
                    <td></td>
                    <td>查询次数</td>
                    <td></td>
                </tr>
                <tr>
                    <td>最近三个月查询机构数</td>
                    <td></td>
                    <td>最近三个月查询查询次数</td>
                    <td></td>
                </tr>
                <tr>
                    <td>近六个月查询机构数</td>
                    <td></td>
                    <td>最近六个月查询查询次数</td>
                    <td></td>
                </tr>
            </table>
        </div>
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
        <a href="#">下载报告</a>
    </div>
</div><!--middle-width-->


</body>
</html>
