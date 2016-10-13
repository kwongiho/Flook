<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="profile.jsp"%>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/check_css/check.css">
  <link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src="js/profile_js/modal.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body>

<div class="container">
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <input type="button" id="recipeDeleteBtn" class="btn btn-info btn-lg" value="레시피 삭제">

  <!-- Modal -->
  <div class="modal fade" id="recipeDeleteModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" id="closeBtn"class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">알림</h4>
        </div>
        <div class="modal-body">
          <p>정말로 삭제 하시겠습니까?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default"  id="ok" data-dismiss="modal">예</button><button type="button" class="btn btn-default" id="no" data-dismiss="modal">아니요</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>
</html>
