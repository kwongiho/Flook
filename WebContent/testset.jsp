<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="margin.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<style>
.fork_group {
	width:1000px;
	height:25px;
	display:flex;
}
.rating_fork {
	/*width:126px;*/
	width:25px;
	height:25px;
	background-image: url('img/search_img/images/ratingfork.png');
}
.fork1:hover{
	
	background-position:-26x 0px;
}
.fork2:hover{
	background-position:0px 0px;
}
.fork3:hover{
	background-position:0px 0px;
}
.fork4:hover{
	width:126px;
	background-position:0px 0px;
}
.fork5:hover{
	width:126px;
	background-position:0px 0px;
}
</style>
<script>
window.onload=function(){
	$(".fork2").hover(function(){
		$(".fork1").css("display","none");
		$(".fork3").css("display","none");
		$(".fork4").css("display","none");
		$(".fork5").css("display","none");
		
	},function(){
		$(".fork1").css("display","");
		$(".fork3").css("display","");
		$(".fork4").css("display","");
		$(".fork5").css("display","");
	});
}

</script>
<div class="fork_group">
	<div class="rating_fork fork1">
	</div>
	<div class="rating_fork fork2">
	</div>
	<div class="rating_fork fork3">
	</div>
	<div class="rating_fork fork4">
	</div>
	<div class="rating_fork fork5">
	</div>
</div>
</body>
</html>
