/*$(document).ready(function(){
	$("#tempMapBtn").click(function(){
		function initialize() {
			alert("ggasdf");
		    var mapOptions = {
		  		center: new google.maps.LatLng(37.537355,127.009591), //좌표
		  		zoom: 17, //확대정도
		  		mapTypeId: google.maps.MapTypeId.ROADMAP //기본지도사용(위성지도및 기타지도도있음~)
			};
			var map = new google.maps.Map(document.getElementById("tempMapScreen"),mapOptions);
		}
	});
})*/
/*$(document).ready(function(){
$("#tempMapBtn").click(function load() {
	var x = document.getElementById("demo");
	alert("ggss");
	function getLocation() {
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var map = new GMap2(document.getElementById("map"));

				map.addControl(new GSmallMapControl());
				map.addControl(new GMapTypeControl());
				map.setCenter(new GLatLng(position.coords.latitude,
						position.coords.longitude), 17);
				 var mapOptions = {
					center : new google.maps.LatLng(position.coords.latitude, position.coords.longitude), // 좌표
					zoom : 15, // 확대정도
					mapTypeId : google.maps.MapTypeId.ROADMAP
				// 기본지도사용(위성지도및 기타지도도있음~)
				};
				var map = new google.maps.Map(document
						.getElementById("tempMapScreen"), mapOptions);
			});
		} else {
			x.innerHTML = "Geolocation is not supported by this browser.";
		}
	}

});
});*/