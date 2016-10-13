<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html id="flookRecipe_html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flook 레시피</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="DetailSeejsTemplete.js" type="text/javascript" charset="UTF-8"></script><!-- 레시피 상세보기 찍어내기 -->
<link rel="stylesheet" type="text/css" href="css/myWriteRecipe_css/myWriteRecipe.css"><!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="js/profile_js/modal.js" type="text/javascript" charset="UTF-8"></script><!-- 레시피 모달. -->
<link href="css/flookRecipe_css/flookRecipeCSS.css" rel="stylesheet"
   type="text/css"></link>
<link rel="stylesheet" href="css/flookRecipe_css/test3.css"
   type="text/css">
<link href="css/myRecipe_css/myRecipeCSS.css" rel="stylesheet"
   type="text/css"></link>
</head>

            <script>
               
               window.onload = function() {
               var method="끓이기";
               var situation="일상";
               var nation="한식";
               var ingredient="육류";
               var kindOf="밥/죽";
               $.ajax({
                  url : "TempServlet",
                  data : {"temp":"flook"},
                  type:"POST",
                  success:function(data) {
                     $("#flookRecipe_list").html(data);
                  }
                  
               })
                  //asyncSend();
                  
                  $(".flook_method").click(function(){
                     
                     method=document.getElementsByClassName("flook_method")[$(".flook_method").index(this)].textContent;
                     if(method==="전체")
                        method="%";
                     asyncSend();
                      
                  });
                  $(".flook_situation").click(function(){
                     situation=document.getElementsByClassName("flook_situation")[$(".flook_situation").index(this)].textContent;
                     if(situation==="전체")
                        situation="%";
                     asyncSend();
                  });
                  $(".flook_nation").click(function(){
                     nation=document.getElementsByClassName("flook_nation")[$(".flook_nation").index(this)].textContent;
                     if(nation==="전체")
                        nation="%";
                     asyncSend();
                  });
                  $(".flook_ingredient").click(function(){
                     ingredient=document.getElementsByClassName("flook_ingredient")[$(".flook_ingredient").index(this)].textContent;
                     if(ingredient==="전체")
                        ingredient="%";
                     asyncSend();
                  });
                  $(".flook_kindOf").click(function(){
                     kindOf=document.getElementsByClassName("flook_kindOf")[$(".flook_kindOf").index(this)].textContent;
                     if(kindOf==="전체")
                        kindOf="%";
                     asyncSend();
                  });
                  
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
                      /*alert(method+"/"+situation+"/"+nation+"/"+ingredient+"/"+kindOf); //클릭시 내용 확인하고 싶으면 주석 풀면 됩니다.*/

                     var req = getXR();
                     req.onreadystatechange = function() {
                        if (req.readyState == 4) {
                           if (req.status == 200) {
                              
                               var tempp=$("#flookRecipe_list");
                               $(tempp).html(req.responseText);
                               
                           } else {
                              alert("서버 에러발생");
                           }
                        }
                     };
                     req.open("post", "recipeFlook", true);/*true로 할 경우만 비동기통신*/
                     req.setRequestHeader("content-type","application/x-www-form-urlencoded; charset=UTF-8");
                     req.send("method="+method+"&"+"situation="+situation+"&nation="+nation+"&ingredient="+ingredient+"&kindOf="+kindOf); //*email 서블릿에서 받고 싶을때 getParameter("email") 하믄됨*/
                  }
               };
            </script>
            <jsp:include page="navigation.jsp" flush="false" />
<body class="flookRecipe_body" id="flookRecipe_body">
   <div id="flookRecipe_banner"></div>
   <div class="flookRecipe_container">
      <form class="flookRecipe_form">
         <div class="container" id="flookRecipe_inner_container">
            <div id="flookRecipe_title">
               <span id="flookRecipe_span_title">Flook 요리사</span>
            </div>
            <div class="flookRecipe_element" id="flookRecipe_category">
               <div class="flookRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="flookRecipe_li_categoryName1"><span
                        id="flookRecipe_span_categoryName1"
                        class="flookRecipe_span_value" id="">방법별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="flook_method">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_method">끓이기</a></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_method">볶음</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="flook_method">부침</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="flook_method">찜</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="flook_method">튀김</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="flook_method">절이기</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="flook_method">구이</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="flook_method">조림</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="flook_method">회</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="flook_method">삶기</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="flook_method">데치기</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_method">무침</a></li>
                     <li><a data-toggle="tab" href="#menu12" class="flook_method">비빔</a></li>
                     <li><a data-toggle="tab" href="#menu13" class="flook_method">굽기</a></li>
                     <li><a data-toggle="tab" href="#menu14" class="flook_method">기타</a></li>
                  </ul>
               </div>
               <div class="flookRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="flookRecipe_li_categoryName2"><span
                        id="flookRecipe_span_categoryName2"
                        class="flookRecipe_span_value" id="">상황별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="flook_situation">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_situation">일상</a></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_situation">손님접대</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="flook_situation">이유식</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="flook_situation">나들이</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="flook_situation">간식</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="flook_situation">초스피드</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="flook_situation">술안주</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="flook_situation">푸드 스타일링</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="flook_situation">다이어트쿡</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="flook_situation">영양식</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="flook_situation">명절</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">야식</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">해장</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">아침식사</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">채식</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">야식</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_situation">데이트</a></li>
                  </ul>
               </div>
               <div class="flookRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="flookRecipe_li_categoryName3"><span
                        id="flookRecipe_span_categoryName4"
                        class="flookRecipe_span_value" id="">나라별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="flook_nation">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_nation">한식</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="flook_nation">양식</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="flook_nation">일식</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="flook_nation">중식</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="flook_nation">기타</a></li>
                  </ul>
               </div>
               <div class="flookRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="flookRecipe_li_categoryName4"><span
                        id="flookRecipe_span_categoryName4"
                        class="flookRecipe_span_value" id="">재료별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="flook_ingredient">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_ingredient">육류</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="flook_ingredient">해물류/건어물류</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="flook_ingredient">곡류</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="flook_ingredient">콩/견과류</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="flook_ingredient">채소류</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="flook_ingredient">버섯류</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="flook_ingredient">빵류</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="flook_ingredient">가공식품류</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="flook_ingredient">면류/떡류</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="flook_ingredient">과일류</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_ingredient">달걀/유제품</a></li>
                     <li><a data-toggle="tab" href="#menu12" class="flook_ingredient">기타</a></li>
                  </ul>
               </div>
               <div class="flookRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="flookRecipe_li_categoryName5"><span
                        id="flookRecipe_span_categoryName6"
                        class="flookRecipe_span_value" id="">종류별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="flook_kindOf">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="flook_kindOf">밥/죽</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="flook_kindOf">면/만두</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="flook_kindOf">국/탕/찌개</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="flook_kindOf">김치/밑반찬</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="flook_kindOf">샐러드/스프</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="flook_kindOf">양념/소스/잼</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="flook_kindOf">차/음료</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="flook_kindOf">베이킹/떡</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="flook_kindOf">도시락/간식/디저트</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="flook_kindOf">튀김</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="flook_kindOf">기타</a></li>
                  </ul>
               </div>
            </div>
            <script>
               function goSearchRecipe(ca, val) {
                  $("#srRecipeFrm [name='" + ca + "']").val(val);
                  $("#srRecipeFrm").submit();
               }
            </script>

            <div class="flookRecipe_element" id="flookRecipe_all_list">
               <div class="tab-content" id="flookRecipe_list">
               
               </div>
            </div>
         </div>
      </form>
   </div>
      <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="qq" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
   <div id="tempHereInsert"></div>
</body>
</html>