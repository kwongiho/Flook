<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id="Login_html">
<head>
<meta name="viewport" content="width=device-width, user-scalable=no">
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
				<div id="Login_div_textBtn">
					<a href="findPassword.jsp" id="Login_passwordSearch">비밀번호 찾기</a><span
						id="Login_span"> / </span><a href="join.jsp" id="Login_membership">회원가입</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
