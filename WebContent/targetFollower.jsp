<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="targetProfile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>팔로우</title>
<link rel="stylesheet" type="text/css" href="css/profile_css/cs.css">
<script>
$(document).ready(function(){
	$('#screen-selector').on('click', function(event) {

	    /* var name = $(event.target).attr('id'); */
	    
	    if(document.activeElement.tagName == 'INPUT')
	    {
	    	//var name = $(event.target).attr('id')+":"+$(event.target).val();
	    	var name = $(event.target).attr('id');
	    	if($(event.target).val() == "+팔로우")
	    		name += ":follow";
	    	else//팔로잉일경우
	    		name += ":following";
	    	
	    	
	    	alert("팔로워페이지 : "+name);
	    	document.location.href="followCheck?followerCode="+name;
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
		<div id="follower_content">
			<div id="screen-selector">
				<c:forEach var="follower" items="${followerArray}">
					<div class="following_profile">
						<div class="following_profileImg">
							<c:if test="${follower.vFollowUserImage != null}">
								<a href="#"><img src="${follower.vFollowUserImage}"></a>
							</c:if>
							<c:if test="${follower.vFollowUserImage eq null }">
								<a href="#"><img
									src="https://d12hfz37g51hrt.cloudfront.net/user/1595456/original/9b2b62fbda850211e90db1d54985c7a8d840dc35.jpg"></a>
							</c:if>
						</div>
						<div class="following_profileName">
							<a href="#">${follower.vFollowUserName}</a>
						</div>
						<div class="following_followingBtn">
							<!-- <input type="button" id="friendsList_followBtn" value="+팔로우" /> -->
							<c:if test="${follower.tFollowCode == null}">
								<input type="button" id="${follower.vFollowUserCode}" class="friendsList_followBtn" value="+팔로우" />
							</c:if>
							<c:if test="${follower.tFollowCode != null}">
								<input type="button" id="${follower.tFollowCode}" class="following_followBtn" value="✔팔로잉" />
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		
			<!-- <div class="following_profile">
				<div class="following_profileImg">
					<a href="#"><img
						src="img/profile_img/10345982_852744308099397_1882240356207679456_n.jpg"></a>
				</div>
				<div class="following_profileName">
					<a href="#">김정윤</a>
				</div>
				<div class="following_followingBtn">
					<input type="button" id="friendsList_followBtn" value="+팔로우" />
				</div>
			</div> -->
			
			

			
		</div>
	</div>
</body>
</html>