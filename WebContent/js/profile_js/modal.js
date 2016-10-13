$(document).ready(function() {

	// 프로필 수정
	$("#profile_modifyBtn").click(function() {
		$("#profileModifyModal").modal({
			backgroundColor : '#000000',
			opacity : 0.8,
			backdrop : 'static',
			keyboard : false
		});
	});
	$("#scrapDeleteBtn").click(function() {
		$("#scrapDeleteModal").modal({
			backgroundColor : '#000000',
			opacity : 0.8,
			backdrop : 'static',
			keyboard : false
		});
	});
});
function myRecipeDelete(code) {

	$("#recipeDeleteModal").modal({
		backgroundColor : '#000000',
		opacity : 0.8,
		backdrop : 'static',
		keyboard : false
	});
	$("#myWriteRecipe_modal_yesBtn")
			.click(
					$(function() {
						// 삭제버튼 클릭시 삭제하러 ㄱㄱ
						/*----씨발 괄호지운새끼 나와----*/
						asyncSend();
						function getXR() {
							var req;
							try {
								req = new XMLHttpRequest();
							} catch (e) {
								try {
									req = new ActionXObject("Msxml2.XMLHTTP");
								} catch (q) {
									req = new ActionObject("Microsoft.XMLHTTP");
								}
							}
							return req;
						}
						function asyncSend() {
							/*$("#recipeDeleteModal").hide();
							return;*/
							
							var req = getXR();
							req.onreadystatechange = function() {
								if (req.readyState == 4) {
									if (req.status == 200) {
										
								
									} else {
										alert("서버 에러발생");
									}
								}
							};
							req.open("post", "deleteMyRecipe", true);
							req
									.setRequestHeader("content-type",
											"application/x-www-form-urlencoded; charset=UTF-8");
							req.send("recipeCode=" + code);
							// 싶을때
							// getParameter("email")
							// 하믄됨
						}
						/*--------*/
					}));
	$("#myWriteRecipe_modal_noBtn").click(function() {
		$("#recipeDeleteModal").modal("hide");
	});
}