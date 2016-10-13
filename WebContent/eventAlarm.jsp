<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/profile_js/js.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="css/profile_css/cs.css">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="dropdown">
		<button id="dLabel" type="button" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false">
			<input type="image" src="img/profile_img/Appointment Reminders-100.png"
				id="eventAlarm_btn" width="30px"> <span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
			<div class="eventAlarm_table">
				<table>
					<tr>
						<td rowspan="2"><input type="image" id="friendsList_profileImg"
							src="img/profile_img/10345982_852744308099397_1882240356207679456_n.jpg" /></td>
						<td>김정윤님이 리코타치즈샐러드 게시물을 좋아합니다. </td>
						<td rowspan="2"><input type="image" id="eventAlarm_table_foodImg" 
							src="img/profile_img/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg" /></td>
					</tr>
					<tr>
						<td>4시간 전</td>
					</tr>
				</table>
			</div>
			<div class="eventAlarmMain_space"></div>
			<div class="eventAlarm_table">
				<table>
					<tr>
						<td rowspan="2"><input type="image" id="friendsList_profileImg"
							src="img/profile_img/10345982_852744308099397_1882240356207679456_n.jpg" /></td>
						<td>김정윤님이 리코타치즈샐러드 게시물을 좋아합니다. </td>
						<td rowspan="2"><input type="image" id="eventAlarm_table_foodImg" 
							src="img/profile_img/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg" /></td>
					</tr>
					<tr>
						<td>4시간 전</td>
					</tr>
				</table>
			</div>
			<div class="eventAlarmMain_space"></div>
			<div class="eventAlarm_table">
				<table>
					<tr>
						<td rowspan="2"><input type="image" id="friendsList_profileImg"
							src="img/profile_img/10345982_852744308099397_1882240356207679456_n.jpg" /></td>
						<td>김정윤님이 리코타치즈샐러드 게시물을 좋아합니다. </td>
						<td rowspan="2"><input type="image" id="eventAlarm_table_foodImg" 
							src="img/profile_img/1301-609224-Grilled-tun-steks--l-nicoise-recipe.jpg" /></td>
					</tr>
					<tr>
						<td>4시간 전</td>
					</tr>
				</table>
			</div>
			<div class="eventAlarmMain_space"></div>
			<div id="eventAlarm_table_moreBtn">
				<a href="eventAlarmMain.jsp">+ 더 보기</a>
			</div>
		</ul>
	</div>
</body>
</html>