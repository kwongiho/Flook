<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="targetProfile.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>취향 분석</title>
	<link rel="stylesheet" href="css/graph_css/style.css"><!-- doughnutChart -->
	<link href="https://d12hfz37g51hrt.cloudfront.net/assets/application/users-e181c3d18f0acf6faa94df158c9b3512.css"
	media="screen" rel="stylesheet" type="text/css" /><!-- 나라사진 끌어다 쓰려고 -->
    <link rel="stylesheet" type="text/css" href="css/profile_css/cs.css">
	<script type="text/javascript" src="https://www.google.com/jsapi"></script><!-- 국가 -->
	<script src="https://d12hfz37g51hrt.cloudfront.net/assets/application/users-04e4ff1a9c741e554926d84f7a12d79d.js"	type="text/javascript"></script><!-- 선호재료 -->
	<script src="https://d12hfz37g51hrt.cloudfront.net/assets/d3.min-e50a165b97a54da6306340a6ee37b203.js" type="text/javascript"></script><!-- 재료 -->


<link href="css/graph_css/chart_css/jquery.circliful.css" rel="stylesheet" type="text/css" />
<link href="css/graph_css/chart_fonts/font-awesome.min.css" rel="stylesheet" type="text/css" />

<script src="js/graph_js/jquery.circliful.min.js"></script>


<style>
body {
    font-family: arial,verdana, sans-serif;
    font-size: 12px;
    
}
</style>
<style>
.myCircle{
	float:left;
}
</style>


</head>
<body>
<script>
$( document ).ready(function() {
	$('.myCircle').circliful();

});
</script>
<section>
<div id="contents">
		<section id="taste">
		
		<div class="card sorted-by-rating" id="favorite-nations">
			<div class="row header">
				<h2 class="small">선호국가</h2>
				<span class="flavor-text">${countryMessage }
				</span>
			</div>
		</div>


	<c:forEach var="countryElement"  items="${countryList}" >
		<div class="myCircle"  data-dimension="200" data-text="${countryElement.percent}%"
			data-info="${countryElement.name }" data-width="10" data-fontsize="38"
			data-percent="${countryElement.percent}" data-fgcolor="#61a9dc" data-bgcolor="#eee"
			data-fill="#ddd"></div>
	</c:forEach> <!--파란색사각형 -->

	<div class="card sorted-by-rating" id="favorite-nations">
			<div class="row header">
				<h2 class="small">선호하는재료</h2>
				<span class="flavor-text">${ingredientMessage }
				</span>
			</div>
		</div>


	<c:forEach var="ingreElement" items="${ingredientList}">
		<div class="myCircle"  data-dimension="200" data-text="${ingreElement.percent}%"
			data-info="${ingreElement.name }" data-width="10" data-fontsize="38"
			data-percent="${ingreElement.percent}" data-fgcolor="#00E053" data-bgcolor="#eee"
			data-fill="#ddd"></div>

	</c:forEach> 
		<div class="card sorted-by-rating" id="favorite-nations">
			<div class="row header">
				<h2 class="small">선호하는방법</h2>
				<span class="flavor-text">${methodMessage }
				</span>
			</div>
		</div>

	<c:forEach var="methodElement" items="${methodList}">
		<div class="myCircle"  data-dimension="200" data-text="${methodElement.percent}%"
			data-info="${methodElement.name }" data-width="10" data-fontsize="38"
			data-percent="${methodElement.percent}" data-fgcolor="#FF011D" data-bgcolor="#eee"
			data-fill="#ddd"></div>
	</c:forEach> 
	
	
</section>
	
	<!-- http://codepen.io/jlalovi/details/bIyAr -->
<!-- http://codepen.io/jlalovi/details/bIyAr -->

	
</body>
</html>
