<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>mainForPlace</title>
	<link rel="stylesheet" type="text/css" href="../../css/mainPlaceStyle.css">
</head>
<body>
    <div class="placeNameBox">
        <p class="placeNameText">${place.name}</p>
    </div>

    <a class="mngBox placeMng" href="#" data-text="가게 관리"></a>
    <a class="mngBox menuMng" href="#" data-text="메뉴 관리"></a>

    <div class="horizonLine">
    </div>

    <div class="reservTodayBox">
        <p class="reservTodayText">오늘의 예약</p>
    </div>

    <div class="reservListBox">
        <p class="reservListText">최근 예약 신청</p>
    </div>
</body>
</html>