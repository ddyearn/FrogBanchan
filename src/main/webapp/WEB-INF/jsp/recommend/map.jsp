<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>recommendMap</title>
    <link rel="stylesheet" type="text/css" href="../../../css/topStyle.css">
    <style>
        .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
        .wrap * {padding: 0;margin: 0;}
        .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
        .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
        .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
        .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
        .info .close:hover {cursor: pointer;}
        .info .body {position: relative;overflow: hidden;}
        .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
        .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
        .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
        .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
        .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
        .info .link {color: #5085BB;}
    </style>
</head>
<body>
<div style="width:80%;margin: 0 auto;padding:30px;">
    <span style="font-size: 50px;margin: 2% 0;"><b>${menuName}</b> 맛집 검색</span>
    <br>
    <span style="font-size: 20px;float:right;">위치 : <span style="text-decoration: underline;">동덕여자대학교</span></span>
</div>
<div id="map" style="width:80%;height:670px;border: 1px solid #000000;border-radius:30px;margin: 0 auto;"></div>
<br>
<div style="text-align: center;">
    <button style="height: 50px;width: 15%;border: 1px solid #000000;border-radius: 15px;font-size: 30px;background-color: white"
            type="button" onClick="history.back()">다른 메뉴 추천해줘!</button></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1edbbc68addc788e67cef306ea562f13"></script>
<script>
    const { kakao } = window;
    var mapContainer = document.getElementById('map'), // 지도의 중심좌표
        mapOption = {
            center: new kakao.maps.LatLng(37.6068163, 127.0423832), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커를 표시할 위치와 title 객체 배열입니다
    var positions = [
        {
            title: '토리 돈까스',
            latlng: new kakao.maps.LatLng(37.6044911, 127.042321)
        },
        {
            title: '송송식탁',
            latlng: new kakao.maps.LatLng(37.6038873, 127.042740)
        }
    ];

    var geocoder = new kakao.maps.services.Geocoder();
    var coords;
    // 주소로 좌표를 검색합니다
    geocoder.addressSearch(positions[0].address, function(result, status) {
        coords = new kakao.maps.LatLng(result[0].y, result[0].x);
    });

    for(let i=0; i < positions.length; i++){
        var data = positions[i];
        displayMarker(data);
    }

    // 지도에 마커를 표시하는 함수입니다
    function displayMarker(data) {
        var marker = new kakao.maps.Marker({
            map: map,
            position: data.latlng
        });
        var overlay = new kakao.maps.CustomOverlay({
            content: content,
            map: map,
            position: marker.getPosition()
        });

        var content = document.createElement('div');
        content.innerHTML = data.title + '<br>' + data.latlng + '<br>';
        content.style.cssText = 'background: white; border: 1px solid black';

        var detail = document.createElement('button');
        detail.innerHTML = '자세히 보기';
        detail.onclick = function () {

        }
        content.appendChild(detail);

        var closeBtn = document.createElement('button');
        closeBtn.innerHTML = '닫기';
        closeBtn.onclick = function () {
            overlay.setMap(null);
        };
        content.appendChild(closeBtn);
        overlay.setContent(content);

        kakao.maps.event.addListener(marker, 'click', function() {
            overlay.setMap(map);
        });
    }
</script>
<table style="width:70%">
    <tr><th>가게이름</th><th>위치</th></tr>
    <c:forEach var="place" items="${placeList}" varStatus="status">
        <tr>
            <td>${place.name}</td>
            <td>${place.address}</td>
            <td><a href='<c:url value="/place/view"><c:param name="placeId" value="${place.placeId}"/></c:url>'>가게 보기</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>