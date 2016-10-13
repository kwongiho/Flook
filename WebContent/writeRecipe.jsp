<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="margin.jsp"%>
<!DOCTYPE html>
<html id="Write_html">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>레시피 작성</title>
<!-- Bootstrap -->
<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/writeRecipe_js/submit.js"></script>
<script>
	$(document).ready(function() {
						var step = 1;
						$('#write_addMainIngredientButton').on('click',function() {
											var mainIngredientTable = $('#write_mainIngredient')
											$(mainIngredientTable)
													.find('li:last')
													.after(
															'<li><div><input type="text" placeholder="재료"  name="mainIngredient" required="required" class="tags"/></div><input type="number" placeholder="수량"  name="mainIngredientAmount"required="required"/><select name="mainIngredientUnit"><option value="IUC001">g</option><option value="IUC002">ml</option><option value="IUC003">개</option><option value="IUC004">종이컵</option><option value="IUC005">숟가락</option><option value="IUC006">줌</option><option>직접입력</option></select><button class="write_modMainIngredientButton" onclick="deleteLine(this);">-</button></li>');
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
															'<li><div><input type="text" placeholder="재료"  name="subIngredient"required="required" class="tags"/></div><input type="number" placeholder="수량"  name="subIngredientAmount"required="required"/><select name="subIngredientUnit"><option value="IUC001">g</option><option value="IUC002">ml</option><option value="IUC003">개</option><option value="IUC004">종이컵</option><option value="IUC005">숟가락</option><option value="IUC006">줌</option><option>직접입력</option></select><button class="write_modSubIngredientButton" onclick="deleteLine(this);">-</button></li>');

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
																	+ '" style="display: none;"onchange="return ShowImagePreview( this.files,'
																	+ step
																	+ ');"><textarea class="write_textarea_step" placeholder="예) 조리방법을 상세하게 설명하여요~" style="height:147px; width:610px; resize:none;" name="cookingCaption"></textarea><input type="hidden" value=0 name='+step+'><button class="write_modRecipeButton" onclick="deleteLine(this);">-</button></li>');
											step++;
										});
						$('#write_input_submit').on('click', function() {
							alert("레시피가 작성되었습니다.");
						})
					})
	function deleteLine(obj) {
		var tr = $(obj).parent();

		//라인 삭제
		tr.remove();
	}
