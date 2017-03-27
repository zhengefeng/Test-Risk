/**
 * Created by admin on 2015/12/28.
 */
// 错误提示
layer.error = function(content, options, end) {
	options = options || {};
	options.icon = 2;
	options.tipsMore = true;
	var args = [ content, options, ];
	layer.msg.apply(this, args);
};

// 成功提示
layer.success = function(content, options, end) {
	options = options || {};
	options.icon = 1;
	options.tipsMore = true;
	var args = [ content, options, ];
	layer.msg.apply(this, args);
};

// 警告提示
layer.warn = function(content, options, end) {
	options = options || {};
	options.icon = 0;
	options.tipsMore = true;
	var args = [ content, options, ];
	layer.msg.apply(this, args);
};

// 加载进度条
layer.loading = function(type) {
	type = type || 1;
	layer.load(type, {
		shade : [ 0.5, '#fff' ]
	});
};

// 弹出框
layer.dialog = {};
layer.dialog.open = function(url, dialogOptions, ajaxOptions) {
	ajaxOptions = ajaxOptions || {};
	dialogOptions = dialogOptions || {};
	var successFn = function(data) {
		dialogOptions.content = data;
		dialogOptions.type = 1;
		layer.open(dialogOptions);
	};
	if (typeof url === 'string') {
		dialogOptions = jQuery.extend({}, dialogOptions);
		ajaxOptions = jQuery.extend({
			url : url,
			dataType : 'html'
		}, ajaxOptions);
		if (ajaxOptions.success) {
			var fn = ajaxOptions.success;
			ajaxOptions.success = function(data) {
				data = fn(data);
				if (data.success) {
					successFn(data.content);
				} else {
					data.error(data.content);
				}
			}
		} else {
			ajaxOptions.success = successFn;
		}
		jQuery.ajax(ajaxOptions);
	} else if (typeof url === 'object') {
		dialogOptions = url;
		dialogOptions = jQuery.extend({}, dialogOptions);
		layer.open(dialogOptions);
	}
};