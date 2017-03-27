
/**
 * 
 * datatable 业务封装函数
 * 一般页面上写死初始化元素 id为 dataTableId
 * 接受Object参数如下
 * {
 * 	url: xxxx,
 * 	cols: [{name:xxx, render:function(data, type, row){}},{},{}.....],
 * 	data: function(){return {"":"","":""}} 提交服务端参数 会自动加入startPage pageSize
 * }
 * 
 * java服务端返回值参照 DataTableResult<T>
 * @param param
 * @returns 返回创建对象本身 用于搜索调用draw()方法重新加载数据
 */
function initDataTable(param){
	var columns = [];
	var columnDefs = [];
	for(var i=0;i<param.cols.length;i++){
		var iobj = param.cols[i];
		columns[i] = iobj.name == undefined ? {data: getRandField(param.cols)}:{data: iobj.name};
		if(iobj.render != undefined){
			columnDefs.push({
				"targets": i,
				"render": iobj.render
			});
		}
	}
	
	/**
	 * 随机使用传递对象字段，防止报错
	 */
	function getRandField(colsArr){
		for(var i=0;i<colsArr.length;i++){
			if(colsArr[i].name != undefined){
				return colsArr[i].name;
			}
		}
	}
	
	var dataTable = $('#dataTableId').DataTable({
    	bProcessing: true, // 是否显示取数据时的那个等待提示
	    bServerSide: true,//这个用来指明是通过服务端来取数据
	    searching: false,
	    bAutoWidth: false,
	    bDeferRender: true,
	    responsive: true,
// 	    "scrollX": "1520px",
	    ordering: false,
	    pageLength: 25,
        sAjaxSource: param.url,//这个是请求的地址
        fnServerData: retrieveData, // 获取数据的处理函数
        columns: columns,
        columnDefs: columnDefs
    });
    
    function retrieveData(surl, data, fnCallback) {
    	var dataObj = {};
    	for(var i=0;i<data.length;i++){
    		dataObj[data[i].name] = data[i].value;
    	}
    	var sendServerData = {};
    	if(param.data != undefined){
    		sendServerData = param.data();
    	}
    	sendServerData["startPage"] = dataObj.iDisplayStart;
    	sendServerData["pageSize"] = dataObj.iDisplayLength;
		$.ajax({
			url : surl,//这个就是请求地址对应sAjaxSource
			data : sendServerData,//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
			type : 'post',
			dataType : 'json',
			async : false,
			success : function(result) {
				fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
			},
			error : function(msg) {
			}
		});
	}
    
    return dataTable;
}
