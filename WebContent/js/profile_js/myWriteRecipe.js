$(document).ready(function(){
	/*이 클릭 이벤트는 네비바의 이름이나 마우스 오버시 나타나는 내 프로필 클릭 시 발생하는 이벤트를 처리하기 위해서 작성한것.*/
	$(".myProfileNiceness").click(function(){
		//alert("myProfileNiceness 클릭됨.");//확인하려고
		$("#profileNiceness_form").submit();
	});
});
function myRecipe()
{
	window.location="myRecipe";
}
function myScrap()
{
	window.location="myScrap";
}

function myGraph(){
	window.location="profileAnalyzing";
}

