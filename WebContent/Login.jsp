<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="Login_html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flook 로그인</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<link href="css/login_css/LoginCSS.css" type="text/css" rel="stylesheet"
	charset="UTF-8">
<script type="text/javascript">
	$(document).ready(function() {
		if ('${loginError eq "fail"}' == 'true') {
			alert("아이디나 비밀번호를 잘못 입력하셨습니다.");
		}
		if ('${joinCheck eq "ok"}' == 'true') {
			alert("회원가입이 완료되었습니다!!");
		}
		$("#Login_email_submit").click(function() {
			$("#login_form").submit();
		});
		/* 		$("#Login_skip").click(function() {
		 windows.location = "main.jsp";
		 });
		 $("#Login_facebook_button").click(function() {
		 $("#login_form").attr("action", "facebook");
		 alert($("#Login_facebook_button").attr("action"));
		 $("#login_form").submit();
		 }); */
	});
</script>
</head>
<body>
	<div id="fb-root"></div>
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '834823976632410', // 앱 ID
				status : true, // 로그인 상태를 확인
				cookie : true, // 쿠키허용
				xfbml : true,
				version : 'v2.4'
			// parse XFBML
			});
			/* 			
			 FB.login(function(response) {
			   				if (response.status === 'connected') {

			 FB.api('/me', function(user) {
			 if (user) { 
			 var image = document.getElementById('image');
			 image.src = 'http://graph.facebook.com/' + user.id
			 + '/picture';
			 var name = document.getElementById('name');
			 name.innerHTML = user.name
			 var id = document.getElementById('id');
			 id.innerHTML = user.id
			 var email = document.getElementById('email');
			 email.innerHTML = user.email
			 var gender = document.getElementById('gender');
			 gender.innerHTML = user.gender
			 var birthday = document.getElementById('birthday');
			 birthday.innerHTML = user.birthday
			 }
			 });
			 } else if (response.status === 'not_authorized') {

			 } else {

			 }
			 }, {scope: 'public_profile,email'},{scope: 'public_profile,gender'},{scope: 'public_profile,birthday'});
			 */
			FB.getLoginStatus(function(response) {
				if (response.status === 'connected') {

					FB.api('/me', function(user) {
						if (user) {
							var image = document.getElementById('image');
							image.src = 'http://graph.facebook.com/' + user.id
									+ '/picture';
							var name = document.getElementById('name');
							name.innerHTML = user.name
							var id = document.getElementById('id');
							id.innerHTML = user.id
							var email = document.getElementById('email');
							email.innerHTML = user.email
							var gender = document.getElementById('gender');
							gender.innerHTML = user.sex
							var birthday = document.getElementById('birthday');
							birthday.innerHTML = user.birthday
						}
					});
				} else if (response.status === 'not_authorized') {

				} else {

				}
			}, {
				scope : 'public_profile,email'
			}, {
				scope : 'public_profile,gender'
			}, {
				scope : 'public_profile,birthday'
			});

			FB.Event.subscribe('auth.login', function(response) {
				document.location.reload();
			});
		};

		// Load the SDK Asynchronously
		(function(d) {
			var js, id = 'facebook-jssdk', ref = d
					.getElementsByTagName('script')[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement('script');
			js.id = id;
			js.async = true;
			js.src = "//connect.facebook.net/ko_KR/all.js";
			ref.parentNode.insertBefore(js, ref);
		}(document));
	</script>
	<div class="login_container" id="Login_container">
		<form class="form-signin" action="login" method="post" id="login_form">
			<div class="form-signin-heading" id="Login_h2">
				<span id="Login_span_header">로그인</span>
			</div>
			<div id="Login_innerContainer">
				<div id="Login_div_email">
					<input type="email" id="Login_input_email" name="Login_email_name"
						placeholder="이메일 주소" required autofocus>
				</div>
				<div id="Login_div_password">
					<input type="password" id="Login_input_password"
						name="Login_input_password" placeholder="비밀번호" required>
				</div>
				<div id="Login_div_btn1">
					<button type="submit" id="Login_email_submit">이메일로 로그인</button>
				</div>
				<div id="Login_div_btn2">
					<button type="button" id="Login_skip">건너뛰기</button>
				</div>
				<div id="Login_div_btn3">
					<input type="button" id="Login_facebook_button"
						onclick="FB.login();" value="Facebook 로그인">
				</div>
				<div id="Login_div_textBtn">
					<a href="findPassword.jsp" id="Login_passwordSearch">비밀번호 찾기</a><span
						id="Login_span"> / </span><a href="join.jsp" id="Login_membership">회원가입</a>
				</div>
			</div>
		</form>
	</div>
	<form>
		<div align="center">
			<img id="image" />
			<div id="name"></div>
			<div id="id"></div>
			<div id="email"></div>
			<div id="gender"></div>
			<div id="birthday"></div>
		</div>
	</form>
</body>
</html>
