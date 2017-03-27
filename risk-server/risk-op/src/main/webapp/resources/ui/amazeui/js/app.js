(function($) {
  'use strict';

  $(function() {
    var $fullText = $('.admin-fullText');
    $('#admin-fullscreen').on('click', function() {
      //$.AMUI.fullscreen.toggle();
    	var dis = $("#admin-offcanvas").css("display")
    	if(dis=="none"){
    		sessionStorage.setItem("showMenu","0");
    		$("#admin-offcanvas").show();
    		$("#topFull").html("隐藏菜单栏");
    	}else{
    		sessionStorage.setItem("showMenu","1");
    		$("#admin-offcanvas").hide();
    		$("#topFull").html("显示菜单栏");
    	}
    });

    $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
      $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
    });
  });
})(jQuery);
