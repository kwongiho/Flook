<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="view view-first"
	style="width: 300px; height: 240px; margin: 15px">
	<img src="${todayRecipeRecommend.completeImage }" />
	<div class="mask">
		<form method="post" action="detail" id="detail"
			style="display: inline">
			<a type="button" style="text-decoration: none"
				href="javascript:detailSee('${todayRecipeRecommend.recipeCode }')">
				<h2>소불고기 만드는 법</h2>
			</a>
		</form>
		<p>좋아요 : ${mySimpleRecipe.likeCount}13747 조회수
			:${mySimpleRecipe.postHits}523452</p>
		<div id="score-callback" data-score="0" class="score-height"></div>
		<!-- 추가되는포크. -->
		<form>
			<a type="button" id="insertRcipeBtn" class="info"
				style="text-decoration: none"
				href="javascript:insertScrap('${todayRecipeRecommend.recipeCode }')">스크랩 추가</a>
		</form>
	</div>
</div>