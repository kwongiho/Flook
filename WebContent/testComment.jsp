<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <form action="" method="POST" id="${requestScope.comment.commentCode }" class="commentFormClass"> --%>
<!-- </form> -->
<div id="commentListBody">
	<!-- Contenedor Principal -->
	<div class="comments-container">
		<ul id="comments-listed" class="comments-list">
			<!-- 댓글 달리는곳 -->
			<div class="comment-main-level"
				id="${requestScope.comment.commentCode }">
				<!-- Avatar -->
				<div class="comment-avatar">
					<img src="${sessionScope.userImage }" alt="">
				</div>
				<div class="comment-box">
					<div class="comment-head ">
						<!-- by-author  -->
						<h6 class="comment-name">
							<a href="http://creaticode.com/blog">"${sessionScope.userName }"</a>
						</h6>
						<!--작가  -->
						<div class="comment-content">${requestScope.comment.commentContents }</div>
						<div>
							<a type="button" id="comment_modify_button"
								href="javascript:modifyButton('${requestScope.comment.commentCode }')">수정</a>
							<a type="button" id="comment_delete_button"
								href="javascript:deleteButton('${requestScope.comment.commentCode }')">삭제</a>

						</div>
					</div>
				</div>
			</div>
		</ul>
	</div>
</div>