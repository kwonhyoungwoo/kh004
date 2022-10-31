var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.500149122816275, 127.03345649963086), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커를 표시할 위치와 title 객체 배열입니다 
var positions = [];

	$.ajax({
		method: "GET",
		url: "https://dapi.kakao.com/v2/local/search/keyword",
		data: {query: "마켓컬리"},
		headers: {Authorization : "KakaoAK f7beed66fc9fa9e642f68c61403c55c4"},
		success: function (map){
//			console.log(map);
			for (var i = 0; i < map.documents.length; i++){
				positions.push({
					title: map.documents[i].place_name + " (" + map.documents[i].road_address_name  + ")", 
					latlng: new kakao.maps.LatLng(map.documents[i].y, map.documents[i].x)
				})
			}
		},
		async:false //동기식처리 : 서버에서 응답을 기다렸다가 응답을 모두 완료하고 다음 로직을 실행시킴. (기본값,true)
	});
// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}	