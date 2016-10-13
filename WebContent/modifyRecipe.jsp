<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="margin.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html id="Write_html">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>레시피 수정</title>
<!-- Bootstrap -->
<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- <script src="js/writeRecipe_js/submit.js"></script> -->
<script>
   $(document)
         .ready(
               function() { 
                     /* var sel = document.getElementById("edit_country");
                     var se2 = document.getElementById("edit_inredient");
                     var se3 = document.getElementById("edit_kind");
                     var se4 = document.getElementById("edit_situation");
                     var se5 = document.getElementById("edit_method");
                      
                     for(var i=0; i<sel.length; i++){  
                        if(sel[i].text.equal('${userUIBean.countryCategory}')){
                           alert('${userUIBean.countryCategory}');
                           sel[i].selected = true;
                           alert("ee");
                        }
                     }
                     for(var i=0; i<se2.length; i++){
                        if(se2[i].text.equal('${userUIBean.ingredientCategory}')){
                           se2[i].selected = true;
                        }
                     }
                     for(var i=0; i<se3.length; i++){
                        if(se3[i].text.equal('${userUIBean.kindCategory}')){
                           se3[i].selected = true;
                        }
                     }
                     for(var i=0; i<se4.length; i++){
                        if(se4[i].text.equal('${userUIBean.situationCategory}')){
                           se5[i].selected = true;
                        }
                     }
                     for(var i=0; i<se5.length; i++){
                        if(se5[i].text.equal('${userUIBean.methodCategory}')){
                           se5[i].selected = true;
                        }
                     }

                     var personNum=document.getElementById("edit_personNum");
                     var cookingTime=document.getElementById("edit_cookingTime");
                     var cookingLevel=document.getElementById("edit_cookingLevel");
                     for(var i=0;i<personNum.length;i++)
                     {
                        if(personNum[i].textequal('${userUIBean.personNumber}')){
                           personNum[i].selected=true;
                        }
                     }
                     for(var i=0;i<cookingTime.length;i++)
                     {
                        if(cookingTime[i].textequal('${userUIBean.cookingTime}')){
                           cookingTime[i].selected=true;
                        }
                     }
                     for(var i=0;i<cookingLevel.length;i++)
                     {
                        if(cookingLevel[i].textequal('${userUIBean.cookingLevel}')){
                           cookingLevel[i].selected=true;
                        }
                     }
                     
                       */ 
                        var step ='${fn:length(userUIBean.cookingList)}';
                  $('#write_addMainIngredientButton')
                        .on(
                              'click',
                              function() {
                                 var mainIngredientTable = $('#write_mainIngredient')
                                 $(mainIngredientTable)
                                       .find('li:last')
                                       .after(
                                             '<li><input type="text" placeholder="재료"  name="mainIngredient"/><input type="text" placeholder="수량"  name="mainIngredientAmount"/><select name="mainIngredientUnit"><option value="IUC001">g</option><option value="IUC002">ml</option><option value="IUC003">개</option><option value="IUC004">종이컵</option><option value="IUC005">숟가락</option><option value="IUC006">줌</option><option>직접입력</option></select><button class="write_modMainIngredientButton" onclick="deleteLine(this);">-</button></li>');
                                 //$(this).html('hi');

                              });
                  $('#write_addSubIngredientButton')
                        .on(
                              'click',
                              function() {
                                 var subIngredientTable = $('#write_subIngredient')

                                 $(subIngredientTable)
                                       .find('li:last')
                                       .after(
                                             '<li><input type="text" placeholder="재료"  name="subIngredient"/><input type="text" placeholder="수량"  name="subIngredientAmount"/><select name="subIngredientUnit"><option value="IUC001">g</option><option value="IUC002">ml</option><option value="IUC003">개</option><option value="IUC004">종이컵</option><option value="IUC005">숟가락</option><option value="IUC006">줌</option><option>직접입력</option></select><button class="write_modSubIngredientButton" onclick="deleteLine(this);">-</button></li>');

                              });
                  $('#write_addRecipeButton')
                        .on(
                              'click',
                              function() {
                                 var cookingProgress = $('#write_cooking_progress');
                                 $(cookingProgress)
                                       .find('li:last')
                                       .after(
                                             '<li><img id="cookingImage'
												+ step
												+ '" alt="" src="img/write_img/pic_none3.gif" class="write_img_pic" style="width: 140px; height: 140px; cursor:pointer"onclick="document.all.cookingImageFile'
												+ step
												+ '.click(); "><input type="file" id="cookingImageFileid'
												+ step
												+ '" name="cookingImageFile'
												+ step
												+ '" style="display: none;"onchange="ShowImagePreview( this.files,'
												+ step
												+ ');"><input type="hidden" value=""name="photo" id="cookingImageHidden'+ step +'"><textarea class="write_textarea_step" placeholder="예) 조리방법을 상세하게 설명하여요~" style="height:147px; width:610px; resize:none;" name="cookingCaption"></textarea><input type="hidden" value=0 name='+step+'><button class="write_modRecipeButton" onclick="deleteLine(this);">-</button></li>');
						step++;
                              });

               }

         ) 
   function deleteLine(obj) {
      var tr = $(obj).parent();

      //라인 삭제
      tr.remove();
   }
   /* function addResource(prev_step,init_json){
      var step=0;
      $("#write_mainIngredient [id^liResource_]").each(function(){
         var tmp=$(this).prop('id').replace('liResource_','');
         var tmp_step=parseInt(tmp,10);
      });
      step++;
      
      var str='<tr><td><input type="text" placeholder="재료" name=mainIngredient id="write_mainIngredient_'+step+'"></td>"';
      //str+='<td><input type="text" placeholder="수량" name=mainIngredientAmount id="write_mainIngredientAmount_'+step+'"/></td>';
      //str+='<td><select class="write_mainIngredientUnit"id="write_mainIngredientUnit_'+step+'"><option>g</option></select></td>;
      //str+='<td><button onclick="deleteMainIngredient(this);">-</button></td></tr>';
      if(typedef prev_step=='undefined'||prev_step===null||prev_step==0){
         $(str).appendTo('#write_mainIngredient');
      }
      else{
         $(str).insertAfter("#liResource_"+prev_step);
      }
      if (typeof init_json !== 'undefined' && init_json !== null && init_json['nm']) {
         
      }

   } */
