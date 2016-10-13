$.fn.raty.defaults.path = 'img/search_img/images';
$.fn.raty.defaults.path = 'img/search_img/images';
$(function() {
	$('#default').raty();
	$('#score-callback').raty({
		score : function() {
			return $(this).attr('data-score');
			
		}
	});
	$('#move-function-run').on(
			'click',
			function() {
				$('#functions').raty('move',
						$('#' + this.id.replace('-run', '')).val());
				
			});
});