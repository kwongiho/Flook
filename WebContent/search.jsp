<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>검색</title>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<!-- 상세보기 템플릿 -->
<script src="DetailSeejsTemplete.js" type="text/javascript"
   charset="UTF-8"></script>
<link rel="stylesheet" type="text/css"
   href="css/myWriteRecipe_css/myWriteRecipe.css">
<!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="js/profile_js/modal.js" type="text/javascript"
   charset="UTF-8"></script>
<!--  -->



<script
   src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.7.0/underscore-min.js"></script>
<!-- <link rel="stylesheet" type="text/css"
   href="css/myWriteRecipe_css/myWriteRecipe.css"> -->
<!-- 잠깐 지움. -->



<!--  -->

<script src="js/search_js/jquery.js"></script>
<script src="js/search_js/jquery.raty.js"></script>
<!-- <script src="js/search_js/jquery.js"></script> -->
<script src="js/search_js/labs.js" type="text/javascript"></script>
<script src="js/search_js/search.js" type="text/javascript"></script><!-- 발표를위해 잠시 비활성화. -->
<!-- <script src="js/search_js/custom.js"></script> -->
<!-- 사이드바 토글 -->
<!--  -->
<!--  -->
<!--  -->
<script
   src="css/main_css/assets/js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
<script
   src="css/main_css/assets/js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<script src="css/main_css/assets/js/waypoints.min.js"></script>
<!--  -->
<!--  -->
<link rel="stylesheet" href="css/search_css/labs.css" media="screen" type="text/css">
<!-- 포크 모이게해줌-->
<link rel="stylesheet" href="css/search_css/style_common.css">

<link rel="stylesheet" href="css/search_css/style1.css">
<link rel="stylesheet" href="css/search_css/main.css">
<link rel="author" href="https://plus.google.com/+Scoopthemes">
<link rel="publisher" href="https://plus.google.com/+Scoopthemes">
<link rel="stylesheet" href="css/main_css/assets/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"> -->
<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- font Awesome CSS -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.search_result_list {
   display: inline;
}
</style>
</head>
<body id="search_body">
   <%-- <jsp:include page="flookNav.jsp" flush="false"/> --%>
   <%-- <jsp:include page="flookNav.jsp"></jsp:include> --%>
   <div id="wrapper">

      <aside id="sideBar">
      <ul class="main-nav">
         <!-- Your Logo Or Site Name -->
         <li class="nav-brand"><a href="main.jsp"><img
               src="img/main_img/logo9.png" alt="" id="search_logo" ></a>
         </li>
         <!-- Search -->
         <li class="main-search">
            <form action="search" method="post" id="search_search_form">
               <input type="text" class="form-control search-input"
                  placeholder="Search here..." id="search_search"
                  name="search_input_keyword"> <i class="fa fa-search"></i>
               <script type="text/javascript">
                  $('#search_search').keypress(function(event) {
                     if (event.which == 13) {
                        $("#search_search_form").submit();
                     }
                  });
               </script>

            </form>

         </li>
         <li><a href="#" id="allSee">- 전체보기</a></li>
         <li><a href="#" id="recipeName">- 레시피명</a></li>
         <li><a href="#" id="userName">- 사용자명</a></li>
         <li><a href="#" id="hashTag">- 해시태그</a></li>
      </ul>
      </aside>
      <script type="text/javascript">
         $(document).ready(function() {

            $("#allSee").click(function() {
               $(".search_result_list").show();
            });
            $("#recipeName").click(function() {
               $(".search_result_list").hide();
               $("#search_one_recipeName").show();
               $("#search_three_userRecipeName").show();
            });
            $("#userName").click(function() {
               $(".search_result_list").hide();
               $("#search_five_userList").show();
            });
            $("#hashTag").click(function() {
               $(".search_result_list").hide();
               $("#search_two_recipeHashTag").show();
               $("#search_four_userRecipeHashTag").show();
            });
         });
      </script>


      <div id="search_one_recipeName" class="search_result_list">
         <c:forEach var="searchData" items="${simpleRecipeByName }">
            <div class="view view-first">
               <img src="${searchData.completeImage }" class="search_result_img" />
               <div class="mask">
                  <a type="button"
                     href="javascript:detailSee('${searchData.recipeCode}')"><h2>${searchData.recipeName }</h2></a>
                  <p>${searchData.recipeDescription }</p>
                  <!-- <div id="score-callback" data-score="0" class="score-height"></div> -->
                  <jsp:include page="fork.jsp"></jsp:include>
               </div>
            </div>
         </c:forEach>
      </div>
      <hr>
     <%--  <div id="search_two_recipeHashTag" class="search_result_list">
         <c:forEach var="searchData" items="${simpleRecipeByHashTag }">
            <div class="view view-first">
               <img src="${searchData.completeImage }" class="search_result_img" />
               <div class="mask">
                  <a type="button"
                     href="javascript:detailSee('${searchData.recipeCode}')"><h2>${searchData.recipeName }</h2></a>
                  <p>${searchData.recipeDescription }</p>
                  <jsp:include page="fork.jsp"></jsp:include>
               </div>
            </div>
         </c:forEach>
      </div> --%>

      <hr>
      <div id="search_three_userRecipeName" class="search_result_list">
         <c:forEach var="searchData" items="${simpleUserRecipeByName }">
            <div class="view view-first">
               <img src="${searchData.completeImage }" class="search_result_img" />
               <div class="mask">
                  <a type="button"
                     href="javascript:detailSee('${searchData.recipeCode}')"><h2>${searchData.recipeName }</h2></a>
                  <p>-${searchData.recipeDescription }</p>
                  <div id="score-callback" data-score="0" class="score-height"></div>
               </div>
            </div>
         </c:forEach>
      </div>
      <%-- <div id="search_four_userRecipeHashTag" class="search_result_list">
         <c:forEach var="searchData" items="${simpleUserRecipeByHashTag }">
            <div class="view view-first">
               <img src="${searchData.completeImage }" class="search_result_img" />
               <div class="mask" style="background-color: rgba(130,129,129, 0.7);">
                  <a type="button"
                     href="javascript:detailSee('${searchData.recipeCode}')"><h2>${searchData.recipeName }</h2></a>
                  <p>${searchData.recipeDescription }</p>
                  <jsp:include page="fork.jsp"></jsp:include>
               </div>
            </div>
         </c:forEach>
      </div> --%>
      <div id="search_five_userList" class="search_result_list">
         <c:forEach var="searchData" items="${UserList }">
            <a href="checkProfile?userEmail=${searchData.userEmail}">
               <div class="view view-first" style="border-radius:50%;">
               <c:if test="${searchData.userImage != null}">
                  <img src="${searchData.userImage }" class="search_result_img" style="border-radius:50%;"/>
                  </c:if>
                  <c:if test="${searchData.userImage eq null }">
                  <img src="http://www.blackmores.com.au/~/media/bklau/author/profiledefault.png" class="search_result_img"style="border-radius:50%;"/>
                  </c:if>
                  <div class="mask" style="border-radius:50%; background-color:rgba(0,0,0,0.7);">
                     <h2>${searchData.userName }</h2>
                     <p>${searchData.userEmail }</p>
                  </div>
               </div>
            </a>
         </c:forEach>
      </div>

   </div>
   <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="gg" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
   <div id="tempHereInsert"></div>

</body>
</html>