<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="profile.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html id="myWriteRecipe_html">
<head>
<title>내가 작성한 레시피</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="DetailSeejsTemplete.js" type="text/javascript"
	charset="UTF-8"></script>
<!-- 상세보기 -->
<link rel="stylesheet" type="text/css"
	href="css/myWriteRecipe_css/myWriteRecipe.css">
<!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="js/profile_js/modal.js" type="text/javascript"
	charset="UTF-8"></script>
<!-- 상세보기 -->
<script type="text/javascript">
	$(document).ready(function() {

		$("#recipeModifyBtn").click(function() {
			$("#modify").submit();

		});
		$("#myWriteRecipe_elements").hover(function(){
			window.scrollTo(300, 500);
		});
	});
</script>
</head>
<body id="myWriteRecipe_body">
	<div id="myWriteRecipe_form" name="myWriteRecipe_form">
		<div id="myWriteRecipe_container">
			<div id="myWriteRecipe_content">
				<div id="myWriteRecipe_elements">
					<div class="header_jsw">
						<div class="main_jsw">
							<c:forEach var="mySimpleRecipe" items="${simpleMyRecipeViewList}">
								<div class="testClassName" id="${mySimpleRecipe.recipeCode }">
									<div class="view view-first" id="test1">
										<img src="${mySimpleRecipe.completeImage}" />
										<div class="mask" style="height: 242px;">
											<form method="post" action="detail" id="detail"
												style="display: inline">
												<a type="button"
													href="javascript:detailSee('${mySimpleRecipe.recipeCode}')">
													<h2>${mySimpleRecipe.recipeName}</h2>
												</a>
											</form>
											<p>좋아요 : ${mySimpleRecipe.likeCount} 조회수
												:${mySimpleRecipe.postHits}</p>
											<form action="modifyRecipe" style="display: inline"
												id="modify">
												<button id="recipeModifyBtn">레시피 수정</button>
												<input type="hidden" value='${mySimpleRecipe.recipeCode}'
													name="recipeCode" />
											</form>

											<!-- <a href="modifyRecipe.jsp" class="info">레시피수정</a> -->
											<form method="post" action="deleteMyRecipe" id="myRecipe"
												style="display: inline">
												<a type="button" id="recipeDeleteBtn" class="info"
													href="javascript:myRecipeDelete('${mySimpleRecipe.recipeCode}')">레시피
													삭제</a>
											</form>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="recipeDeleteModal" role="dialog">
		<div class="modal-dialog2">
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
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		data-target="#detailRecipeModal" id="gg" style="display: none;">이거
		봤니?이게 보여?보이면 안되는데;;</button>
	<div id="tempHereInsert"></div>
</body>
</html>