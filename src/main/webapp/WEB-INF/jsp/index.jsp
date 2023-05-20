<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
	<p>index</p>
	<c:choose>
        <c:when test="${sessionScope.userSession ne null}">
            <p>${userSession.user.username}님, 환영합니다!</p>
        </c:when>
        <c:otherwise>
            <a href="/user/login">go to login</a>
        </c:otherwise>
	</c:choose>
</body>
</html>
