<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- <script type="text/javascript" src="js.js" charset="UTF-8"></script> -->
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
<script>
	$(document).ready(function() {
		/* $("#newspeed_latestResult").hide(); */
		$("#newspeed_popularResult").hide();

		$("#newspeed_latestBtn").click(function() {
			$("#newspeed_popularResult").hide();
			$("#newspeed_latestResult").show();
		});
		$("#newspeed_popularBtn").click(function() {
			$("#newspeed_popularResult").show();
			$("#newspeed_latestResult").hide();
		});
	});
</script>
<style>
#newspeed_post_food {
	width: 600px;
	height: 320px;
}

#newspeed_latestBtn, #newspeed_popularBtn {
	color: #666666;
}
</style>
</head>
<body>
	<!-- 인기순/최신순 버튼 -->
	<jsp:include page="navigation.jsp" flush="false" />
	<div id="newspeed_toggleBtn_outer">
		<div class="btn-group" data-toggle="buttons" id="newspeed_toggleBtn">
			<label class="btn btn-primary active"> <input type="radio"
				name="options" id="option1" autocomplete="off" checked> <a
				href="#" id="newspeed_latestBtn">최신순</a>
			</label> <label class="btn btn-primary"> <input type="radio"
				name="options" id="option2" autocomplete="off"> <a href="#"
				id="newspeed_popularBtn">인기순</a>
			</label>
		</div>
	</div>

	<!-- 뉴스피드 내용 -->

	<div id="newspeed_popularResult">
		<c:forEach var="post" items="${newsfeedPopularArray}">
			<div id="newspeed_post">
				<table id="newspeed_post_table">
					<tr>
						<td id="newspeed_profileImg_width"><c:if
								test="${post.followUserImage !=null}">
								<input type="image" id="newspeed_profileImg"
									src="${post.followUserImage}" />
							</c:if> <c:if test="${post.followUserImage eq null}">
								<input type="image" id="newspeed_profileImg"
									src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png" />
							</c:if></td>
						<!-- <td>김정윤님이 리코타치즈샐러드 게시물을 좋아합니다.</td> -->
						<td>${post.followUserName}님이${post.recipeName}레시피를좋아합니다.</td>
					</tr>
					<tr>
						<td colspan="2"><input type="image" id="newspeed_post_food"
							src="${post.completeImage}" /></td>
					</tr>
				</table>
				<table id="newspeed_post_bottom_outer">
					<tr>
						<td id="newspeed_post_bottom_hits_td">
							<table id="newspeed_post_bottom_hits">
								<tr>
									<td><input type="image"
										src="img/profile_img/Visible-50.png" width="30px" /></td>
									<td>조회수</td>
									<td>${post.postHits}</td>
								</tr>
							</table>
						</td>
						<td id="newspeed_post_bottom_like_td">
							<table id="newspeed_post_bottom_like">
								<tr>
									<td><input type="image" src="img/main_img/good_BtnU.png"
										width="30px" /></td>
									<td>${post.likeCount}</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</div>
	<div id="newspeed_latestResult">
		<c:forEach var="post" items="${newsfeedLatestArray}">
			<div id="newspeed_post">
				<table id="newspeed_post_table">
					<tr>
						<td id="newspeed_profileImg_width"><c:if
								test="${post.followUserImage !=null}">
								<input type="image" id="newspeed_profileImg"
									src="${post.followUserImage}" />
							</c:if> <c:if test="${post.followUserImage eq null}">
								<input type="image" id="newspeed_profileImg"
									src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png" />
							</c:if></td>
						<td>${post.userName}님이${post.recipeName}레시피를추가했습니다.</td>
					</tr>
					<tr>
						<td colspan="2"><input type="image" id="newspeed_post_food"
							src="${post.completeImage}" /></td>
					</tr>
				</table>
				<table id="newspeed_post_bottom_outer">
					<tr>
						<td id="newspeed_post_bottom_hits_td">
							<table id="newspeed_post_bottom_hits">
								<tr>
									<td><input type="image"
										src="img/profile_img/Visible-50.png" width="30px" /></td>
									<td>조회수</td>
									<td>${post.postHits}</td>
								</tr>
							</table>
						</td>
						<td id="newspeed_post_bottom_like_td">
							<table id="newspeed_post_bottom_like">
								<tr>
									<td><input type="image" src="img/main_img/good_BtnU.png"
										width="30px" /></td>
									<td>${post.likeCount}</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</div>

</body>
</html>