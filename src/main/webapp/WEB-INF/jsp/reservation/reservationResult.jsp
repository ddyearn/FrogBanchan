<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/reservation/resultStyle.css">
    <title>Reservation Form</title>
</head>

<body>
    <div class="mainbox">
      <hr class="line" />
      <div class="page">
        <div class="titleWrap">
         예약 상세 정보
          <br/>
        </div>
        <div class="contentWrap">
        <div class="form-group">
            <label class="inputTitle">예약 날짜</label>
            <div class="line2">- - - - -  - - -</div>
            <div class= "inputWrap"><%= request.getAttribute("selectedDay") %></div>
        </div>
        <div class="form-group">
            <label class="inputTitle">예약 시간</label>
            <div class="line2">- - - - -  - - -</div>
            <div class= "inputWrap"><%= request.getAttribute("selectedTime") %></div>
        </div>
        <div class="form-group">
            <label class="inputTitle">예약자 성함</label>
            <div class="line2">- - - - -  - - -</div>
            <div class= "inputWrap">${userSession.user.username}</div>
        </div>
        <div class="form-group">
            <label class="inputTitle">예약 인원</label>
            <div class="line2">- - - - -  - - -</div>
            <div class= "inputWrap"><%= request.getAttribute("selectedPeople") %></div>
        </div>
        <div class="bttnWrapper">
            <button class="button" type="button" onclick="location.href='/reservation/calendar?placeId=${placeId}'">닫기</button>
        </div>
      </div>
     </div>
    </div>

    <script>
        function goBack() {
            var previousPageUrl = "redirect:/user/reservation/list"; // Replace with the desired URL of the previous page
            window.location.href = previousPageUrl;
        }
    </script>

</body>
</html>
