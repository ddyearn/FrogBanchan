<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>recommendMap</title>
    <link rel="stylesheet" type="text/css" href="../../../css/recommend/mapStyle.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".error").click(function() {
                $(this).hide();
                $(this).siblings(".input").focus();
            });
        });
    </script>
</head>
<body>
<div class="mainbox">
    <div class="titleWrap">
        <b>${menuName}</b> 맛집 검색
    </div>
    <div class="contentWrap">
        <span class="loc" id = "relocate">현 위치에서 검색</span>
    </div>
    <br/>
    <div class="contentWrap">

        <div id="map" class="map"></div>
    </div>
    <div class="bttnWrapper">
        <button class="backButton" type="button" onClick="history.back()">메뉴 다시 추천해줘!</button>
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1edbbc68addc788e67cef306ea562f13&libraries=services"></script>
<script>
    // 주소좌표 전환 geocoder
    var geocoder = new kakao.maps.services.Geocoder();

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.6068163, 127.0423832), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption);

    <c:forEach var="place" items="${placeList}">

    geocoder.addressSearch("${place.address}", function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            // 마커가 표시될 위치입니다
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: coords
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);

            var iwContent = '<div style="padding:5px;">${place.name} <br><a href="/place/view?placeId=${place.placeId}" style="color:blue">가게 상세 보기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                iwPosition = coords; //인포윈도우 표시 위치입니다

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                position : iwPosition,
                content : iwContent
            });

            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
            infowindow.open(map, marker);
        }
    });
    </c:forEach>

    var rl = document.getElementById('relocate');
    var locPosition;
    rl.addEventListener('click', function(){
        if (navigator.geolocation) {

            // GeoLocation을 이용해서 접속 위치를 얻어옵니다
            navigator.geolocation.getCurrentPosition(function(position) {

                var lat = position.coords.latitude, // 위도
                    lon = position.coords.longitude; // 경도
                locPosition = new kakao.maps.LatLng(lat, lon);
            });

        } else { // HTML5의 GeoLocation을 사용할 수 없을때
            alert('geolocation을 사용할수 없어요..');
        }
        map.setCenter(locPosition);
    })
</script>
</div>
</body>
</html>