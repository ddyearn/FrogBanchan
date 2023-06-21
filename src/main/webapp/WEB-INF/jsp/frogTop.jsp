<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">

	<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/offcanvas-navbar/">
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="../../css/topStyle.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <nav class="navBar sticky-top">
        <c:choose>
            <c:when test="${sessionScope.userSession ne null}">
                <a class="navbar-brand ms-4" href="/user/main">
                    <img class="frogMainIcon" src="${request.getContextPath()}/img/logo2.jpg" />
                </a>
            </c:when>
            <c:when test="${sessionScope.placeSession ne null}">
                <a class="navbar-brand ms-4" href="/place/main">
                    <img class="frogMainIcon" src="${request.getContextPath()}/img/logo2.jpg" />
                </a>
            </c:when>
            <c:otherwise>
                <a class="navbar-brand ms-4" href="/login">
                    <img class="frogMainIcon" src="${request.getContextPath()}/img/logo2.jpg" />
                </a>
            </c:otherwise>
        </c:choose>
        <div class="navBox1 d-flex">
            <span class="navBox2">
                <img class="spoonIcon" src="../../img/spoon.jpg" />&nbsp;
                <c:choose>
                    <c:when test="${sessionScope.userSession ne null}">
                        <a class="navText1" href="/user/myPage">${userSession.user.username}</a>
                        <span class="navText2">&nbsp;님&nbsp;&nbsp;</span>
                    </c:when>
                    <c:when test="${sessionScope.placeSession ne null}">
                        <a class="navText1" href="/place/myPage">${placeSession.place.placeId}</a>
                        <span class="navText2">&nbsp;님&nbsp;&nbsp;</span>
                    </c:when>
                    <c:otherwise>
                        <a href="/login">login</a>
                    </c:otherwise>
                </c:choose>
            </span>
            <button class="btn btn-outline-danger" type="button" onClick="location.href='/logout'">
                로그아웃
            </button>
        </div>

        <div class="navLine">
        </div>
    </nav>
</body>
</html>