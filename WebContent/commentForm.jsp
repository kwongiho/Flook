<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <form action="" method="POST" id="${requestScope.comment.commentCode }" class="commentFormClass"> --%>
<div id="comment_writer_container">
	<div class="comment-main-level"
		id="${requestScope.comment.commentCode }">
		<!-- Avatar -->

		<div class="comment-avatar">
			<img src="${sessionScope.userImage }" alt="">
		</div>
		<div class="comment-box">
			<div class="comment-head ">
				<!-- by-author  -->
				<a href="http://creaticode.com/blog" id="writer_name">${sessionScope.userName }</a>
				<p id="writen_date">2015-08-08${requestScope.comment.commentDate }</p>
				<!--작가  -->
				<p class="comment-content">테스트 댓글${requestScope.comment.commentContents }</p>
				<div>
					<a type="button" id="comment_modify_button"
						href="javascript:modifyButton('${requestScope.comment.commentCode }')">수정</a>
					<a type="button" id="comment_delete_button"
						href="javascript:deleteButton('${requestScope.comment.commentCode }')">삭제</a>

				</div>
			</div>
		</div>
	</div>
</div>
<!-- </form> -->