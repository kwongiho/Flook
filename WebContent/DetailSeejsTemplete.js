function detailSee(recipeCode) {
   /*alert(recipeCode);*/
   $.ajax({
      url : "detail",
      type : 'POST',
      data : {
         "choiceRecipe" : recipeCode
      },
      success : function(data) {
         $("#tempHereInsert").html(data);
          /*alert("?"); */
         $("#gg").trigger("click");
         
         $("#bookmarkBtn").click(function(){
            var bookmarkBtnSrc;
            bookmarkBtnSrc=$("#bookmarkBtn").attr("src");
            
            if(bookmarkBtnSrc==="img/main_img/BookmarkF.png") {
               $("#bookmarkBtn").attr("src","img/main_img/BookmarkU.png");
               deleteScrap(recipeCode);
            } else if(bookmarkBtnSrc==="img/main_img/BookmarkU.png") {
               $("#bookmarkBtn").attr("src","img/main_img/BookmarkF.png");
               insertScrap(recipeCode);
            } // else문 end
         });//bookmarkBtn종료.
         $("#good_Btn").click(function(){
            if($("#good_Btn").attr("src")==="img/main_img/good_BtnU.png") {
               $.ajax({
                  url : 'like',
                  type:"POST",
                  data:{
                     "recipeCode" : recipeCode,
                     "like" : "N"
                  },
                  success : function(data) {
                     alert("좋아요");
                     $("#good_Btn").attr("src","img/main_img/good_BtnF.png");
                  }
               }); // ajax종료
            } else {
               $.ajax({
                  url:'like',
                  type:"POST",
                  data:{
                     "recipeCode":recipeCode,
                     "like" : "Y"
                  },
                  success : function(data) {
                     alert("좋아요취소");
                     $("#good_Btn").attr("src","img/main_img/good_BtnU.png");
                  }
               });//ajax종료
            }//else종료
         });
      }
   });
}
function deleteScrap(recipeCode){
   $.ajax({
      url:"ScrapDeleteServlet",
      type:"POST",
      data:{
         "recipeCode" : recipeCode
      },
      success : function(data) {
         $("#"+recipeCode).css("display","none");
         alert("스크랩 삭제되었습니다.");
      }
   });
}
function insertScrap(recipeCode) {
   
   $.ajax({
      url:"ScrapAddServlet",
      type:"POST",
      data : {
         "recipeCode" : recipeCode
      },
      success : function(data) {
         alert("스크랩되었습니다.");
      }
   }); 
}
/* 
<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
      data-target="#detailRecipeModal" id="gg" style="display: none;">이거
      봤니?이게 보여?보이면 안되는데;;</button>
      
      *
      *
      *이거 반드시 있어야함
      *
      */