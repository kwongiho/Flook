<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html id="join_html">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Flook</title>
	<link rel="stylesheet" type="text/css" href="css/profile_css/cs.css">
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<script type="text/javascript">
/* 추후 통합 시 스크립트 이동의 불편함이 있을것이라 생각되어 따로 script 태그에 작성함.
통합자 마음대로 변경가능.*/
$(document).ready(function(){ 
	
	if('${joinError == "fail"}'=='true')
	{
		alert("이미 존재하는 아이디 입니다."); 
	}
	$("#join_submitBtn").click(function(){
		
		/* 아이디중복체크해야됨 */
		if($("#join_name").val().trim()=="") {
			alert("이름은 필수입니다!!!");
			$("#join_name").focus();
			return;
		} else if ($("#join_email").val().trim()=="") {
			alert("이메일(아이디)는 필수입니다!!!");
			$("#join_email").focus();
			return;
		} else if ($("#join_password").val().trim()=="") {
			alert("비밀번호는 필수입니다!!!");
			
			$("#join_password").focus();
			return ;
		} else if($(':radio[name=sex]:checked').val()==null) {
			alert("성별을 체크해 주세요!");
			return;
		} else if($("#join_birthday_yearId").val()=="none" || $("#join_birthday_monthId").val()=="none"|| $("#join_birthday_dayId").val()=="none") {
			alert("생년월일은 필수입니다!!");
			if($("#join_birthday_yearId option:selected").val()=="none") {
				$("#join_birthday_yearId").focus();
			} else if( $("#join_birthday_monthId").val()=="none") {
				$("#join_birthday_monthId").focus();
			} else if( $("#join_birthday_dayId").val()=="none" ) {
				$("#join_birthday_dayId").focus();
			}
			return ;
			
		}  else if(typeof parseInt($("#join_birthday_yearId").val().trim())!="number" || typeof parseInt($("#join_birthday_monthId").val().trim())!="number" || typeof parseInt($("#join_birthday_dayId").val().trim())!="number") {
			if(typeof parseInt($("#join_birthday_yearId").val().trim())!= "number") {
				$("#join_birthday_yearId").focus();
				alert(typeof $("#join_birthday_yearId").val());
				
				
			} else if (typeof parseInt($("#join_birthday_monthId").val().trim())!="number") {
				$("#join_birthday_monthId").focus();
				
				
			} else // if (typeof parseInt($("#join_birthday_dayId").val().trim)!="number")  
			{
				$("#join_birthday_dayId").focus();
				
				
			}
			alert("생년월일은 숫자만 가능합니다!");
			
			return;
		}
		$("#join_form_id").submit();
		
		
	});
});
</script>
<body>
	<form method="post" action="join" name="join_form_name" id="join_form_id"><!-- 기호추가 -->
		<div>
			<table id="join_table">
				<th id="join_header">회원가입</th>
				<tr><td id="join_name_parent"><input type="text" id="join_name" name="join_name_name" placeholder="이름" size="20px" required value="${requestScope.userName }"/></td></tr>
				<tr><td id="join_email_parent"><input type="text" id="join_email" name="join_email_name" placeholder="이메일 주소" size="20px" required/></td></tr>
				<tr><td id="join_password_parent"><input type="password" id="join_password" name="join_password_name" placeholder="비밀번호" size="20px" required/></td></tr>
				<tr><td id="join_gender" name="join_gender">
					<input type="radio" name="sex" value="female"/>여자
					<input type="radio" name="sex" value="male"/>남자
				</td></tr>
				<tr><td id="join_birthday">
				<select id="join_birthday_yearId" name="join_birthday_year" ><option value="none">선택</option>
					<option value="2015">2015</option><option value="2014">2014</option><option value="2013">2013</option><option value="2012">2012</option><option value="2011">2011</option>
					<option value="2010">2010</option><option value="2009">2009</option><option value="2008">2008</option><option value="2007">2007</option><option value="2006">2006</option><option value="2005">2005</option><option value="2004">2004</option><option value="2003">2003</option><option value="2002">2002</option><option value="2001">2001</option>
					<option value="2000">2000</option><option value="1999">1999</option><option value="1998">1998</option><option value="1999">1997</option><option value="1999">1996</option><option value="1995">1995</option><option value="1994">1994</option><option value="1993">1993</option><option value="1992">1992</option><option value="1991">1991</option>
					<option value="1999">1990</option><option value="1989">1989</option><option value="1988">1988</option><option value="1987">1987</option><option value="1986">1986</option><option value="1985">1985</option><option value="1984">1984</option><option value="1983">1983</option><option value="1982">1982</option><option value="1981">1981</option>
					<option value="1980">1980</option><option value="1979">1979</option><option value="1978">1978</option><option value="1977">1977</option><option value="1976">1976</option><option value="1975">1975</option><option value="1974">1974</option><option value="1973">1973</option><option value="1972">1972</option><option value="1971">1971</option>
					<option value="1970">1970</option><option value="1969">1969</option><option value="1968">1968</option><option value="1967">1967</option><option value="1966">1966</option><option value="1965">1965</option><option value="1964">1964</option><option value="1963">1963</option><option value="1962">1962</option><option value="1961">1961</option>
					<option value="1960">1960</option><option value="1959">1959</option><option value="1958">1958</option><option value="1957">1957</option><option value="1956">1956</option><option value="1955">1955</option><option value="1954">1954</option><option value="1953">1953</option><option value="1952">1952</option><option value="1951">1951</option>
					<option value="1950">1950</option><option value="1949">1949</option><option value="1948">1948</option><option value="1947">1947</option><option value="1946">1946</option><option value="1945">1945</option><option value="1944">1944</option><option value="1943">1943</option><option value="1942">1942</option><option value="1941">1941</option>
					<option value="1940">1940</option><option value="1939">1939</option><option value="1938">1938</option><option value="1937">1937</option><option value="1936">1936</option><option value="1935">1935</option><option value="1934">1934</option><option value="1933">1933</option><option value="1932">1932</option><option value="1931">1931</option>
					<option value="1930">1930</option><option value="1929">1929</option><option value="1928">1928</option><option value="1927">1927</option><option value="1926">1926</option><option value="1925">1925</option><option value="1924">1924</option><option value="1923">1923</option><option value="1922">1922</option><option value="1921">1921</option>
					
				</select>
				년
				<select id="join_birthday_monthId" name="join_birthday_month"><option value="none">선택</option>
					<option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
				</select>
				월
				<select id="join_birthday_dayId" name="join_birthday_day"><option value="none">선택</option>
					<option value="01">01</option><option value="02">02</option><option value="03">03</option><option value="04">04</option><option value="05">05</option><option value="06">06</option><option value="07">07</option><option value="08">08</option><option value="09">09</option><option value="10">10</option>
					<option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option>
					<option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option>
					<option value="31">31</option>
					
				</select>
				일
					<!-- <input type="text" size="4.9px" id="join_birthday_yearId" name="join_birthday_year" class="join_birthdayInput" placeholder="생년">
					<input type="text" size="3px" id="join_birthday_monthId" name="join_birthday_month" class="join_birthdayInput" placeholder="월">
					<input type="text" size="3px" id="join_birthday_dayId" name="join_birthday_day" class="join_birthdayInput" placeholder="일"> -->
				</td></tr>
				<tr><td><input type="button" id="join_submitBtn" value="회원가입"/><input type="button" onclick="location.href='Login.jsp'" id="join_backBtn" value="돌아가기"></tr>
			</table>
		</div>
	</form>
</body>
</html>