</script>
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
			action="writeRecipe" enctype="multipart/form-data">
			<!-- method action 추가 -->
			<div id="write_element1" class="write_element">
				<div id="write_name_scope">
					<input type=file name='completeImage' style='display: none;' id="completeImage" onchange="InputImage();"> 
						<img name="complete" alt="" id="write_photo" src="img/write_img/pic_none4.gif" 
						style="width: 210px; height: 210px; cursor: pointer" onclick='document.all.completeImage.click(); '>
					<label class="labelBox" id="Write_recipeName">레시피명 </label>
					 
					<input type="text" id="write_input_recipeName" size="82" placeholder="예)쉽게만드는 나만의 레시피!" name="recipeName">

				</div>
				<div id="write_recipeDiscription">
					<label class="labelBox" id="write_label_recipeDiscription">사용자
						한마디 </label>
					<textarea id="write_input_recipeDiscription"
						placeholder="예) 나만의 레시피를 간단히 설명해주세요."
						style="height: 100px; width: 610px; resize: none;"
						name="recipeDescription"></textarea>
				</div>
				<div id="write_category">
					<label class="labelBox" id="write_label_category">카테고리</label> <select
						name="category">
						<option value="CCT000">나라별</option>
						<option value="CCT001">한식</option>
						<option value="CCT002">양식</option>
						<option value="CCT003">일식</option>
						<option value="CCT004">중식</option>
						<option value="CCT005">기타</option>
					</select> <select name="category">
						<option value="ICT000">재료별</option>
						<option value="ICT001">육류</option>
						<option value="ICT002">해물류/건어물류</option>
						<option value="ICT003">곡류</option>
						<option value="ICT004">콩/견과류</option>
						<option value="ICT005">채소류</option>
						<option value="ICT006">버섯류</option>
						<option value="ICT007">빵류</option>
						<option value="ICT008">가공식품류</option>
						<option value="ICT009">면류/떡류</option>
						<option value="ICT010">과일류</option>
						<option value="ICT011">달걀/유제품</option>
						<option value="ICT012">기타</option>
					</select> <select name="category">
						<option value="KCT000">종류별</option>
						<option value="KCT001">밥/죽</option>
						<option value="KCT002">면/만두</option>
						<option value="KCT003">국/탕/찌개</option>
						<option value="KCT004">김치/밑반찬</option>
						<option value="KCT005">샐러드/스프</option>
						<option value="KCT006">양념/소스/잼</option>
						<option value="KCT007">차/음료</option>
						<option value="KCT008">베이킹/떡</option>
						<option value="KCT009">도시락/간식/디저트</option>
						<option value="KCT010">튀김</option>
						<option value="KCT011">기타</option>
					</select> <select name="category">
						<option value="SCT000">상황별</option>
						<option value="SCT001">일상</option>
						<option value="SCT002">손님접대</option>
						<option value="SCT003">이유식</option>
						<option value="SCT004">나들이</option>
						<option value="SCT005">간식</option>
						<option value="SCT006">초스피드</option>
						<option value="SCT007">술안주</option>
						<option value="SCT008">푸드 스타일링</option>
						<option value="SCT009">다이어트쿡</option>
						<option value="SCT010">영양식</option>
						<option value="SCT011">명절</option>
						<option value="SCT012">야식</option>
						<option value="SCT013">해장</option>
						<option value="SCT014">아침식사</option>
						<option value="SCT015">채식</option>
						<option value="SCT016">데이트</option>
					</select> <select name="category">
						<option value="MCT000">방법별</option>
						<option value="MCT001">끓이기</option>
						<option value="MCT002">볶음</option>
						<option value="MCT003">부침</option>
						<option value="MCT004">찜</option>
						<option value="MCT005">튀김</option>
						<option value="MCT006">절이기</option>
						<option value="MCT007">구이</option>
						<option value="MCT008">조림</option>
						<option value="MCT009">회</option>
						<option value="MCT010">삶기</option>
						<option value="MCT011">데치기</option>
						<option value="MCT012">무침</option>
						<option value="MCT013">비빔</option>
						<option value="MCT014">굽기</option>
						<option value="MCT015">기타</option>
					</select>
				</div>
				<div id="write_cookInfo">
					<label class="labelBox" id="write_label_cookInfo">요리정보 </label> <select
						name="personNumber">
						<option value="0">인원</option>
						<option value="1">1인분</option>
						<option value="2">2인분</option>
						<option value="3">3인분</option>
						<option value="4">4인분</option>
						<option value="5">5인분이상</option>
					</select> <select name="cookingTime">
						<option>시간</option>
						<option value="5">5분 이내</option>
						<option value="10">10분 이내</option>
						<option value="15">15분 이내</option>
						<option value="30">30분 이내</option>
						<option value="60">60분 이내</option>
						<option value="90">90분 이내</option>
						<option value="120">2시간 이내</option>
						<option value="120over">2시간 이상</option>
					</select> <select name="cookingLevel">
						<option>난이도</option>
						<option value="easy">쉬움</option>
						<option value="normal">보통</option>
						<option value="hard">어려움</option>
					</select>
				</div>
				<div id="write_tag">
					<label class="labelBox" id="write_label_tag">태그달기</label> <input
						type="text" id="write_input_tag" size="82" placeholder="예)#짜장#돼지"
						name="hashTags">
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
						<li><div><input type="text" placeholder="재료" name="mainIngredient"
							required="required" class="tags" /></div> <input type="number" placeholder="수량"
							name="mainIngredientAmount" required="required" /> <select
							id="write_mainIngredientUnit" name="mainIngredientUnit">
								<option value="IUC001">g</option>
								<option value="IUC002">ml</option>
								<option value="IUC003">개</option>
								<option value="IUC004">종이컵</option>
								<option value="IUC005">숟가락</option>
								<option value="IUC006">줌</option>
								<option>직접입력</option>
						</select> <input type="button" class="write_modMainIngredientButton"
							value="-"></li>
					</ul>
					<div>
						<input type="button" id="write_addMainIngredientButton"
							value="+ 재료 추가">
					</div>
				</div>
				<div>
					<ul id="write_subIngredient">
						<li><label id="write_label_subIngredient">부재료</label></li>
						<li><div><input type="text" placeholder="재료" name="subIngredient"
							required="required" class="tags" /></div> <input type="number" placeholder="수량"
							name="subIngredientAmount" required="required" /> <select
							id="write_subIngredientUnit" name="subIngredientUnit">
								<option value="IUC001">g</option>
								<option value="IUC002">ml</option>
								<option value="IUC003">개</option>
								<option value="IUC004">종이컵</option>
								<option value="IUC005">숟가락</option>
								<option value="IUC006">줌</option>
								<option>직접입력</option>
						</select> <input type="button" class="write_modSubIngredientButton"
							value="-"></li>
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
					<li>
						<img id="cookingImage0" alt="" src="img/write_img/pic_none3.gif" class="write_img_pic" style="width: 140px; height: 140px; cursor: pointer"
						onclick='document.all.cookingImageFile0.click(); '> <input
						id="cookingImageFileid0" type="file" name="cookingImageFile0"
						style='display: none;'
						onchange="return ShowImagePreview( this.files,0 );"> <textarea
							class="write_textarea_step" placeholder="예) 조리방법을 상세하게 설명하여요~"
							style="height: 147px; width: 610px; resize: none;"
							name="cookingCaption"></textarea> <input type="button"
						class="write_modRecipeButton" value="-"></li>
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
	<!-- 2015.10.01 안쓸거 같아서 주석해놓음. -->
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"> -->
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>  
<script src="js/writeRecipe_js/autoComplete.js"type="text/javascript"
   charset="UTF-8"></script>
</body>
</html>