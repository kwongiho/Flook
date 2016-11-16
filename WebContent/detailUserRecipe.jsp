<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>레시피 상세조회</title>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" type="text/css"
	href="css/myWriteRecipe_css/myWriteRecipe.css"> -->


<div class="container">

	<!-- Trigger the modal with a button -->
</div>
<!-- Modal -->
<div class="modal fade" id="detailRecipeModal" role="dialog">
	<div id="detailRecipeBackground">
		<div class="modal-dialog2" id="detailRecipeModalContent">
			<div class="modal-content" id="detailRecipe_modal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color:white">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body" id="testUserIdTag">
					<div id="recipe_see">
						<div id="recipe_see_section1">
						<span>원본링크- <a href="${recipeUrl }" >${recipeUrl }</a></span>
							<div id="recipe_description_image">
								<c:if test="${sessionScope.userImage !=null}">
									<img class="thumbnail" id="recipe_userImg" src="${sessionScope.userImage}"
										width="70" height="70"
										onerror="utils.loadDefaultImg(this, 'thumb');">
								</c:if>
								<c:if test="${sessionScope.userImage eq null }">
									<img class="thumbnail" id="recipe_userImg" src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png"
										width="70" height="70"
										onerror="utils.loadDefaultImg(this, 'thumb');">
								</c:if>
							</div>
							<div id="recipe_description_see">
								<h4 id="recipe_description_title_see">사용자 한마디</h4>
								<label id="recipe_description_textarea_see" id="userDescription" style="height:100%">${userUIBean.recipeDescription }</label>
							</div>
							<div id="recipe_event">
								<%-- <input type="image" src="img/main_img/heart_empty.png" class="recipe_see_button" id="heart_Btn" value="${post.postCode }">
								<input type="image" src="img/main_img/unBookmark.png" class="recipe_see_button" id="bookmarkBtn" value="${post.postCode }"> --%>
								<input type="image" src="img/main_img/good_BtnU.png" class="recipe_see_button" id="good_Btn" value="${post.postCode }">
                        		<input type="image" src="img/main_img/BookmarkU.png" class="recipe_see_button" id="bookmarkBtn" value="${post.postCode }">
							</div>
							<div id="recipe_name">
								<h1 id="recipe_name_see">${userUIBean.recipeName }</h1>
								<!-- <input type="button" value="수정" id="recipe_modify_see">
								<input type="button" value="삭제" id="recipe_delete_see"> -->
							</div>

							<div id="recipe_infomation_description_see">
								<p>
									조리시간 :
									<c:choose>
										<c:when test="${userUIBean.cookingTime eq '120' }">2시간 이내</c:when>
										<c:when test="${userUIBean.cookingTime eq '120over' }">2시간 이상</c:when>
										<c:otherwise>${userUIBean.cookingTime}분 이내</c:otherwise>
									</c:choose>
								</p>
								<p>난이도 : 쉬움</p>
							</div>
							<div id="recipe_use_ingredient">
								<form method="get" action="CartServlet" id="ingredient_list" name="ingredient_list_name">
									<h4 id="recipe_name_see">사용된 재료</h4>
									<p style="display: inline">
										<c:choose>
											<c:when test="${userUIBean.personNumber<5 }">${userUIBean.personNumber }인분</c:when>
											<c:otherwise>5인분 이상</c:otherwise>
										</c:choose>
									</p>
									<!-- <input type="button" value="계량법"> -->
									<div id="recipe_main_ingredient">
										<h5>주재료</h5>
										<c:forEach var="mainIngredient"
											items="${userUIBean.mainIngredientList }">
											<p>
												<p> 
												${mainIngredient.ingredientName }
												${mainIngredient.ingredientAmount }${mainIngredient.ingredientUnit }<c:if test="${sessionScope.userName != null }"><a type="button" href="javascript:aboutCart('${mainIngredient.ingredientCode }')"> 추가</a></c:if>
												</p>
												
											</p>

										</c:forEach>
									</div>
									<div id="recipe_sub_ingredient">
										<h5>부재료</h5>
										<c:forEach var="subIngredient"
											items="${userUIBean.subIngredientList }">
											<p>
												<p>${subIngredient.ingredientName }
												${subIngredient.ingredientAmount }${subIngredient.ingredientUnit }<c:if test="${sessionScope.userName != null }"><a type="button" href="javascript:aboutCart('${subIngredient.ingredientCode }')"> 추가</a></c:if>
												</p>
											</p>

										</c:forEach>
									</div>
									<script type="text/javascript">
											function aboutCart(ingredientCode){
												$.ajax({
													url:$("#ingredient_list").attr("action"),
													type:'POST',
													data:{"cartKindOf" : "addCart" , "ingredientCode" :ingredientCode},
													success:function(data) {
														alert("장바구니에 추가되었습니다.");
													}
												});
											}	  
									</script>
									<!-- <input type="button" value="장바구니에 추가"
										id="recipe_ingredient_add_cart"> -->
								</form>

							</div>
						</div>
						<div id="recipe_see_section2">
							<div id="recipe_complete"
								style="width: 300px; height: 300px;margin: 0 auto;">
								<img src='${requestScope.userUIBean.completeImage}'
									id="recipe_main_img" />
							</div>

							<div id="recipe_categori_see">
								<h3>카테고리 정보</h3>
								<div id="recipe_category_area">
								<span id="recipe_nation_see" class="recipe_categori">나라별:</span><span class="recipe_categoryInfo">${userUIBean.countryCategory } </span>
								<span id="recipe_life_see" class="recipe_categori">재료별:</span><span class="recipe_categoryInfo">${userUIBean.ingredientCategory } </span>
								<span id="recipe_kindof_see" class="recipe_categori">분류별:</span><span class="recipe_categoryInfo">${userUIBean.kindCategory } </span>
								<span id="recipe_meet_see" class="recipe_categori">상황별:</span><span class="recipe_categoryInfo">${userUIBean.situationCategory } </span>
								<span class="recipe_categori">방법별 :</span><span class="recipe_categoryInfo">${userUIBean.methodCategory } </span>
								</div>
							</div>
							<div id="recipe_cooking_course">
								<!-- jstl나올자리 -->
								<h3>레시피</h3>
								<c:forEach var="cooking" items="${userUIBean.cookingList}">
									<div class="block">
										<img src='${cooking.cookingImage}'
											class="recipe_cooking_course_img" style="width:100%">
										<label class="recipe_cooking_course_infomation" id="cookingDescription" disabled>${cooking.cookingDescription }</label>
									</div>
								</c:forEach>
								<div>
									<!-- 댓글 나오는 곳 -->
								<%-- 	<jsp:include page="commentWrite_jsw.jsp"></jsp:include>
									<jsp:include page="commentForm.jsp"></jsp:include> --%>
									<c:forEach var="comment" items="${requestScope.commentList }">
										<div id="comment_writer_container">
											<div class="comment-main-level" id="${comment.commentCode }">
												<!-- Avatar -->
												<div class="comment-avatar">
													<img src="${sessionScope.userImage }" alt="">
												</div>
												<div class="comment-box">
													<div class="comment-head ">
														<!-- by-author  -->
														<a href="http://creaticode.com/blog" id="writer_name">${sessionScope.userName }</a>
														<p id="writen_date">${comment.commentDate }</p>
														<!--작가  -->
														<p class="comment-content">${comment.commentContents }</p>
														<div>
														
															<%-- <a type="button" id="comment_modify_button"
																href="javascript:modifyButton('${requestScope.comment.commentCode }')">수정</a>
															<a type="button" id="comment_delete_button"
																href="javascript:deleteButton('${requestScope.comment.commentCode }')">삭제</a> --%>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<button type="button" data-dismiss="modal" id="myDetailRecipeViewCloseBtn">확인</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer" id="recipe_see_section3">
					<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
				</div>
			</div>
		</div>
	</div>
</div>