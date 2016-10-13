<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="profile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장보기 목록</title>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function(){ 
      $.ajax({
         url:"CartServlet",
         type:"POST",
         data:{"cartKindOf":"readOnly"},
         success:function(data) {
            $("#cartList_Container").html(data);
         }
      });
    }); 
</script>
<div style="width:78%; height:300px; margin-left:10%; margin-top:5%;" id="cartList_Container">
<!-- 데이터 삽입 부분 -->
</div>

</body>
</html>