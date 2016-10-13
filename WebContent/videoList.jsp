<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

#videoList_header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
	height: 300px;
}

#videoList_body {
	/* display: inline-block;
	position: relative; */
	display: table;
	width: 100%;
	/* white-space:nowrap; */
}

#videoList_body div {
	/* width:100%; */
	display: table-cell;
	/* display:inline-block; */
	/* width:33.3%; */
}

#videoList_nav {
	/* 	line-height: 30px; */
	background-color: #eeeeee;
	height: 100%;
	/* float: left; */
	display: inline-block;
	text-align: left;
	white-space: nowrap;
}

#videoList_nav ul {
	padding: 0px;
	margin: 0px;
}

ul {
	width: 200px;
}

#videoList_nav ul li {
	list-style-type: none;
	border: 1px solid black;
	padding: 10px;
}

#videoList_section {
	/* display: inline-block;
	position: relative;
	width:500px; */
	text-align: center;
}

.videoList_video {
	/* width: 350px; */
	/* width: 500px; */
	/* float: left; */
	display: inline-block;
	padding: 10px;
	/* position: relative;
	top: 10%;
	transform: translateY(-70%); */
}

.videoList_videoImg {
	width: 350px;
}

.videoList_videoTitle {
	font-size: 30px;
	color: white;
	font-weight: bold;
	text-align: center;
}

#testtest{
	height:100px;
}
</style>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="videoList_header">
		<h1>TV방송 이미지 넣을 부분</h1>
	</div>

	<div id="videoList_body">
		<div id="videoList_nav">
			<ul>
				<li><a href="#">냉장고를 부탁해</a></li>
				<li><a href="#">삼시세끼</a></li>
				<li><a href="#">야간 매점</a></li>
				<li><a href="#">주문을 걸어</a></li>
				<li><a href="#">한食대첩3</a></li>
				<li><a href="#">오늘뭐먹지?</a></li>
				<li><a href="#">올리브쇼 이지레시피</a></li>
				<li><a href="#">올리브쇼2014</a></li>
			</ul>
		</div>

		<!-- <div id="videoList_section">
		<div class="videoList_video">
			<a href="#"><img
				src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"></a>
		</div>
		<div class="videoList_video_name">동영상명 부분</div>
		<div class="videoList_Video_description">동영상 설명 부부</div>
	</div> -->

		<div class="videoList_section">
			<div class="videoList_video">
				<table>
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div>
			<br/>

			<c:forEach var="video" items="${videoArray}">
				<div class="videoList_video">
					<table>
						<tr>
							<td>${video.postCode}</td>
						</tr>
					</table>
				</div>
			</c:forEach>


			<!-- <div class="videoList_section">
				<table class="videoList_video">
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div>

			<div class="videoList_section">
				<table class="videoList_video">
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div>

			<div class="videoList_section">
				<table class="videoList_video">
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div>

			<div class="videoList_section">
				<table class="videoList_video">
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div>
			<div class="videoList_section">
				<table class="videoList_video">
					<tr>
						<td></td>
						<td rowspan=2><img
							src="image/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg"
							class="videoList_videoImg"></td>
					</tr>
					<tr>
						<td colspan=2><a class="videoList_videoTitle">This is the
								overlay text<a></a></td>
					</tr>
				</table>
			</div> -->
		</div>
	</div>


	<!-- <div id="videoList_section">
		<h2>London</h2>
		<p>London is the capital city of England. It is the most populous
			city in the United Kingdom, with a metropolitan area of over 13
			million inhabitants.</p>
		<p>Standing on the River Thames, London has been a major
			settlement for two millennia, its history going back to its founding
			by the Romans, who named it Londinium.
			Standing on the River Thames, London has been a major
			settlement for two millennia, its history going back to its founding
			by the Romans, who named it Londinium.</p>
	</div> -->

</body>
</html>