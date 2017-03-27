<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商户管理</title>
</head>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<jsp:include page="/WEB-INF/jsp/common/menuPage.jsp"></jsp:include>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
				<div class="am-cf am-padding">
					<div class="am-fl am-cf">
						<strong class="am-text-primary am-text-lg">首页</strong> /  
						<small>商户管理</small>
					</div>
				</div>
				
				<div class="am-g">
				<div class="am-u-sm-12 am-u-md-8">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"
								onclick="addCompany(this)"> 新增
							</button>

						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-2 am-text-right">
					<div class="am-form-group">
						<select data-am-selected="{btnSize: 'sm'}" data-am-selected
							id="status">
							<option value=" " selected="selected">全部</option>
							<option value="1">正常</option>
							<option value="2">已禁用</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-2">
					<div class="am-input-group am-input-group-sm">
							<span class="am-input-group-btn">
								<button class="am-btn am-btn-default" type="button" onclick="searchUpgradeConfig();">搜索</button>
							</span>
					</div>
				</div>
							
				<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table  width="100%" class="am-table am-table-bordered am-table-centered am-table-striped am-table-hover responsive am-table-compact am-text-nowrap "
							id="list_table">
					    	<thead>
						        <tr>
<!-- 						            <th style="text-align: center;" width="3%">序号</th> -->
						            <th style="text-align: center;" width="10%">公司名称</th>
						            <th style="text-align: center;" width="10%">状态</th>
						            <th style="text-align: center;" width="20%">创建时间</th>
						            <th style="text-align: center;" width="10%">创建人</th>
						            <th style="text-align: center;" width="15%">操作</th>
						        </tr>
					    	</thead>
						    <tbody>
						       
						    </tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	</div>

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	$(function(){
		dataTable = initDataTable(
				{
					ajax : "${basePath}/company/queryCompanyList",
					columns : [
// 							'rowIndex',
							'companyname',
							{
								data : 'status',
								defaultContent : '',
								render : function(v){
									if(v == 1){
										return '正常';
									}else if(v == 2){
										return '禁用';
									}
								}
							},
							{ className: "am-text-middle", data:'createtime' ,
						   	 	render:function(data, type, row){
										return formatDateYYMMddHHmiss(data);
						  	  	}
						   	 },
							'opername',
							function(v, vm, obj, tableObj) {
								var id = obj.id;
								var upgradeFlag = obj.upgradeFlag;
								var btnGroup = '<div class="am-btn-group am-btn-group-xs">';
								//编辑
								btnGroup += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary" data-id="'
										+ id
										+ '" onclick="addUpgradeConfig(this)"><span class="am-icon-pencil-square-o"></span>编辑</a>';
								//强制升级   升级标志 0：最新  1：可选升级2：强制升级
								if(upgradeFlag == 1){
									btnGroup += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary" data-id="'
										+ id
										+ '" onclick="forceUpgrade(this)" style="margin-left:10px;">强制升级</a>';
								}
								
								btnGroup += '</div>';
								return btnGroup;
							} ]
				}, function(data) {
					return {
						'channel' : $('#channel').val(),
					};
				});
		
	});
</script>
</html>