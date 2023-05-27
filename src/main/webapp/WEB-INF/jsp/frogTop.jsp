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
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navBar sticky-top">
        <div class="navBox1 d-flex">
            <span class="navBox2">
                <span class="navText1">
                    <c:choose>
                        <c:when test="${sessionScope.userSession ne null}">
                            ${userSession.user.username}
                        </c:when>
                        <c:when test="${sessionScope.placeSession ne null}">
                            ${placeSession.place.placeId}
                        </c:when>
                        <c:otherwise>
                            <a href="/login">go to login</a>
                        </c:otherwise>
                    </c:choose>
                </span>
                <span class="navText2">&nbsp;님&nbsp;&nbsp;</span>
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