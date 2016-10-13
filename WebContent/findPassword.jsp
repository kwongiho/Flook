<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html id="Login_html">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Flook 로그인</title>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <link href="css/findPassword_css/findPasswordCSS.css"  type="text/css" rel="stylesheet" charset="UTF-8">
<script>
	window.onload=function(){
		$("#Login_email_submit").click(function(){
			//이메일을 입력하지 않았을 경우.
			if($("#Login_input_email").val().trim()==null) {
				alert("이메일을 입력해 주세요.");
				$("#Login_input_email").focus();
				return;
			}
			//인증코드 발송 버튼 한번 클릭하면 버튼을 비활성화 시킨다.
			$("#Login_email_submit").attr("disabled",true);
			asyncSend();
		});
		
		function getXR() // HTTP 객체를 만드는 메소드.
		{
			var req;
			try{
				req=new XMLHttpRequest();
			}catch(e){
				try{
					req=new ActionXObject("Msxml2.XMLHTTP");
				}catch(q){
					req=new ActionObject("Microsoft.XMLHTTP");
				}
			}
			return req;
		}
		function asyncSend() // 비동기통신 ㅔ소드.
		{
			var req = getXR(); // HTTPRequest객체 하나 생성.
			var email; // email정보 저장할 변수선언.
			req.onreadystatechange=function(){
				/* var result = document.getElementById("result"); */
				email=$("#Login_input_email").val().trim(); /* document.getElementById("idText").value; */
				
				if(req.readyState==4){
					if(req.status==200){
						if(req.responseText.trim()!==email) {
							/*여기 설명...
							 아이디있음->인증코드 입력할 수 있는 칸 활성화
							 -> 기존버튼 attr안먹혀서 새로만듬, 새로만든 버튼 활성화
							 -> 기존버튼 attr안먹힌거 hide
							*/
							$("#Login_div_codeInput").show();/*인증코드 입력란 생성.*/
							$("#Login_div_btn2").show();/*인증 버튼 활성화.*/
							$("#Login_email_submit").hide();/*버튼비활성화*/
							
							$("#Login_skip").click(function(){
								if(req.responseText.trim()===$("#Login_input_code").val()) {
									alert("인증이 완료되었습니다!");
									/*인증코드가 일치한 경우.*/
									$("#Login_skip").hide();/*인증버튼 비활성화*/
									$("#Login_div_btn3").show();/*비밀번호 버튼 활성화*/
									$("#Login_input_code").val("");/*입력란 초기화해주.*/
									$("#Login_input_code").attr("placeholder","새로운 비밀번호 입력");
									$("#change_password").click(function(){
										$("#login_form").attr("action","findPasswordChange");
										$("#login_form").submit();
									});
									
								} else {
									
								}
							});
							
						} else {
							alert("존재하지 않는 이메일입니다.");
							$("#Login_email_submit").attr("disabled",false);
						}
						
					}else{
						alert("서버 에러발생");
					}
					

				}
			
			};
			
			req.open("post","sendCode",true);/*true로 할 경우만 비동기통신*/
			req.setRequestHeader("content-type","application/x-www-form-urlencoded; charset=UTF-8");
			req.send("email="+email);/*email 서블릿에서 받고 싶을때 getParameter("email") 하믄됨*/
			
			
		}
	};
</script>
  </head>
  <body>
    <div class="login_container" id="Login_container" >
      <form class="form-signin" action="" method="post" id="login_form">
        <div class="form-signin-heading" id="Login_h2"><span id="Login_span_header">비밀번호 찾기</span></div>  
	 		<div id="Login_div_email">
	        	<input type="email" id="Login_input_email" name="Login_email_email" placeholder="이메일 주소" required autofocus >
	        </div>
			<div id="Login_div_codeInput">
	        	<input type="text" id="Login_input_code" name="Login_input_code" placeholder="인증코드 입력." required >
	        </div>
	        <div id="Login_div_btn1">
	        	<button type="button" id="Login_email_submit" >인증코드 발송</button>
	        </div>
			<div id="Login_div_btn2">
	        	<button type="button" id="Login_skip" class="buttonCss">인증</button>
	        </div>
	        <div id="Login_div_btn3">
		        	<input type="button" id="change_password" value="비밀번호 변경"></button>
			</div>
      </form>
    </div>
  </body>
  </html>