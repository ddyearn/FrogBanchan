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
    <link rel="stylesheet" type="text/css" href="../../../css/recommend/recommendMenuStyle.css">
    <title>recommendMenu</title>

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
        <div class="descriptionWrap">
            <br/>
            오늘은
            <br/>
            <span class="menuWrap">${menu.name}</span>
            <br/>
            어때구리?
            <img class="frogIcon" src="${request.getContextPath()}/img/frog_happy.jpg" />
            <br/>
        </div>
        <div class="bttnWrapper">
            <button class="backButton" type="button" onclick="location.reload()">다시 추천해줘!</button>
            <button class="selectButton" type="button" onclick="location.href ='/recommend/map?menuName=${menu.name}&menuId=${menu.menuId}'">좋아!</button>
        </div>
    </div>
</div>
</body>
</html>