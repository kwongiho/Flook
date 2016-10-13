<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
var iRememberYou=0;;
   var x=document.getElementsByClassName('star');
   
   /*function(m)은 스코프체인으로 change까지 객체가 생성되고 해당하는 번호의 노드만 변경할수있게끔*/
   //for(var i=x.length-1;i!=0;i--){
   for(var i=0;i<x.length;i++){
      (function(m){x.item(i).addEventListener("mouseover", function() {change(m);} );   }) (i);
      (function(m){x.item(i).addEventListener("mouseout",function(){unchange(m);});})  (i);
      
   }
      
      $(".star").click(function(){
      
         if(x.length!=0){
            alert("레시피 취향이 추가되었습니다!");
            
         }
         
         $(".star").attr("class","g");
         return;

      });
   
   
   
})
function change(j)
{
   
   iRememberYou=j;
      for(var q=0;q<=j;q++){
         
      var str= document.getElementsByClassName('star').item(q).src;
      var res= str.replace("off.png","on.png");
      document.getElementsByClassName('star').item(q).src=res;
      
   }
}
function unchange(k)
{
   for(var q=0;q<=k;q++) {
      $(".star").click(function(){ return k; });
      var str= document.getElementsByClassName('star').item(q).src;
      var res= str.replace("on.png","off.png");
      document.getElementsByClassName('star').item(q).src=res; 
   }
}
</script>
<style type="text/css">
</style>
</head>
<body>
<% for(int i=0;i<5;i++) {%>
<img src="img/search_img/star-off.png" class="star" id="img<%=i%>">
<%} %>
</body>
</html>