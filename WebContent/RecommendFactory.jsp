<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">/* 발표용 스코프 코드. */
$(document).ready(function(){
var iRememberYou;
   var x=document.getElementsByClassName('starT');
   /*function(m)은 스코프체인으로 change까지 객체가 생성되고 해당하는 번호의 노드만 변경할수있게끔*/
   for(var i=0;i<x.length;i++) {
      (function(m){x.item(i).addEventListener("mouseover", function() {change(m);} );   }) (i);
      (function(m){x.item(i).addEventListener("mouseout",function(){unchange(m);});})  (i);
   }
   $(".starT").click(function(){
	      
       if(x.length!=0){
          alert("레시피 취향이 추가되었습니다!");
          
       }
       
       $(".starT").attr("class","g");
       return;

    });
   
})
function change(j)
{
   
   iRememberYou=j;
      for(var q=0;q<=j;q++){
      /* alert('와라'); */
      var str= document.getElementsByClassName('starT').item(q).src;
      var res= str.replace("off.png","on.png");
      document.getElementsByClassName('starT').item(q).src=res;
      
   }
}
function unchange(k)
{
   for(var q=0;q<=k;q++) {
      $(".starT").click(function(){ return k; });
      var str= document.getElementsByClassName('starT').item(q).src;
      var res= str.replace("on.png","off.png");
      document.getElementsByClassName('starT').item(q).src=res; 
   }
}
</script>
<c:forEach var="recipe" items="${requestScope.recommendsList}">
   <div class="view view-first">
      <img src="${recipe.completeImage }" style="width:320px;height:240px;margin:5px;" class="search_result_img"/>
      <div class="mask">
         <a type="button" href="javascript:detailSee('${recipe.recipeCode}')"><h2>${recipe.recipeName }</h2></a>
         <p>${recipe.recipeDescription }<br/>
         <%-- <jsp:include page="../fork.jsp"></jsp:include><!-- 정적인 포크  -->       --%>
         <%
            for (int i = 0; i < 5; i++) {
         %>
         <img src="img/search_img/star-off.png" class="starT" id="img<%=i%>">
         <%} %><!-- 발표용 스크립틀릿  --></p>
         <br/>
         <a type="button" id="scrapBtn" class="info"
            href="javascript:insertScrap('${recipe.recipeCode }')">스크랩</a>
      </div>
   </div> 
</c:forEach>