</script>
<!-- 
   <script>
   $("body").click(function(event){  
      alert(event.target.property);
   });
   </script> -->

<script type="text/javascript">
   var InputImage = (function loadImageFile() {
      if (window.FileReader) {
         var ImagePre;
         var ImgReader = new window.FileReader();
         var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

         ImgReader.onload = function(Event) {
            if (!ImagePre) {
               ImagePre = document.getElementById("write_photo");

            }
            ImagePre.src = Event.target.result;

         };

         return function() {

            var img = document.getElementById("completeImage").files;
            //이미지 사이즈 체크
            if (img[0].size > 10240000) {
               alert("이미지는" + ~~(img[0].size / 1024) + "KB");
               return;
            }

            if (!fileType.test(img[0].type)) {
               alert("이미지 파일을 업로드 하세요");
               return;
            }

            ImgReader.readAsDataURL(img[0]);
         }

      }

   })(); 
</script>
<script type="text/javascript">
   var InputImage2 = (function loadImageFile() {
      if (window.FileReader) {

         var ImagePre;
         var ImgReader = new window.FileReader();
         var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i;

         ImgReader.onload = function(Event) {
            if (!ImagePre) {
               ImagePre = document.getElementById("cookingImage0");

            }
            ImagePre.src = Event.target.result;

         };

         return function() {

            var img = document.getElementById("cookingImageFileid0").files;

            if (!fileType.test(img[0].type)) {
               alert("이미지 파일을 업로드 하세요");
               return;
            }

            ImgReader.readAsDataURL(img[0]);
         }

      }

   })();
</script>
<script type="text/javascript">
	function ShowImagePreview(files, num) {
		var file = files[0];

		if (!(/^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i)
				.test(file.type)) {
			alert("이미지 파일을 업로드 하세요.");
			return false;
		}

		reader = new FileReader();
		reader.onload = function(event) {
			var img = document.getElementById('cookingImage'.concat(num));
			img.src = event.target.result;
		}
		reader.readAsDataURL(file);
	}
</script>


<link href="css/writeRecipe_css/writeRecipe.css" rel="stylesheet"
	type="text/css"></link>
