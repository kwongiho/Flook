<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="targetProfile.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html id="myWriteRecipe_html">
<head>
<title>내가 작성한 레시피</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/profile_js/modal.js" type="text/javascript" charset="UTF-8"></script>


<script src="DetailSeejsTemplete.js" type="text/javascript" charset="UTF-8"></script>

<link rel="stylesheet" type="text/css" href="css/myWriteRecipe_css/myWriteRecipe.css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#recipeModifyBtn").click(function() {
			$("#modify").submit();

		});
	});
</script>
</head>
<body id="myWriteRecipe_body">
	<div id="myWriteRecipe_form" name="myWriteRecipe_form">
		<div id="myWriteRecipe_container">
			<div id="myWriteRecipe_content">
				<div id="myWriteRecipe_elements" style="width:1400px">
					<div class="header_jsw">
						<div class="main_jsw">
							<c:forEach var="mySimpleRecipe" items="${simpleMyRecipeViewList}">
								<div class="view view-first">
									<img src="${mySimpleRecipe.completeImage}" />
									<div class="mask" style="height:242px">
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
										</form>

										<!-- <a href="modifyRecipe.jsp" class="info">레시피수정</a> -->
										<form method="post" action="deleteMyRecipe" id="myRecipe"
											style="display: inline">
										</form>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- 	<script type="text/javascript">
		function detailSee(recipeCode) {

			$.ajax({
				url : "detail",
				type : 'POST',
				data : {
					"choiceRecipe" : recipeCode
				},
				success : function(data) {
					$("#tempHereInsert").html(data);
					/* alert("?"); */
					$("#gg").trigger("click");
				}
			});
		}
	</script> -->
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		data-target="#detailRecipeModal" id="gg" style="display: none;">이거
		봤니?이게 보여?보이면 안되는데;;</button>
	<div id="tempHereInsert"></div>
</body>
</html>