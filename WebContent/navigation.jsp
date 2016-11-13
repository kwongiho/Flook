<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta name="google" value="notranslate" />
<link href="css/main_css/navigation.css" media="screen" rel="stylesheet" type="text/css" />
<script
	src="https://d12hfz37g51hrt.cloudfront.net/assets/d3.min-207c99244c96d9e357c59b3765242a54.js"
	type="text/javascript"></script>
<script
	src="https://d12hfz37g51hrt.cloudfront.net/assets/v2/home-fa006996482c29da26bf6424ccf0892b.js"
	type="text/javascript"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="js/profile_js/myWriteRecipe.js" type="text/javascript"
	charset="UTF-8"></script>
<!--     <script type="text/javascript">
    window.WATCHA_USER = {
      NAME: "권교오오오옹ㄱ",
      THUMB: "https://d12hfz37g51hrt.cloudfront.net/user/1595457/small/4013b90ba44e55e5dbea7ad5c7337907c7a1d4dd.jpg",
      CODE: "0JisbXCHBhiO",
      FB_CONNECTED: true
    };
    window.WATCHA_PARTNER = {};
    </script> -->
<!--[if lt IE 9]>
    <script src="https://d12hfz37g51hrt.cloudfront.net/assets/ie/html5shiv-af99d00a102b8b477e519f8256d41cf5.js" type="text/javascript"></script>
    <![endif]-->
<!--[if lte IE 8]>
    <script charset="utf-8" src="https://d12hfz37g51hrt.cloudfront.net/assets/r2d3.min-100ffbe5488304796fdb7ecb5e4397ca.js" type="text/javascript"></script>
    <![endif]-->
<!--[if gte IE 9]><!-->
<!--<![endif]-->
<link rel="stylesheet" href="css/main_css/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="css/main_css/assets/css/styles.css">
<link rel="stylesheet" type="text/css" href="css/profile_css/cs.css">
<link href="css/viewCart_css/viewCart.css" rel="stylesheet">
<link href="css/main_css/cs.css" rel="stylesheet">
</head>
<body class="home on">
	<div id="header" class="">
		<div class="for-popup-scroll-area-margin">
			<div class="inner responsive-mask">
				<ul class="gnb clearfix">
					<li class="navi-item home on"><a href="main.jsp"> <img
							src="img/main_img/logo9.png" id="flookLogo" width="75"
							height="70">
					</a></li>
					<!--li class="navi-item boxoffice "><a href="FlookRecipe.jsp"
						id="flookChief" onclick="flookRecipe();"
						style="text-decoration: none">Flook 요리사</a> <span
						class="highlight"></span></li-->
					<li class="navi-item genre "><a href="myRecipe.jsp"
						id="imChief" style="text-decoration: none">나도 요리사</a> <span
						class="highlight"></span></li>
					<!-- 			<li class="navi-item evalmore "><a href="/evalmore">평가늘리기</a>
						<span class="highlight"></span></li> -->
				</ul>
				<form accept-charset="UTF-8" action="search" id="search-form"
					method="post">
					<div class="input-wrapper">
						<input id="input-query" name="query" type="search"
							autocomplete="off" class="ui-autocomplete-input"> <span
							id="search-icon"></span> <input type="hidden"
							id="instanceofHidden" name="search_input_keyword">
					</div>
				</form>
				<!--  -->

				<script type="text/javascript">
					$('#input-query').keypress(
							function(event) {
								if (event.which == 13) {
									$("#instanceofHidden").val(
											$("#input-query").val());
									$("#flookNav_search_form").submit();
								}
							});
				</script>

				<!--  -->
				<!-- 		<div id="gnb-middle-menu" class="middle-menu">
					<ul class="gnb clearfix" id="eventBtn">
						<li class="navi-item genre "><a href="/recommendation">1</a>
							<span class="highlight"></span></li>
						<li class="navi-item genre "><a href="/recommendation">2</a>
							<span class="highlight"></span></li>
						<li class="navi-item genre "><a href="/recommendation">3</a>
							<span class="highlight"></span></li>
					</ul>
				</div> -->
				<script>
					$(document).ready(function() {
						$("#dLabel2").click(function() {
							$.ajax({
								url : 'CartServlet',
								type : 'POST',
								data : {
									"cartKindOf" : "readOnly"
								},
								success : function(data) {
									$("#viewCart_cart").append(data);
								}
							});
						});
					});
				</script>
				<div id="gnb-right-menu" class="right-menu">
					<div id="event_menu"
						style="float: left; margin-right: 30px; padding-bottom: 5px;">
						<ul class="gnb clearfix" id="eventBtn">
							<li class="navi-item genre "><a href="#"
								onclick="location.href='writeRecipe.jsp'" id="eventIcon1"><input
									type="image" src="img/flook_img/writeRecipe.png" style="width:50px;height:50px;"></a> <span
								class="highlight"></span></li>
							<!-- <li class="navi-item genre "><a href="#" id="eventIcon2"><input
									type="image" src="img/flook_img/cart.png" style="width:50px;height:50px;"></a>
								<div class="menu my" id="test"></div> <span class="highlight"></span>
							</li> -->
							<!--  li class="navi-item genre "><a href="#"
								onclick="location.href='newsFeed'" id="eventIcon3"><input
									type="image" src="img/flook_img/newspid.png" style="width:50px;height:50px;"></a> <span
								class="highlight"></span></li-->
						</ul>
					</div>
					<div class="menu my" style="display: inline; float: right">
						<ul>
							<li>
							<!-- 아래 form은 상단의 네비바에 마우스 오버하면 나타나는 박스의 내프로필/로그아웃을 보기 위함. -->
							<form action="profileNiceness" method="POST" id="profileNiceness_form">
								<a href="#" class="myProfileNiceness" id="myName">
									<c:if test="${sessionScope.userName != null}">${sessionScope.userName}</c:if>
								</a>
								<c:choose>
									<c:when test="${sessionScope.userImage !=null}">
										<img class="thumbnail" src="${sessionScope.userImage}"
											style="width:70px; height:70px;"
											
											>
							 		</c:when>
									<c:when test="${sessionScope.userImage eq null }">
										<img class="thumbnail" src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png"
											style="width:70px; height:70px;"
											>
									</c:when>
									<c:otherwise>
										<img class="thumbnail" src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png"
											style="width:70px; height:70px;"
											>
									</c:otherwise>
								</c:choose>
								</li>
								
							<li><div class="dropdown">
									<ul>
										<li><a href="#" class="myProfileNiceness">내 프로필</a> <span
											class="count"></span></li>
										<li><a href="logOut">로그아웃</a></li>
									</ul>
								</div></li>
							</form>
								
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- modal -->
	<div class="modal fade" id="cartModal" role="dialog">
		<div class="modal-dialog2">
			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="closeBtn" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="modal-title">알림</h4>
				</div>
				<div class="modal-body" id="myCart_body">
					<p>레시피를 정말로 삭제 하시겠습니까?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="" id="myWriteRecipe_modal_yesBtn"
						data-dismiss="modal">예</button>
					<button type="button" class="" id="myWriteRecipe_modal_noBtn"
						data-dismiss="modal">아니요</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		window.WATCHA_USER_NAME = '권qwqer기호';
		window.WATCHA_USER_CODE = '0JisbXCHBhiO';
		// new Header('0JisbXCHBhiO', window.settingInstance);
	</script>

	<!-- <div id="contents" style="min-height:0px">
		<div class="kwz">
			<ul class="items bjqs">
				<li class="item idx-4">
					<div class="kwz-desc-wrapper"></div>
				</li>
			</ul>
		</div>
	</div> -->
</body>
</html>