</head>
<body id="Write_body">
	<jsp:include page="navigation.jsp" flush="false" />
	<div id="Write_container">
		<form id="Write_form" class="Write_form" method="post"
			action="modifyRecipe" enctype="multipart/form-data">
			<!-- method action 추가 -->
			. <input type="hidden" name="recipeCode2" value='${recipeCode}'>
			<div id="write_element1" class="write_element">
				<div id="write_name_scope">
					<!-- <input type="image" src="img/write_img/pic_none4.gif"    id="write_photo" style="width: 210px; height: 210px; cursor:pointer" name="completeImage"> -->
					<input type=file name='completeImage' style='display: none;'
						id="completeImage" onchange="InputImage();"> <img
						name="complete" alt="img/write_img/pic_none4.gif" id="write_photo"
						src="${userUIBean.completeImage }"
						style="width: 210px; height: 210px; cursor: pointer"
						onclick='document.all.completeImage.click(); '><input
						type="hidden" value=${userUIBean.completeImage } name="photo"
						id="photoValue">
					<!-- <img alt="" id="write_photo" src="img/write_img/pic_none4.gif"  style="width: 210px; height: 210px; cursor:pointer"onclick='document.all.completeImageFile.click(); document.all.completeImage.src=document.all.completeImageFile.value' name='completeImage'> -->
					<label class="labelBox" id="Write_recipeName">레시피명 </label> <input
						type="text" id="write_input_recipeName" size="82"
						placeholder="예)쉽게만드는 나만의 레시피!" name="recipeName"
						value="${userUIBean.recipeName}">

				</div>
				<div id="write_recipeDiscription">
					<label class="labelBox" id="write_label_recipeDiscription">사용자
						한마디 </label>
					<textarea id="write_input_recipeDiscription"
						placeholder="예) 나만의 레시피를 간단히 설명해주세요."
						style="height: 100px; width: 610px; resize: none;"
						name="recipeDescription">${userUIBean.recipeDescription}</textarea>
				</div>
				<div id="write_category">
					<label class="labelBox" id="write_label_category">카테고리</label> <select
						name="category" id="edit_country">
						<option value="CCT000"
							<c:if test="${userUIBean.countryCategory eq '나라별' }">selected="true"</c:if>>나라별</option>
						<option value="CCT001"
							<c:if test="${userUIBean.countryCategory eq '한식' }">selected="true"</c:if>>한식</option>
						<option value="CCT002"
							<c:if test="${userUIBean.countryCategory eq '양식' }">selected="true"</c:if>>양식</option>
						<option value="CCT003"
							<c:if test="${userUIBean.countryCategory eq '일식' }">selected="true"</c:if>>일식</option>
						<option value="CCT004"
							<c:if test="${userUIBean.countryCategory eq '중식' }">selected="true"</c:if>>중식</option>
						<option value="CCT005"
							<c:if test="${userUIBean.countryCategory eq '기타' }">selected="true"</c:if>>기타</option>
					</select> <select name="category" id="edit_ingredient">
						<option value="ICT000"
							<c:if test="${userUIBean.ingredientCategory eq '재료별' }">selected="true"</c:if>>재료별</option>
						<option value="ICT001"
							<c:if test="${userUIBean.ingredientCategory eq '육류' }">selected="true"</c:if>>육류</option>
						<option value="ICT002"
							<c:if test="${userUIBean.ingredientCategory eq '해물류/건어물류' }">selected="true"</c:if>>해물류/건어물류</option>
						<option value="ICT003"
							<c:if test="${userUIBean.ingredientCategory eq '곡류' }">selected="true"</c:if>>곡류</option>
						<option value="ICT004"
							<c:if test="${userUIBean.ingredientCategory eq '콩/견과류' }">selected="true"</c:if>>콩/견과류</option>
						<option value="ICT005"
							<c:if test="${userUIBean.ingredientCategory eq '채소류' }">selected="true"</c:if>>채소류</option>
						<option value="ICT006"
							<c:if test="${userUIBean.ingredientCategory eq '버섯류' }">selected="true"</c:if>>버섯류</option>
						<option value="ICT007"
							<c:if test="${userUIBean.ingredientCategory eq '빵류' }">selected="true"</c:if>>빵류</option>
						<option value="ICT008"
							<c:if test="${userUIBean.ingredientCategory eq '가공식품류' }">selected="true"</c:if>>가공식품류</option>
						<option value="ICT009"
							<c:if test="${userUIBean.ingredientCategory eq '면류/떡류' }">selected="true"</c:if>>면류/떡류</option>
						<option value="ICT010"
							<c:if test="${userUIBean.ingredientCategory eq '과일류' }">selected="true"</c:if>>과일류</option>
						<option value="ICT011"
							<c:if test="${userUIBean.ingredientCategory eq '달걀/유제품' }">selected="true"</c:if>>달걀/유제품</option>
						<option value="ICT012"
							<c:if test="${userUIBean.ingredientCategory eq '기타' }">selected="true"</c:if>>기타</option>
					</select> <select name="category" id="edit_kind">
						<option value="KCT000"
							<c:if test="${userUIBean.kindCategory eq '종류별' }">selected="true"</c:if>>종류별</option>
						<option value="KCT001"
							<c:if test="${userUIBean.kindCategory eq '밥/죽' }">selected="true"</c:if>>밥/죽</option>
						<option value="KCT002"
							<c:if test="${userUIBean.kindCategory eq '면/만두' }">selected="true"</c:if>>면/만두</option>
						<option value="KCT003"
							<c:if test="${userUIBean.kindCategory eq '국/탕/찌개' }">selected="true"</c:if>>국/탕/찌개</option>
						<option value="KCT004"
							<c:if test="${userUIBean.kindCategory eq '김치/밑반찬' }">selected="true"</c:if>>김치/밑반찬</option>
						<option value="KCT005"
							<c:if test="${userUIBean.kindCategory eq '샐러드/스프' }">selected="true"</c:if>>샐러드/스프</option>
						<option value="KCT006"
							<c:if test="${userUIBean.kindCategory eq '양념/소스/잼' }">selected="true"</c:if>>양념/소스/잼</option>
						<option value="KCT007"
							<c:if test="${userUIBean.kindCategory eq '차/음료' }">selected="true"</c:if>>차/음료</option>
						<option value="KCT008"
							<c:if test="${userUIBean.kindCategory eq '베이킹/떡' }">selected="true"</c:if>>베이킹/떡</option>
						<option value="KCT009"
							<c:if test="${userUIBean.kindCategory eq '도시락/간식/디저트' }">selected="true"</c:if>>도시락/간식/디저트</option>
						<option value="KCT010"
							<c:if test="${userUIBean.kindCategory eq '튀김' }">selected="true"</c:if>>튀김</option>
						<option value="KCT011"
							<c:if test="${userUIBean.kindCategory eq '기타' }">selected="true"</c:if>>기타</option>
					</select> <select name="category" id="edit_situation">
						<option value="SCT000"
							<c:if test="${userUIBean.situationCategory eq '상황별' }">selected="true"</c:if>>상황별</option>
						<option value="SCT001"
							<c:if test="${userUIBean.situationCategory eq '일상' }">selected="true"</c:if>>일상</option>
						<option value="SCT002"
							<c:if test="${userUIBean.situationCategory eq '손님접대' }">selected="true"</c:if>>손님접대</option>
						<option value="SCT003"
							<c:if test="${userUIBean.situationCategory eq '이유식' }">selected="true"</c:if>>이유식</option>
						<option value="SCT004"
							<c:if test="${userUIBean.situationCategory eq '나들이' }">selected="true"</c:if>>나들이</option>
						<option value="SCT005"
							<c:if test="${userUIBean.situationCategory eq '간식' }">selected="true"</c:if>>간식</option>
						<option value="SCT006"
							<c:if test="${userUIBean.situationCategory eq '초스피드' }">selected="true"</c:if>>초스피드</option>
						<option value="SCT007"
							<c:if test="${userUIBean.situationCategory eq '술안주' }">selected="true"</c:if>>술안주</option>
						<option value="SCT008"
							<c:if test="${userUIBean.situationCategory eq '푸드 스타일링' }">selected="true"</c:if>>푸드
							스타일링</option>
						<option value="SCT009"
							<c:if test="${userUIBean.situationCategory eq '다이어트쿡' }">selected="true"</c:if>>다이어트쿡</option>
						<option value="SCT010"
							<c:if test="${userUIBean.situationCategory eq '영양식' }">selected="true"</c:if>>영양식</option>
						<option value="SCT011"
							<c:if test="${userUIBean.situationCategory eq '명절' }">selected="true"</c:if>>명절</option>
						<option value="SCT012"
							<c:if test="${userUIBean.situationCategory eq '야식' }">selected="true"</c:if>>야식</option>
						<option value="SCT013"
							<c:if test="${userUIBean.situationCategory eq '해장' }">selected="true"</c:if>>해장</option>
						<option value="SCT014"
							<c:if test="${userUIBean.situationCategory eq '아침식사' }">selected="true"</c:if>>아침식사</option>
						<option value="SCT015"
							<c:if test="${userUIBean.situationCategory eq '채식' }">selected="true"</c:if>>채식</option>
						<option value="SCT016"
							<c:if test="${userUIBean.situationCategory eq '데이트' }">selected="true"</c:if>>데이트</option>
					</select> <select name="category" id="edit_method">
						<option value="MCT000"
							<c:if test="${userUIBean.methodCategory eq '방법별' }">selected="true"</c:if>>방법별</option>
						<option value="MCT001"
							<c:if test="${userUIBean.methodCategory eq '끓이기' }">selected="true"</c:if>>끓이기</option>
						<option value="MCT002"
							<c:if test="${userUIBean.methodCategory eq '볶음' }">selected="true"</c:if>>볶음</option>
						<option value="MCT003"
							<c:if test="${userUIBean.methodCategory eq '부침' }">selected="true"</c:if>>부침</option>
						<option value="MCT004"
							<c:if test="${userUIBean.methodCategory eq '찜' }">selected="true"</c:if>>찜</option>
						<option value="MCT005"
							<c:if test="${userUIBean.methodCategory eq '튀김' }">selected="true"</c:if>>튀김</option>
						<option value="MCT006"
							<c:if test="${userUIBean.methodCategory eq '절이기' }">selected="true"</c:if>>절이기</option>
						<option value="MCT007"
							<c:if test="${userUIBean.methodCategory eq '구이' }">selected="true"</c:if>>구이</option>
						<option value="MCT008"
							<c:if test="${userUIBean.methodCategory eq '조림' }">selected="true"</c:if>>조림</option>
						<option value="MCT009"
							<c:if test="${userUIBean.methodCategory eq '회' }">selected="true"</c:if>>회</option>
						<option value="MCT010"
							<c:if test="${userUIBean.methodCategory eq '삶기' }">selected="true"</c:if>>삶기</option>
						<option value="MCT011"
							<c:if test="${userUIBean.methodCategory eq '데치기' }">selected="true"</c:if>>데치기</option>
						<option value="MCT012"
							<c:if test="${userUIBean.methodCategory eq '무침' }">selected="true"</c:if>>무침</option>
						<option value="MCT013"
							<c:if test="${userUIBean.methodCategory eq '비빔' }">selected="true"</c:if>>비빔</option>
						<option value="MCT014"
							<c:if test="${userUIBean.methodCategory eq '굽기' }">selected="true"</c:if>>굽기</option>
						<option value="MCT015"
							<c:if test="${userUIBean.methodCategory eq '기타' }">selected="true"</c:if>>기타</option>
					</select>
				</div>
				<div id="write_cookInfo">
					<label class="labelBox" id="write_label_cookInfo">요리정보 </label> <select
						name="personNumber" id="edit_personNum">
						<option value="0"
							<c:if test="${userUIBean.personNumber == 0 }">selected="true"</c:if>>인원</option>
						<option value="1"
							<c:if test="${userUIBean.personNumber == 1 }">selected="true"</c:if>>1인분</option>
						<option value="2"
							<c:if test="${userUIBean.personNumber == 2 }">selected="true"</c:if>>2인분</option>
						<option value="3"
							<c:if test="${userUIBean.personNumber == 3 }">selected="true"</c:if>>3인분</option>
						<option value="4"
							<c:if test="${userUIBean.personNumber == 4 }">selected="true"</c:if>>4인분</option>
						<option value="5"
							<c:if test="${userUIBean.personNumber == 5 }">selected="true"</c:if>>5인분이상</option>
					</select> <select name="cookingTime" id="edit_cookingTime">
						<option>시간</option>
						<option value="5"
							<c:if test="${userUIBean.cookingTime eq '5' }">selected="true"</c:if>>5분
							이내</option>
						<option value="10"
							<c:if test="${userUIBean.cookingTime eq '10' }">selected="true"</c:if>>10분
							이내</option>
						<option value="15"
							<c:if test="${userUIBean.cookingTime eq '15' }">selected="true"</c:if>>15분
							이내</option>
						<option value="30"
							<c:if test="${userUIBean.cookingTime eq '30' }">selected="true"</c:if>>30분
							이내</option>
						<option value="60"
							<c:if test="${userUIBean.cookingTime eq '60' }">selected="true"</c:if>>60분
							이내</option>
						<option value="90"
							<c:if test="${userUIBean.cookingTime eq '90' }">selected="true"</c:if>>90분
							이내</option>
						<option value="120"
							<c:if test="${userUIBean.cookingTime eq '120' }">selected="true"</c:if>>2시간
							이내</option>
						<option value="120over"
							<c:if test="${userUIBean.cookingTime eq '120over' }">selected="true"</c:if>>2시간
							이상</option>
					</select> <select name="cookingLevel" id="edit_cookingLevel">
						<option>난이도</option>
						<option value="easy"
							<c:if test="${userUIBean.cookingLevel eq 'easy' }">selected="true"</c:if>>쉬움</option>
						<option value="normal"
							<c:if test="${userUIBean.cookingLevel eq 'normal' }">selected="true"</c:if>>보통</option>
						<option value="hard"
							<c:if test="${userUIBean.cookingLevel eq 'hard' }">selected="true"</c:if>>어려움</option>
					</select>
				</div>
				<div id="write_tag">
					<label class="labelBox" id="write_label_tag">태그달기</label> <input
						type="text" id="write_input_tag" size="82" placeholder="예)#짜장#돼지"
						name="hashTags" value="${userUIBean.hashTag}">
				</div>
			</div>
			<!-- 
      <div id="write_element2" class="write_element">
         <div id="write_finishPhoto">
         
         </div>
      </div>
      -->
			<div id="write_element3" class="write_element">
				<div>
					<ul id="write_mainIngredient">
						<li><label id="write_label_mainIngredient">주재료</label><img
							alt="" src="img/write_img/question.png"></li>

						<c:forEach var="mainIngredient"
							items="${userUIBean.mainIngredientList}">

							<li><input type="text" placeholder="재료"
								name="mainIngredient" value="${mainIngredient.ingredientName}" />
								<input type="text" placeholder="수량" name="mainIngredientAmount"
								value="${mainIngredient.ingredientAmount }" /> <select
								id="write_mainIngredientUnit" name="mainIngredientUnit">
									<option value="IUC001"
										<c:if test="${mainIngredient.ingredientUnit eq 'g' }">selected="true"</c:if>>g</option>
									<option value="IUC002"
										<c:if test="${mainIngredient.ingredientUnit eq 'ml' }">selected="true"</c:if>>ml</option>
									<option value="IUC003"
										<c:if test="${mainIngredient.ingredientUnit eq '개' }">selected="true"</c:if>>개</option>
									<option value="IUC004"
										<c:if test="${mainIngredient.ingredientUnit eq '종이컵' }">selected="true"</c:if>>종이컵</option>
									<option value="IUC005"
										<c:if test="${mainIngredient.ingredientUnit eq '숟가락' }">selected="true"</c:if>>숟가락</option>
									<option value="IUC006"
										<c:if test="${mainIngredient.ingredientUnit eq '줌' }">selected="true"</c:if>>줌</option>
									<option>직접입력</option>
							</select>

								<button class="write_modMainIngredientButton"
									onclick="deleteLine(this);">-</button>
						</c:forEach>
						<%-- <li><input type="text" placeholder="재료" name="mainIngredient" value="${userUIBean. }"/>
                     <input type="text" placeholder="수량" name="mainIngredientAmount" value="${mainIngredient.ingredientAmount }" />
                     <select id="write_mainIngredientUnit" name="mainIngredientUnit">
                        <option value="IUC001">g</option>
                        <option value="IUC002">ml</option>
                        <option value="IUC003">개</option>
                        <option value="IUC004">종이컵</option>
                        <option value="IUC005">숟가락</option>
                        <option value="IUC006">줌</option>
                        <option>직접입력</option>
                  </select> <input type="button" class="write_modMainIngredientButton"
                     value="-"></li> --%>
					</ul>
					<div>
						<input type="button" id="write_addMainIngredientButton"
							value="+ 재료 추가">
					</div>
				</div>
				<div>
					<ul id="write_subIngredient">
						<li><label id="write_label_subIngredient">부재료</label></li>
						<!-- <li><input type="text" placeholder="재료" name="subIngredient" />
                     <input type="text" placeholder="수량" name="subIngredientAmount" />
                     <select id="write_subIngredientUnit" name="subIngredientUnit">
                        <option value="IUC001">g</option>
                        <option value="IUC002">ml</option>
                        <option value="IUC003">개</option>
                        <option value="IUC004">종이컵</option>
                        <option value="IUC005">숟가락</option>
                        <option value="IUC006">줌</option>
                        <option>직접입력</option>
                  </select> <input type="button" class="write_modSubIngredientButton"
                     value="-"></li> -->
						<c:forEach var="subIngredient"
							items="${userUIBean.subIngredientList}">

							<li><input type="text" placeholder="재료" name="subIngredient"
								value="${subIngredient.ingredientName}" /> <input type="text"
								placeholder="수량" name="subIngredientAmount"
								value="${subIngredient.ingredientAmount }" /> <select
								id="write_subIngredientUnit" name="subIngredientUnit">
									<option value="IUC001"
										<c:if test="${subIngredient.ingredientUnit eq 'g' }">selected="true"</c:if>>g</option>
									<option value="IUC002"
										<c:if test="${subIngredient.ingredientUnit eq 'ml' }">selected="true"</c:if>>ml</option>
									<option value="IUC003"
										<c:if test="${subIngredient.ingredientUnit eq '개' }">selected="true"</c:if>>개</option>
									<option value="IUC004"
										<c:if test="${subIngredient.ingredientUnit eq '종이컵' }">selected="true"</c:if>>종이컵</option>
									<option value="IUC005"
										<c:if test="${subIngredient.ingredientUnit eq '숟가락' }">selected="true"</c:if>>숟가락</option>
									<option value="IUC006"
										<c:if test="${subIngredient.ingredientUnit eq '줌' }">selected="true"</c:if>>줌</option>
									<option>직접입력</option>
							</select>

								<button class="write_modMainIngredientButton"
									onclick="deleteLine(this);">-</button>
						</c:forEach>
					</ul>
					<div>
						<input type="button" id="write_addSubIngredientButton"
							value="+ 재료 추가">
					</div>
				</div>
			</div>
			<div id="write_element4" class="write_element">
				<ul id="write_cooking_progress">
					<li><label>조리사진 </label><label>● 조리방법</label></li>
					<c:forEach var="cooking" items="${userUIBean.cookingList}"
						varStatus="cookingSeq">
						<li><img id="cookingImage${cookingSeq.count-1}"
							alt="img/write_img/pic_none3.gif" src="${cooking.cookingImage}"
							class="write_img_pic"
							style="width: 140px; height: 140px; cursor: pointer"
							onclick='document.all.cookingImageFile${cookingSeq.count-1}.click(); '>
							<input id="cookingImageFileid${cookingSeq.count-1}" type="file"
							name="cookingImageFile${cookingSeq.count-1}"
							style='display: none;'
							onchange="return ShowImagePreview( this.files,${cookingSeq.count-1});">
							<input type="hidden" value=${cooking.cookingImage } name="photo"
							id="cookingImageHidden${cookingSeq.count-1}"> <textarea
								class="write_textarea_step" placeholder="예) 조리방법을 상세하게 설명하여요~"
								style="height: 147px; width: 610px; resize: none;"
								name="cookingCaption">${cooking.cookingDescription}</textarea>
							<button class="write_modRecipeButton" onclick="deleteLine(this);">-</button></li>
					</c:forEach>



					<!--    <li><img id="cookingImage0" alt="img/write_img/pic_none3.gif"
                  src="img/write_img/pic_none3.gif" class="write_img_pic"
                  style="width: 140px; height: 140px; cursor: pointer"
                  onclick='document.all.cookingImageFile0.click(); '> <input
                  id="cookingImageFileid0" type="file" name="cookingImageFile0"
                  style='display: none;' onchange="InputImage2(0);"> <textarea
                     class="write_textarea_step" placeholder="예) 조리방법을 상세하게 설명하여요~"
                     style="height: 147px; width: 610px; resize: none;"
                     name="cookingCaption"></textarea> <input type="button"
                  class="write_modRecipeButton" value="-"></li> -->
				</ul>
				<div>
					<input type="button" id="write_addRecipeButton" value="+ 순서 추가">
				</div>
				<div id="write_confirm_cancel">
					<input type="submit" value="확인" id="write_input_submit"> <input
						type="button" value="취소" id="write_input_cancel"
						onclick="location.href='main.jsp'">
				</div>
			</div>


			<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="bootstrap/dist/js/bootstrap.min.js"></script>

		</form>
	</div>
</body>
</html>