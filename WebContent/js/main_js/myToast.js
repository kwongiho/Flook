
$(function() {
	var i = -1;
	var toastCount = 0;

	toastr.options = {
			closeButton : false,
			debug : false,
			newestOnTop : false,
			progressBar : true,
			positionClass : "toast-top-center",
			preventDuplicates : false,
			onclick : null
	};
	toastr.options.showDuration = "100";
	toastr.options.hideDuration = "300";
	toastr.options.timeOut = "1000";
	toastr.options.extendedTimeOut = "100";
	toastr.options.showEasing = "swing";
	toastr.options.hideEasing = "linear";
	toastr.options.showMethod = "fadeIn";
	toastr.options.hideMethod = "fadeOut";
	
	$('#recipe_ingredient_add_cart').click(function() {
		var shortCutFunction = "success";
		var msg = "장바구니에 추가되었습니다.";
		var title = "장바구니 추가";



		var $toast = toastr[shortCutFunction](msg, title); 
	});
	$('#bookmarkBtn').click(function() {
		var shortCutFunction = "success";
		var msg = "스크랩에 추가되었습니다.";
		var title = "스크랩 추가";

		

		var $toast = toastr[shortCutFunction](msg, title); 
	});
	$('#heart_Btn').click(function() {
		var shortCutFunction = "success";
		var msg = "좋아요~♥..♥";
		var title = "좋아요";



		var $toast = toastr[shortCutFunction](msg, title); 
	});
	$('#shareBtn').click(function() {
		var shortCutFunction = "success";
		var msg = "공유 되었습니다.";
		var title = "공유하기";



		var $toast = toastr[shortCutFunction](msg, title); 
	});

})