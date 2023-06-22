<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../frogTop.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.frog.frogbanchan.domain.Reservation" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/user/reservationListStyle.css">
    <title>reservations</title>

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
    <div id="mainbox">
            <div id="titleWrap">
            예약 조회
            <br/>
                <h6 id="backbutton" onclick="location.href='/user/myPage'">뒤로가기</h6>
            </div>
            <div id="rectangle1">
                <h3 id="explain">최근 7개의 예약만 보여집니다. (예약순)</h3>
                <div id="listWrapper">
                    <div id="rectangle2">
                        <% List<Reservation> reservationDateList = (ArrayList<Reservation>)request.getAttribute("reservationDateList");
                            List<Reservation> reservationNameList = (ArrayList<Reservation>)request.getAttribute("reservationNameList");
                            List<Reservation> reservationIDList = (ArrayList<Reservation>)request.getAttribute("reservationIDList");
                        %>
                        <% for (int i = reservationDateList.size() - 1; i >= 0; i--) { %>
                            <% int topValue = 20 + (reservationDateList.size()-i-1) * 85; %>
                            <% int lineValue = 90 + (reservationDateList.size()-i-1) * 85; %>
                            <h5 class="dateText" id="dateText<%= i %>" style="top: <%= topValue %>px;"><%= reservationDateList.get(i) %></h5>
                            <h5 class="placenameText" id="nametext<%= i %>" style="top: <%= topValue %>px;"><%= reservationNameList.get(i) %></h5>
                            <h5 class="checkText" id="checktext<%= i %>" style="top: <%= topValue %>px;">보기</h5>
                            <button class="checkButton" id="checkButton<%= i %>" style="top: <%= topValue %>px;" onclick="location.href='/reservation/check?rsvId=${reservationIDList.get(i)}'"></button>
                            <% if(reservationDateList.size() - i != 7) { %>
                            <p class="listLine" id="listLine<%= i %>" style="top: <%= lineValue %>px;"/>
                            <% } %>
                            <% if(reservationDateList.size() - i == 7) {break;} %>
                        <% } %>
                    </div>
                </div>
            </div>
      </div>
</body>
</html>