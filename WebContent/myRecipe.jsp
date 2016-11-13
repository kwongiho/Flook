<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="myRecipe_html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나만의 레시피</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script 
   src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   
   
<script src="DetailSeejsTemplete.js" type="text/javascript" charset="UTF-8"></script><!-- 레시피 상세보기 찍어내기 -->
<link rel="stylesheet" type="text/css" href="css/myWriteRecipe_css/myWriteRecipe.css"><!-- 얘가 겹칠 수 있음.ㄱ -->
<script src="js/profile_js/modal.js" type="text/javascript" charset="UTF-8"></script><!-- 레시피 모달. -->


<link href="css/myRecipe_css/myRecipeCSS.css" rel="stylesheet"
   type="text/css"></link>

<body class="myRecipe_body">
<jsp:include page="navigation.jsp" flush="false" />
   <script>
      var method = "볶음";
      var situation = "이유식";
      var nation = "한";
      var ingredient = "면류/떡류";
      var kindOf = "베이킹/떡";
      window.onload = function() {
         $.ajax({
            url : "TempServlet",
            type:"POST",
            data : {"temp":"myRecipe"},
            success:function(data) {
               $("#myRecipe_list").html(data);
            }
            
         })
         //asyncSend();

         $(".myRecipe_method").click(
               function() {
                  method = document.getElementsByClassName("myRecipe_method")[$(".myRecipe_method").index(this)].textContent;
                  asyncSend();
               });
         $(".myRecipe_situation").click(
                     function() {
                        situation = document.getElementsByClassName("myRecipe_situation")[$(".myRecipe_situation").index(this)].textContent;
                        asyncSend();
                     });
         $(".myRecipe_nation").click(
               function() {
                  nation = document
                        .getElementsByClassName("myRecipe_nation")[$(
                        ".myRecipe_nation").index(this)].textContent;

                  asyncSend();
               });
         $(".myRecipe_ingredient")
               .click(
                     function() {
                        ingredient = document.getElementsByClassName("myRecipe_ingredient")[$(".myRecipe_ingredient").index(this)].textContent;
                        asyncSend();
                     });
         $(".myRecipe_kindOf").click(
               function() {
                  kindOf = document.getElementsByClassName("myRecipe_kindOf")[$(".myRecipe_kindOf").index(this)].textContent;
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

            
            var req = getXR();
            req.onreadystatechange = function() {
               if (req.readyState == 4) {
                  if (req.status == 200) {
                     var tempp = $("#myRecipe_list");
                     $(tempp).html(req.responseText);

                  } else {
                     alert("서버 에러발생");
                  }
               }
            };

            req.open("post", "UserRecipeServlet", true);/*true로 할 경우만 비동기통신*/
            req.setRequestHeader("content-type",
                  "application/x-www-form-urlencoded; charset=UTF-8");
            req.send("method=" + method + "&" + "situation=" + situation
                  + "&nation=" + nation + "&ingredient=" + ingredient+"&kindOf="+kindOf); //*email 서블릿에서 받고 싶을때 getParameter("email") 하믄됨*/

         }
      };
   </script>
   <div id="myRecipe_banner"></div>
   <div class="myRecipe_container">
      <form class="myRecipe_form">
         <div class="container">
            <div id="myRecipe_title">
               <span id="myRecipe_span_title">나도 요리사</span>
            </div>
            <div class="myRecipe_element" id="myRecipe_category">
               <div class="myRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="myRecipe_li_categoryName1"><span
                        id="myRecipe_span_categoryName1" class="myRecipe_span_value"
                        id="">방법별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home"class="myRecipe_method">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="myRecipe_method">끓이기</a></li>
                     <li><a data-toggle="tab" href="#menu1" class="myRecipe_method">볶음</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="myRecipe_method">부침</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="myRecipe_method">찜</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="myRecipe_method">튀김</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="myRecipe_method">절이기</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="myRecipe_method">구이</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="myRecipe_method">조림</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="myRecipe_method">회</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="myRecipe_method">삶기</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="myRecipe_method">데치기</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="myRecipe_method">무침</a></li>
                     <li><a data-toggle="tab" href="#menu12" class="myRecipe_method">비빔</a></li>
                     <li><a data-toggle="tab" href="#menu13" class="myRecipe_method">굽기</a></li>
                     <li><a data-toggle="tab" href="#menu14" class="myRecipe_method">기타</a></li>
                  </ul>
               </div>
               <div class="myRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="myRecipe_li_categoryName2"><span
                        id="myRecipe_span_categoryName2" class="myRecipe_span_value"
                        id="">상황별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="myRecipe_situation">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="myRecipe_situation">일상</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="myRecipe_situation">손님접대</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="myRecipe_situation">이유식</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="myRecipe_situation">나들이</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="myRecipe_situation">간식</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="myRecipe_situation">초스피드</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="myRecipe_situation">술안주</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="myRecipe_situation">푸드스타일링</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="myRecipe_situation">다이어트</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="myRecipe_situation">영양식</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="myRecipe_situation">명절</a></li>
                     <li><a data-toggle="tab" href="#menu12" class="myRecipe_situation">야식</a></li>
                     <li><a data-toggle="tab" href="#menu13" class="myRecipe_situation">해장</a></li>
                     <li><a data-toggle="tab" href="#menu14" class="myRecipe_situation">아침식사</a></li>
                     <li><a data-toggle="tab" href="#menu15" class="myRecipe_situation">채식</a></li>
                     <li><a data-toggle="tab" href="#menu17" class="myRecipe_situation">데이트</a></li>
                     <li><a data-toggle="tab" href="#menu18" class="myRecipe_situation">도시락</a></li>
                     <li><a data-toggle="tab" href="#menu19" class="myRecipe_situation">기타</a></li>
                  </ul>
               </div>
               <div class="myRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="myRecipe_li_categoryName3"><span
                        id="myRecipe_span_categoryName4" class="myRecipe_span_value"
                        id="">나라별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home"
                        class="myRecipe_nation">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="myRecipe_nation">한식</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="myRecipe_nation">양식</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="myRecipe_nation">일식</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="myRecipe_nation">중식</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="myRecipe_nation">기타</a></li>
                  </ul>
               </div>
               <div class="myRecipe_MainCategory">
                  <ul class="nav nav-pills">
                     <li id="myRecipe_li_categoryName4"><span
                        id="myRecipe_span_categoryName4" class="myRecipe_span_value"
                        id="">재료별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home"
                        class="myRecipe_ingredient">전체</a> --></li>
                        <li><a data-toggle="tab" href="#menu1" class="myRecipe_ingredient">소고기</a></li>
                        <li><a data-toggle="tab" href="#menu2" class="myRecipe_ingredient">돼지고기</a></li>
                        <li><a data-toggle="tab" href="#menu3" class="myRecipe_ingredient">닭고기</a></li>
                        <li><a data-toggle="tab" href="#menu4" class="myRecipe_ingredient">육류</a></li>
                        <li><a data-toggle="tab" href="#menu5" class="myRecipe_ingredient">채소류</a></li>
                        <li><a data-toggle="tab" href="#menu6" class="myRecipe_ingredient">해물류</a></li>
                        <li><a data-toggle="tab" href="#menu7" class="myRecipe_ingredient">달걀/유제품</a></li>
                        <li><a data-toggle="tab" href="#menu8" class="myRecipe_ingredient">가공식품류</a></li>
                        <li><a data-toggle="tab" href="#menu9" class="myRecipe_ingredient">쌀</a></li>
                        <li><a data-toggle="tab" href="#menu10" class="myRecipe_ingredient">밀가루</a></li>
                        <li><a data-toggle="tab" href="#menu11" class="myRecipe_ingredient">건어물류</a></li>
                        <li><a data-toggle="tab" href="#menu12" class="myRecipe_ingredient">버섯류</a></li>
                        <li><a data-toggle="tab" href="#menu13" class="myRecipe_ingredient">과일류</a></li>
                        <li><a data-toggle="tab" href="#menu14" class="myRecipe_ingredient">콩/견과류</a></li>
                        <li><a data-toggle="tab" href="#menu15" class="myRecipe_ingredient">곡류</a></li>
                        <li><a data-toggle="tab" href="#menu16" class="myRecipe_ingredient">기타</a></li>
                        
                  </ul>
               </div>
               <div class="myRecipe_MainCategory">
                  <ul class="nav nav-pills">
                  <li id="myRecipe_li_categoryName5"><span id="myRecipe_span_categoryName2" class="myRecipe_span_value" id="">종류별</span></li>
                     <li class="active"><!-- <a data-toggle="tab" href="#home" class="myRecipe_kindOf">전체</a> --></li>
                     <li><a data-toggle="tab" href="#menu1" class="myRecipe_kindOf">밑반찬</a></li>
                     <li><a data-toggle="tab" href="#menu2" class="myRecipe_kindOf">메인반찬</a></li>
                     <li><a data-toggle="tab" href="#menu3" class="myRecipe_kindOf">국/탕</a></li>
                     <li><a data-toggle="tab" href="#menu4" class="myRecipe_kindOf">찌개</a></li>
                     <li><a data-toggle="tab" href="#menu5" class="myRecipe_kindOf">디저트</a></li>
                     <li><a data-toggle="tab" href="#menu6" class="myRecipe_kindOf">면/만두</a></li>
                     <li><a data-toggle="tab" href="#menu7" class="myRecipe_kindOf">밥/죽/떡</a></li>
                     <li><a data-toggle="tab" href="#menu8" class="myRecipe_kindOf">전</a></li>
                     <li><a data-toggle="tab" href="#menu9" class="myRecipe_kindOf">김치젓갈/장류</a></li>
                     <li><a data-toggle="tab" href="#menu10" class="myRecipe_kindOf">양념/소스/잼</a></li>
                     <li><a data-toggle="tab" href="#menu11" class="myRecipe_kindOf">양식</a></li>
                     <li><a data-toggle="tab" href="#menu12" class="myRecipe_kindOf">샐러드</a></li>
                     <li><a data-toggle="tab" href="#menu13" class="myRecipe_kindOf">스프</a></li>
                     <li><a data-toggle="tab" href="#menu14" class="myRecipe_kindOf">빵</a></li>
                     <li><a data-toggle="tab" href="#menu15" class="myRecipe_kindOf">과자</a></li>
                     <li><a data-toggle="tab" href="#menu16" class="myRecipe_kindOf">차/음료/술</a></li>
                     <li><a data-toggle="tab" href="#menu17" class="myRecipe_kindOf">기타</a></li>
                  </ul>
               </div>
            </div>
            <div class="myRecipe_element" id="myRecipe_all_list">
               <div id="myRecipe_recipeWrite">
                  <input type="button" id="myRecipe_input_recipeWrite"
                     value="레시피 작성하기" onclick="location.href='writeRecipe.jsp'">
               </div>
               <div class="tab-content" id="myRecipe_list">


               </div>
            </div>
         </div>
      </form>
   </div>
      <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="gg" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
  <div id="tempHereInsert"></div>
</body>
</html>