<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>예약 확인</title>
	<link rel="stylesheet" type="text/css" href="../../css/reservation/reservationFormStyle.css">
</head>

<body>
    <form action="/user/reservation?rsvId=${reservationId}" method="post">
    <!-- 예약확인페이지를 action에 넣기 -->
    <div class="container">
        <h2 class="title check">예약 확인</h2>
        <div class="form-group">
            <label>가게 명</label>
            <span><%= request.getAttribute("placeName") %></span>
        </div>
        <div class="form-group">
            <label>Date:</label>
            <span><%= request.getAttribute("date") %></span>
        </div>
        <div class="form-group">
            <label>Time:</label>
            <span><%= request.getAttribute("time") %></span>
        </div>
        <div class="form-group">
            <label>Username:</label>
            <span>${userSession.user.username}</span>
        </div>
        <div class="form-group">
            <label>인원 수:</label>
            <span><%= request.getAttribute("seat") %></span>
        </div>
        <div class="button-container">
            <input class="button" type="submit" value="예약 취소">
            <button class="button" type="button" onclick="location.href='/user/reservation'">닫기</button> 
            <!-- 예약 확인 페이지를 location.href 에 넣기 -->
        </div>
    </div>
    </form>

    <script>
        function goBack() {
            var previousPageUrl = "/user/reservation"; // Replace with the desired URL of the previous page
            window.location.href = previousPageUrl;
        }
    </script>
</body>
</html>
