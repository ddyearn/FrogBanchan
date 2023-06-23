<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>예약 폼</title>
	<link rel="stylesheet" type="text/css" href="../../css/reservation/reservationFormStyle.css">
</head>

<body>
    <form action="/reservation/result?placeId=${placeId}" method="post">
    <div class="container">
        <h1 class="title">예약</h1>
        <div class="form-group">
            <label>Date:</label>
            <span><%= request.getAttribute("selectedDay") %></span>
        </div>
        <div class="form-group">
            <label>Time:</label>
            <span><%= request.getAttribute("selectedTime") %></span>
        </div>
        <div class="form-group">
            <label>Name:</label>
            <span>${userSession.user.username}</span>
        </div>
        <div class="form-group">
            <label>Number of Reservations:</label>
            <select name="numReservations">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
            </select>
        </div>
        <div class="button-container">
            <input type="hidden" name="selectedDay" value="${selectedDay}"">
            <input type="hidden" name="selectedTime" value="${selectedTime}"">
            <button class="button mt-3" type="button" onclick="location.href='/reservation/time?placeId=${placeId}&selectedDay=${selectedDay}'">뒤로가기</button>
            <input type="submit" class="button mt-3" value="예약하기"></button>
        </div>
    </div>
    </form>
</body>
</html>
