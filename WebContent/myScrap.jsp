<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="profile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My 스크랩</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="assets/js/jquery-1.11.1.min.js"></script>
<!-- nav -->
<script src="js/profile_js/modal.js" type="text/javascript"
   charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="css/.css" />
<link rel="stylesheet" type="text/css"
   href="css/myScrap_css/style_common.css" />
<!-- 권기호 추가-사진 hover -->
<link rel="stylesheet" type="text/css" href="css/myScrap_css/style1.css" />
<!-- 권기호 추가-사진 hover -->
<!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> --><!-- 임시 지움. -->
<script src="DetailSeejsTemplete.js" type="text/javascript" charset="UTF-8"></script><!-- 상세보기 템플릿임. -->
<link rel="stylesheet" type="text/css" href="css/myWriteRecipe_css/myWriteRecipe.css"><!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="js/profile_js/modal.js" type="text/javascript" charset="UTF-8"></script><!-- 상세보기 모달창. -->
</head>
<body>
   <div id="profile_myScrap_container">
      <div id="profile_myScrap_content">
         <div id="profile_my_write_recipe_area">
            <c:forEach var="myScrap" items="${myScrapList}">
               <div class="view view-first" id="${myScrap.recipeCode}">
                  <img src="${myScrap.completeImage }" class="profile_myWrite_recipe" />
                  <div class="mask" style="height:211px;">
                     <a href="javascript:detailSee('${myScrap.recipeCode }')"><h2>${myScrap.recipeName }</h2></a>
                     <p>${myScrap.recipeDescription }<br/>좋아요 : ${myScrap.likeCount}　　조회수 : ${myScrap.postHits}</p>
                     <a type="button"  class="info"
                        href="javascript:deleteScrap('${myScrap.recipeCode}')" >스크랩
                        삭제</a>
                  </div>
               </div>
            </c:forEach>
         </div>
      </div>
   </div>
   <!-- delete -->
   <div class="modal fade" id="scrapDeleteModal" role="dialog">
      <div class="modal-dialog2">
         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" id="closeBtn" class="close"
                  data-dismiss="modal">&times;</button>
               <h4 class="modal-title">알림</h4>
            </div>
            <div class="modal-body" id="myWriteRecipe_body">
               <p>스크랩을 정말로 삭제 하시겠습니까?</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="" id="myScrap_modal_yesBtn"
                  data-dismiss="modal">예</button>
               <button type="button" class="" id="myScrap_modal_noBtn"
                  data-dismiss="modal">아니요</button>
            </div>
         </div>
      </div>
   </div>
   </div>
   <footer id="profile_footer"> </footer>
   <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="gg" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
  <div id="tempHereInsert"></div>
</body>
</html>