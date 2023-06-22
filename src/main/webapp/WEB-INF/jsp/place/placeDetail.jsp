<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>가게 정보</title>
    <link rel="stylesheet" type="text/css" href="../../css/place/placeDetailStyle.css">
</head>
<body>
    <div class="placeBox1">
        <div class="titleBox">
            가게 정보
        </div>
        <div class="placeBox2">
            <div class="placeInfo">
                가게명 : ${place.name}
                <br/><br/>
                가게 점수 : ${place.totalScore}
                <br/><br/>
                가게 주소 : ${place.address}
                <br/><br/>
                가게 메뉴 :
                <c:forEach var="menu" items="${menuList}" varStatus="status">
                    ${menu.name}&nbsp
                </c:forEach>
            </div>
        </div>
    </div>
    <br/>
    <div class="btnGroup">
        <button class="btn btn-secondary backBtn me-4" type="button" onClick="history.go(-1)">뒤로가기</button>
        <button class="btn btn-warning historyBtn ms-4 me-4" type="button" onclick="location.href='/history/create?placeId=${place.placeId}'">방문 기록 남기기</button>
        <button class="btn btn-success reservationBtn ms-4" type="button" onclick="location.href='/reservation/calendar?placeId=${place.placeId}'">예약하러 가기</button>
    </div>
</body>
</html>