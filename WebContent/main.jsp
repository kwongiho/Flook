<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitionamain_situation_bodyl//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>


<!-- 포크 -->
<script src="../Flook/js/search_js/jquery.raty.js"></script>
<script src="../Flook/js/search_js/labs.js" type="text/javascript"></script>
<!-- <script src="js/search_js/search.js" type="text/javascript"></script> -->

<!--  toast-->
<script src="js/main_js/js.js" type="text/javascript" charset="UTF-8"></script>

<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="DetailSeejsTemplete.js" type="text/javascript"
   charset="UTF-8"></script>
<!-- 상세보기 -->
<link rel="stylesheet" type="text/css" href="css/myWriteRecipe_css/myWriteRecipe.css">
<!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="../Flook/js/profile_js/modal.js" type="text/javascript"
   charset="UTF-8"></script>
<!-- 상세보기 -->

<title>FLOOK 나의 최고의 레시피</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$(".situationboxarea").click(function(){
		srr(document.getElementsByClassName("situationboxarea")[$(".situationboxarea").index(this)].innerHTML, $("#situationBefore") , $("#situationAfter"));
	});
	
	$(".kindboxarea").click(function(){
		krr(document.getElementsByClassName("kindboxarea")[$(".kindboxarea").index(this)].innerHTML, $("#kindBefore") , $("#kindAfter"));
	});
	$(".methodboxarea").click(function(){
		mrr(document.getElementsByClassName("methodboxarea")[$(".methodboxarea").index(this)].innerHTML, $("#methodBefore") , $("#methodAfter"));
	});
	$(".ingredientboxarea").click(function(){
		irr(document.getElementsByClassName("ingredientboxarea")[$(".ingredientboxarea").index(this)].innerHTML, $("#ingredientBefore") , $("#ingredientAfter"));
	});
	function srr(situation,before,after) {
		$.ajax({
			url:"recommend",
			type: "Post",
			data : { "type" : "situation" , "data" : situation },
			success : function(data) {
	            /* alert(data); */
	            $(after).append(data);
	            $(after).show();
	            $(before).hide();
	         }
		});
	};
	function krr(kind,before,after) {
		$.ajax({
			url:"recommend",
			type: "Post",
			data : { "type" : "kind" , "data":kind },
			success : function(data) {
	            $(after).append(data);
	            $(after).show();
	            $(before).hide();
	         }
		});
	}
	function irr(ingredient,before,after) {
		$.ajax({
			url:"recommend",
			type: "Post",
			data : { "type" : "ingredient" , "data":ingredient },
			success : function(data) {
	            $(after).append(data);
	            $(after).show();
	            $(before).hide();
	         }
		});
	}
	function mrr(method,before,after) {
		
		$.ajax({
			url:"recommend",
			type: "Post",
			data : { "type" : "method" , "data":method },
			success : function(data) {
	            $(after).append(data);
	            $(after).show();
	            $(before).hide();
	         }
		});
	}
	
});
</script>

<script type="text/javascript">
	$.fn.raty.defaults.path = 'img/search_img/images';
	$(function() {
		$('#default').raty();
		$('#score-callback').raty({
			score : function() {
				return $(this).attr('data-score');

			}
		});
		$('#move-function-run').on(
				'click',
				function() {

					altt();
					$('#functions').raty('move',
							$('#' + this.id.replace('-run', '')).val());

				});
	});

	function altt() {
		alert("레시피 취향이 추가되었습니다.");
	}
</script>
<script type="text/javascript">
	//오늘의 추천메뉴 가져오는 Servlet
	$.ajax({
		url : "todayRecipeRecommend",
		type : "POST",
		success : function(data) {
			$("#insertTodayRecipe").val(data);
		}

	});
</script>
<body>
   <jsp:include page="navigation.jsp" flush="false" />
   
   <div id="wrapper">
      <div id="mainCarousel" class="carousel slide" data-ride="carousel">
         <div class="carousel-inner" role="listbox">
            <div class="item active">
               <img src="img/main_img/banner/test3.jpg" alt="..."
                  class="main_banner">
               <div class="carousel-caption"></div>
            </div>
         </div>
      </div>
   </div><!-- wrapper end. -->
   
   <div id="main_body_container">
      <div class="main_body_content" id="main_body_content1">
         <div id="main_toDay_header">
            <div></div>
         </div>
         <div id="main_body_body">
            <div class="header_psh">
               <div class="main_psh">
               
                  <div id="insertTodayRecipe"></div>
				
                  

                  <%-- </c:forEach> --%>
               </div>
            </div>
         </div>
      </div>
      <div class="main_body_content" id="main_body_content2">
         <div id="main_situation_body">
            <div></div>
         </div>
         
         <style>
