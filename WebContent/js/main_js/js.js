$(document).ready(function(){
	/**/
	/*var x=document.getElementsByClassName('main_imageChange');*/
	
	/*for(var i=1; i < x.length; i++ ) 
	{
		
		(function(m){x.item(i).addEventListener("mouseover", function() {change(m);} );	}) (i);
		function(m)은 스코프체인으로 change까지 객체가 생성되고 해당하는 번호의 노드만 변경할수있게끔
		(function(m){x.item(i).addEventListener("mouseout",function(){unchange(m);});})  (i);
	}*/
	/**/
	/*$('.control_button').each(function(index){
		$(this).attr('data-index',index);
	}).click(function(){
		var index = $(this).attr('data-index');
		moveSlider(index);
	});
	function moveSlider(index){
		var willMoveLeft=-(index*600);
		$('.main_banner').animate({left:willMoveLeft}, 'slow');
		
		$('.control_button[data-index='+index+']').addClass('active');
		$('.control_button[data-index!='+index+']').removeClass('active');
	}*/
	/* $('#checkbox').change(function(){
		    setInterval(function () {
		        moveRight();
		    }, 3000);
		  });*/
	$("#main_rightButton").click(function(){
		$("#main_feeling_recommend").slideToggle("slow");
		$("#main_feeling_recommend_change").slideToggle("slow");
    });
	$(".profile_myWrite_recipe").click(function(){
		$(".profile_myWrite_recipe").slideToggle("slow");
	})
			
	
    


});/*



/*function change(j)
{

	var str= document.getElementsByClassName('main_imageChange').item(j).src;
	var res= str.replace(".png","c.png");
	document.getElementsByClassName('main_imageChange').item(j).src=res;
}
function unchange(k)
{

	var str= document.getElementsByClassName('main_imageChange').item(k).src;
	var res= str.replace("c.png",".png");
	document.getElementsByClassName('main_imageChange').item(k).src=res;
}*/