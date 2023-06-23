<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.frog.frogbanchan.domain.Reservation" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>mainForPlace</title>
	<link rel="stylesheet" type="text/css" href="../../css/place/mainPlaceStyle.css">
</head>
<body>
    <div class="placeNameBox">
        <p class="placeNameText">${place.name}</p>
    </div>

    <a class="mngBox placeMng" href="/place/myPage" data-text="가게 관리"></a>
    <a class="mngBox menuMng" href="/placemenu/list" data-text="메뉴 관리"></a>

    <div class="horizonLine">
    </div>

    <div class="reservTodayBox">
        <p class="reservTodayText">오늘의 예약</p>
        <p id="todayText">오늘은 ${currentYear}년 ${currentMonth}월 ${currentDate}일 입니다.</p>
        <div id="rectangle1">
        <!-- <h3 id="explain">최근 7개의 예약만 보여집니다. (예약순)</h3> -->
        <div id="reservTodayList">
            <% List<Reservation> reservationTimeList = (ArrayList<Reservation>)request.getAttribute("reservationTimeList");
                List<Reservation> reservationNameList = (ArrayList<Reservation>)request.getAttribute("reservationNameList");
                List<Reservation> reservationSeatList = (ArrayList<Reservation>)request.getAttribute("reservationSeatList");
            %>
            <% for (int i = reservationTimeList.size() - 1; i >= 0; i--) { %>
                <% int topValue = 10 + (reservationTimeList.size()-i-1) * 55; %>
                <% int lineValue = 50 + (reservationTimeList.size()-i-1) * 55; %>
                <h5 class="dateText" id="dateText<%= i %>" style="top: <%= topValue %>px;"><%= reservationTimeList.get(i) %>:00</h5>
                <h5 class="nameText" id="nametext<%= i %>" style="top: <%= topValue %>px;"><%= reservationNameList.get(i) %></h5>
                <h5 class="seatText" id="seattext<%= i %>" style="top: <%= topValue %>px;"><%= reservationSeatList.get(i) %>명</h5>
                <!-- <h5 class="checkText" id="checktext<%= i %>" style="top: <%= topValue %>px;">보기</h5>
                <button class="checkButton" id="checkButton<%= i %>" style="top: <%= topValue %>px;" onclick=""></button> -->
                <% if(reservationTimeList.size() - i != 7) { %>
                <p class="listLine" id="listLine<%= i %>" style="top: <%= lineValue %>px;"/>
                <% } %>
                <% if(reservationTimeList.size() - i == 7) {break;} %>
            <% } %>
        </div>
        </div>
    </div>

    <div class="reservListBox">
        <p class="reservListText">최근 예약 신청</p>
    </div>
</body>
</html>