#situationAfter,#moodAfter {
   display: none;
}
</style>
         <div id="main_body_body">
            <div class="header_psh">
               <div class="main_psh">
                  <div id="situationBefore">
							<div class="situationboxarea" >일상</div>
							<div class="situationboxarea" >손님접대</div>
							<div class="situationboxarea" >이유식</div>
							<div class="situationboxarea" >나들이</div>
							<div class="situationboxarea" >간식</div>
							<div class="situationboxarea" >초스피드</div>
							<div class="situationboxarea" >술안주</div>
							<div class="situationboxarea" >푸드스타일링</div>
							<div class="situationboxarea" >다이어트</div>
							<div class="situationboxarea" >영양식</div>
							<div class="situationboxarea" >명절</div>
							<div class="situationboxarea" >야식</div>
							<div class="situationboxarea" >해장</div>
							<div class="situationboxarea" >아침식사</div>
							<div class="situationboxarea" >채식</div>
							<div class="situationboxarea" >데이트</div>
							<div class="situationboxarea" >도시락</div>
							<div class="situationboxarea" >기타</div>
                     <!-- hideData시작. -->
                     <!--  -->
                     <!--  -->
                     <!--  -->
                     <!-- hide끝 -->
                  </div>
                  <div id="situationAfter"></div>

               </div>
            </div>
         </div>
      </div>
      <!-- 여기부터 한 블럭이 시작된다.  11/11 -->
      <div class="main_body_content" id="main_body_content3">
         <div id="main_kind_body">
            <div></div>
         </div>
         
         <div id="main_body_body">
            <div class="header_psh">
               <div class="main_psh">
                  <div id="kindBefore">
                     <div class="kindboxarea" >밑반찬</div>
                     <div class="kindboxarea" >메인반찬</div>
                     <div class="kindboxarea" >국/탕</div>
                     <div class="kindboxarea" >찌개</div>
                     <div class="kindboxarea" >디저트</div>
                     <div class="kindboxarea" >면/만두</div>
                     <div class="kindboxarea" >밥/죽/떡</div>
                     <div class="kindboxarea" >전</div>
                     <div class="kindboxarea" >김치젓갈/장류</div>
                     <div class="kindboxarea" >양념/소스/잼</div>
                     <div class="kindboxarea" >양식</div>
                     <div class="kindboxarea" >샐러드</div>
                     <div class="kindboxarea" >스프</div>
                     <div class="kindboxarea" >빵</div>
                     <div class="kindboxarea" >과자</div>
                     <div class="kindboxarea" >차/음료/술</div>
                     <div class="kindboxarea" >기타</div>
                     
                  </div>
                  <div id="kindAfter"></div>
               </div>
            </div>
         </div>
      </div>
      <!-- 한 블럭 종료  -->
     <!-- 한 블럭 시작한다 -->
     <div class="main_body_content" id="main_body_content4">
         <div id="main_ingredient_body">
            <div></div>
         </div>
         

         <div id="main_body_body">
            <div class="header_psh">
               <div class="main_psh">
                  <div id="ingredientBefore">
                  	<div class="ingredientboxarea" >소고기</div>
                    <div class="ingredientboxarea" >돼지고기</div>
                    <div class="ingredientboxarea" >닭고기</div>
                    <div class="ingredientboxarea" >육류</div>
                    <div class="ingredientboxarea" >채소류</div>
                    <div class="ingredientboxarea" >해물류</div>
                    <div class="ingredientboxarea" >달걀/유제품</div>
                    <div class="ingredientboxarea" >가공식품류</div>
                    <div class="ingredientboxarea" >쌀</div>
                    <div class="ingredientboxarea" >밀가루</div>
                    <div class="ingredientboxarea" >건어물류</div>
                    <div class="ingredientboxarea" >버섯류</div>
                    <div class="ingredientboxarea" >과일류</div>
                    <div class="ingredientboxarea" >콩/견과류</div>
                    <div class="ingredientboxarea" >곡류</div>
                    <div class="ingredientboxarea" >기타</div>
                    
                  </div>
                  <div id="ingredientAfter"></div>
               </div>
            </div>
         </div>
      </div>
      <!-- 한 블럭 종료료 -->
      <!-- 한 블럭 시작한다 -->
     <div class="main_body_content" id="main_body_content5">
         <div id="main_method_body">
            <div></div>
         </div>
         

         <div id="main_body_body">
            <div class="header_psh">
               <div class="main_psh">
                  <div id="methodBefore">
                  	<div class="methodboxarea" >끓이기</div>
                  	<div class="methodboxarea" >볶음</div>
                  	<div class="methodboxarea" >부침</div>
                  	<div class="methodboxarea" >찜</div>
                  	<div class="methodboxarea" >튀김</div>
                  	<div class="methodboxarea" >절이기</div>
                  	<div class="methodboxarea" >구이</div>
                  	<div class="methodboxarea" >조림</div>
                  	<div class="methodboxarea" >회</div>
                  	<div class="methodboxarea" >삶기</div>
                  	<div class="methodboxarea" >데치기</div>
                  	<div class="methodboxarea" >무침</div>
                  	<div class="methodboxarea" >비빔</div>
                  	<div class="methodboxarea" >굽기</div>
                  	<div class="methodboxarea" >기타</div>
                  	
                  	
                  </div>
                  <div id="methodAfter"></div>
               </div>
            </div>
         </div>
      </div>
      <!-- 한 블럭 종료료 -->
      
   </div>
   <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="gg" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
   <div id="tempHereInsert"></div>
</body>
</html>
<%-- for(int i=0;i<6;i++){-- 
                  <div class="view view-first"
                     style="width: 300px; height: 240px; margin: 15px">
                     <img
                        src="\Flook\userImage\d9eb3f5f754c795377295f53cf461f711.jpg" />
                     <div class="mask">
                        <form method="post" action="detail" id="detail"
                           style="display: inline">
                           <a type="button" style="text-decoration: none"
                              href="javascript:detailSee('0101UR1439346254167')">
                              <h2>떡볶이 양념 만드는법</h2>
                           </a>
                        </form>
                        <p>좋아요 : ${mySimpleRecipe.likeCount}13747 조회수
                           :${mySimpleRecipe.postHits}523452</p>
                           <div id="score-callback" data-score="0" class="score-height"></div><!-- 추가되는포크. -->
                        <form>
                           <a type="button" id="insertRcipeBtn" class="info" style="text-decoration: none"
                              href="javascript:insertScrap('0101UR1439346254167')">스크랩  추가</a>
                        </form>
                     </div>
                  </div>
                  <%}--%>