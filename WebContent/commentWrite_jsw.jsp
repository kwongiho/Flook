<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/commentWrite_css/commentWrite_jsw.css" rel="stylesheet">
<!--  <script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.status').click(function() { $('.arrow').css("left", 0);});
			$('.photos').click(function() { $('.arrow').css("left", 146);});
		});
	</script>
	-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#comment_write_Btn").click(function() {

			$.ajax({
				url : $("#comment_write_form").attr("action"),
				type : 'POST',
				data : $("#comment_write_form").serialize(),
				success : function(data) {

					$("#comments-listed").append(data);
				}
			});

		});

	});
	function modifyButton(code) {

		$.ajax({
			url : 'modifyComment',
			type : 'POST',
			data : {
				"modifyCode" : code,
			},
			success : function() {
				alert("수정되었습니다.");
			}
		});
	}
	function deleteButton(code) {
		if (confirm("정말 삭제하시겠습니까?") == true) {
			$("#" + code).hide();
			$.ajax({
				url : 'deleteComment',
				type : 'POST',
				data : {
					"deleteCode" : code
				},
				seccess : function() {
					alert("삭제되었습니다.");
				}
			})
		}
	}
</script>
<link href="css/commentList_css/myCommnetList.css" rel="stylesheet">
<!-- commentList꺼, -->
<style type="text/css">
#comment_id {
	width: 80px;
	height: 80px;
}
</style>
</head>
<body>
	<!--  -->
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<hr>
			<form action="commentSvlt.do" method="POST" role="form"
				enctype="multipart/form-data" class="facebook-share-box"
				id="comment_write_form">

				<div class="share">
					<div class="arrow"></div>
					<div class="panel panel-default" id="comment_Write_Box">
						<!-- <div class="panel-heading" id="comment_Write_title"><i class="fa fa-file"></i> 댓글작성하기</div> -->
						<div class="comment-avatar" id="comment_Writer_image">
							<img
								src="http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg"
								alt="" id="comment_id">
						</div>
						<div class="panel-body" id="comment_Write_textArea">
							<div class="" id="comment_textarea">
								<textarea name="message" cols="30" rows="10" id="status_message"
									class="form-control message"
									style="height: 65px; overflow: hidden;"
									placeholder="당신의 생각을 적어주세요"></textarea>
							</div>
						</div>
						<div class="panel-footer" id="comment_Write_submit">

							<div class="row">
								<div class="col-md-5">
									<div class="form-group" id="comment_submit_div">

										<input type="button" name="button" value="작성하기"
											class="btn btn-primary" id="comment_write_Btn">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="commentListBody">
		<!-- Contenedor Principal -->
		<div class="comments-container">
			<ul id="comments-listed" class="comments-list">
				<!-- 댓글 달리는곳 -->
			</ul>
		</div>
	</div>
</body>
</html>
