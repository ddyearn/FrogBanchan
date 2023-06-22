<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/recommend/recommendResultStyle.css">
    <title>recommendResult</title>

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
    <hr class="line" />
    <div class="page">
        <div class="titleWrap">
            맛있게 냠냠구리~!
            <img class="frogIcon" src="${request.getContextPath()}/img/frog_happy.jpg" />
            <br/>
        </div>
        <div class="descriptionWrap">
            <span>${placeName}</span>
            <br/>
        </div>
        <div class="description">

            의 음식은 어떠셨냐구리?
            <br/>
            다음 추천을 위해 오늘 먹은 메뉴 저장 잊지 마시구리!
        </div>
        <div class="bttnWrapper">
            <button class="goToMainButton" type="button" onclick="location.href='/user/main'">다음에 저장하기</button>
            <button class="goToHistoryButton" type="button" onclick="location.href='/history/list'">저장하러 가기</button>
        </div>
    </div>
</div>
</body>
</html>