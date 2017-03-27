/**
 * ajax请求
 */
function ajaxRequest(ajaxParams, fnSuccess, fnError) {
	var success = function(data) {
		if ('200' == data.statusCode) {
			layer.msg(data.message, {
				icon : 1,
				tipsMore : true
			});
			fnSuccess && fnSuccess(data);
		} else if ('301' == data.statusCode) {
			window.location.href = basePath;
		} else if ('403' == data.statusCode) {
			window.location.href = basePath + '/refuse.jsp';
		} else if (typeof data === 'string') { // 直接是页面交给前端处理
			fnSuccess && fnSuccess(data);
		} else {
			// 公共处理error
			if (data.message) {
				layer.msg(data.message, {
					icon : 2,
					tipsMore : true
				});
			} else if (typeof data == 'object') {
				fnSuccess && fnSuccess(data);
			} else {
				layer.msg('未知错误', {
					icon : 2,
					tipsMore : true
				});
			}
			fnError && fnError(data);
		}
	};
	var error = function(xmlHttpRequest, textStatus, errorThrown) {
		// 公共处理error
		var data = xmlHttpRequest.responseJSON;
		if(data) {
			if ('301' == data.statusCode) {
				window.location.href = basePath;
			}
			if (data.message) {
				layer.msg(data.message, {
					icon : 2,
					tipsMore : true
				});
			} else {
				layer.msg('未知错误', {
					icon : 2,
					tipsMore : true
				});
			}
		}
		fnError && fnError(data);
	};
	
	var default_params = {
		type : 'POST',
		dataType:'json',
        cache: false,
		success : success,
		error : error
	};
	
	ajaxParams = $.extend(default_params, ajaxParams);
	$.ajax(ajaxParams);
}

function formatDateYYMMdd(dateStr) {
	var d = new Date(dateStr);
	// + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds()
	return d.getFullYear() + "-" + leftPadZero(d.getMonth() + 1) + "-" + leftPadZero(d.getDate());
}

function formatDateYYMMddHHmiss(dateStr) {
	var d = new Date(dateStr);
	return d.getFullYear() + "-" + leftPadZero(d.getMonth() + 1) + "-" + leftPadZero(d.getDate()) + " "
			+ leftPadZero(d.getHours()) + ":" + leftPadZero(d.getMinutes()) + ":" + leftPadZero(d.getSeconds());
}

function leftPadZero(num) {
	return num < 10 ? "0"+num : num;
}

// 初始化表格数据
function initDataTable(tableId, settings, fnQueryParams) {

	// datatables默认设置
	var DATATABLES_DEFAULT_SETTING = {
		ajax : {
			type : "POST"
		},
		dom : "<'am-g am-datatable-hd'<'am-u-sm-6'f>>"
				+ "<'am-g'<'am-u-sm-12'tr>>"
				+ "<'am-g am-datatable-footer'<'am-u-sm-2'i><'am-u-sm-1'l><'am-u-sm-4'p>>",
		searching : false,
		ordering : false,
		serverSide : true, // ajax支持
		processing : true,// 加载支持
		language : {
			lengthMenu : '_MENU_ '
		},
		lengthMenu : [ 20, 50, 100 ]
	};

	// 参数类型判断
	if (typeof tableId == 'object') {
		fnQueryParams = settings;
		settings = tableId;
		tableId = settings.tableId || 'list_table';
		if (settings.url) {
			tableId = 'dataTableId';
		}
	}
	
	settings = settings || {};

	// ajax language 扩展
	var ajax = settings.ajax || {url : settings.url || ''};
	
	if (typeof ajax == 'string') {
		ajax = {
			url : ajax
		};
	}

	fnQueryParams = fnQueryParams || settings.data || function(data) {
		return {};
	};

	// 查询参数拼接
	if (fnQueryParams && typeof fnQueryParams === 'function') {
		ajax.data = function(data) {
			var pageParam = {
				'offset' : data.start,
				'limit' : data.length,
			};
			
			var newdata = $.extend(pageParam, fnQueryParams(data));
			return newdata;
		};
	}

	ajax = $.extend(DATATABLES_DEFAULT_SETTING.ajax, ajax);

	// language 扩展
	var language = settings.language || {};
	language = $.extend(DATATABLES_DEFAULT_SETTING.language, language);

	// 重设 ajax language
	settings.ajax = ajax;
	settings.language = language;

	// 扩展column
	var columns = settings.columns || settings.cols || [];
	var _columns = [];
	for (var i = 0, l = columns.length; i < l; i++) {
		var c = columns[i];
		if (typeof c === 'string') {
			c = {
				data : c,
				defaultContent : ''
			};
		} else if (typeof c === 'function') {
			c = {
				data : 'id',
				defaultContent : '',
				render : c
			};
		} else if (typeof c === 'object') {
			var d = {
				data : c.name || c.data,
				defaultContent : '',
				render : c.render
			};
			c = $.extend(d, c);
		}
		_columns.push(c);
	}
	settings.columns = _columns;

	settings = $.extend(DATATABLES_DEFAULT_SETTING, settings);

	return $('#' + tableId).DataTable(settings);
}

