<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="profile.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html id="myWriteRecipe_html">
<head>
<title>내가 작성한 레시피</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/profile_js/modal.js" type="text/javascript"
	charset="UTF-8"></script>
<link rel="stylesheet" type="text/css"
	href="css/myWriteRecipe_css/myWriteRecipe.css">

</head>
<body id="myWriteRecipe_body">

	<div id="myWriteRecipe_form" name="myWriteRecipe_form">
		<div id="myWriteRecipe_container">
			<div id="myWriteRecipe_content">
				<div id="myWriteRecipe_elements">
					<div class="header_jsw">
						<div class="main_jsw">
							<c:forEach var="mySimpleRecipe" items="${simpleMyRecipeViewList}">
								<div class="view view-first">
									<img src="${mySimpleRecipe.completeImage}" />
									<div class="mask">
										<form method="post" action="detail" id="detail" style="display:inline">
											<a type="button" id="myRecipeDetailViewBtn"
												href="javascript:myRecipeDetailView('${mySimpleRecipe.recipeCode}')">
												<h2>${mySimpleRecipe.recipeName}</h2>
											</a>
										</form>
										<p>좋아요 : ${mySimpleRecipe.likeCount} 조회수
											:${mySimpleRecipe.postHits}</p>
										<a href="modifyRecipe.jsp" class="info">레시피수정</a>
										<form method="post" action="deleteMyRecipe" id="myRecipe" style="display:inline">
											<a type="button" id="recipeDeleteBtn" class="info"
												href="javascript:myRecipeDelete('${mySimpleRecipe.recipeCode}')">레시피
												삭제</a>
										</form>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#myModal2" id="tempBtn">나도
			요리사 레시피 조회</button>
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Recipe Only See</h4>
					</div>
					<div class="modal-body" id="testUserIdTag">

						<jsp:include page="detailUserRecipe.jsp"></jsp:include> 
						<%-- <jsp:include page="commentList_jsw.jsp"></jsp:include>
						<jsp:include page="commentWrite_jsw.jsp"></jsp:include> --%>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal"
							id="myDetailRecipeViewCloseBtn">Close</button>
						<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="recipeDeleteModal" role="dialog">
			<div class="modal-dialog2">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" id="closeBtn" class="close"
							data-dismiss="modal">&times;</button>
						<h4 class="modal-title">알림</h4>
					</div>
					<div class="modal-body" id="myWriteRecipe_body">
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
	</div>
</body>
</html>