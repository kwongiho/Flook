<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="targetProfile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$('#screen-selector').on('click', function(event) {
	    // Retrieve the 'name' data attribute of the <a/> tag that the user clicked.
	    /* var name = $(event.target).attr('id'); */
	    
	    if(document.activeElement.tagName == 'INPUT')
	    {
	    	var name = $(event.target).attr('id')+":following";
	  
	    	
	    	//var name = $(event.target).val();
	    	alert("팔로잉페이지 : "+name);
	    	document.location.href="followCheck?followCode="+name;
	 	    //alert("You clicked on:"+ name);
	    }
	    else
	    	;
	    
	   
	});
});
</script>
</head>
<body id="following_body">
	<div id="following_outer">
		<div id="following_content">
		
		
			
			
			
			<div id="screen-selector">
			<c:forEach var="following" items="${followingArray}">
				<div class="following_profile">
					<div class="following_profileImg">
						<a href="#"><img
							src="${following.userImage}"></a>
					</div>
					<div class="following_profileName">
						<a href="#">${following.userName}</a>
					</div>
					<div class="following_followingBtn">
						<!-- <input type="button" id="friendsList_followBtn" value="+팔로우" /> -->
						<input type="button" id="${following.followerCode}" class="following_followBtn" value="✔팔로잉" />
					</div>
				</div>
			</c:forEach>
			</div>

			
		</div>
	</div>
</body>
</html>