/**
 * 初始化上传插件
 */
function initUploadify(id, fnSuccess, fnError, fnStart) {
	var settings = {};
	if (typeof id == 'object') {
		settings = id;
		id = settings.id;
	}
	var default_setting = {
		'auto' : false,
		'fileSizeLimit' : '5MB',// 最大大小
		'fileTypeExts' : '*.jpg;*.png;*.jpeg;*.bmp;*.gif', // 控制可上传文件的扩展名，启用本项时需同时声明fileDesc
		'fileTypeDesc' : '请选择jpg,png,jpeg,bmp,gif格式',// 与fileTypeExts配套使用，用来设置选择文件对话框中的提示文本
		'width' : '100',// 按钮宽度
		'height' : '32',// 按钮高度
		'multi' : true,
		'progressData' : 'percentage',// 设置上传进度显示方式，percentage显示上传百分比，speed显示上传速度
		'removeCompleted' : false,// 是否自动将已完成任务从队列中删除，如果设置为false则会一直保留此任务显示。
		'swf' : basePath + '/resources/js/uploadify/uploadify.swf',// 控件flash文件位置
		'uploader' : basePath + '/file/upload/' + (settings.type || 0),
		'queueID' : 'queue-' + id,// 与下面HTML的div.id对应
		'buttonText' : '选择文件',// 上传按钮显示内容，还有个属性可以设置按钮的背景图片
		'method' : 'POST',
		buttonClass : 'am-input-group-btn',
		'fileObjName' : 'file-' + id,
		'onUploadSuccess' : function(file, data, response) {// 上传成功之后把文件名存在隐藏域
			fnSuccess && fnSuccess(file, data, response);
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			fnError && fnError(file, errorCode, errorMsg, errorString);
		},
		'onUploadStart' : function(file) {// 开始上传时触发
			fnStart && fnStart(file);
		},
		'onFallback' : function() {// 当Uploadify初始化过程中检测到当前浏览器不支持flash时触发。
			alert("当前浏览器不支持FLASH，请更换浏览器再试！");
		},
		'onSelectError' : function() {
			alert("选择文件失败！");
		}

	};
	settings = $.extend(default_setting, settings);
	$('#' + id).uploadify(settings);
}


/**
 * 初始化上传文件
 */
function uploadApkFile(id, fnSuccess, fnError, fnStart) {
	var settings = {};
	if (typeof id == 'object') {
		settings = id;
		id = settings.id;
	}
	var default_setting = {
		'auto' : true,
		'fileSizeLimit' : '5MB',// 最大大小
		'fileTypeExts' : '*.apk', // 控制可上传文件的扩展名，启用本项时需同时声明fileDesc
		'fileTypeDesc' : '请选择apk格式文件',// 与fileTypeExts配套使用，用来设置选择文件对话框中的提示文本
		'width' : '100',// 按钮宽度
		'height' : '32',// 按钮高度
		'multi' : false,
		'progressData' : 'percentage',// 设置上传进度显示方式，percentage显示上传百分比，speed显示上传速度
		'removeCompleted' : false,// 是否自动将已完成任务从队列中删除，如果设置为false则会一直保留此任务显示。
		'swf' : basePath + '/resources/js/uploadify/uploadify.swf',// 控件flash文件位置
		'uploader' : basePath + '/file/upload/' + (settings.type || 0),
		'queueID' : 'queue-' + id,// 与下面HTML的div.id对应
		'buttonText' : '请选择文件',// 上传按钮显示内容，还有个属性可以设置按钮的背景图片
		'method' : 'POST',
		buttonClass : 'am-input-group-btn',
		'fileObjName' : 'file-' + id,
		'onUploadSuccess' : function(file, data, response) {// 上传成功之后把文件名存在隐藏域
			fnSuccess && fnSuccess(file, data, response);
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			fnError && fnError(file, errorCode, errorMsg, errorString);
		},
		'onUploadStart' : function(file) {// 开始上传时触发
			fnStart && fnStart(file);
		},
		'onFallback' : function() {// 当Uploadify初始化过程中检测到当前浏览器不支持flash时触发。
			alert("当前浏览器不支持FLASH，请更换浏览器再试！");
		},
		'onSelectError' : function() {
			alert("选择文件失败！");
		}

	};
	settings = $.extend(default_setting, settings);
	$('#' + id).uploadify(settings);
}

function isNotNull(val){
	return $.trim(val).length >= 0;
}