<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>recommendMenu</title>
</head>
<body>
맛있게 냠냠구리~!
<br/>
<span>${placeId}</span>
<br/>
의 음식은 어떠셨냐구리?
<button class="backButton" type="button" onclick="location.reload()">다시 추천해줘!</button>
<button class="createButton" type="button" onclick="location.href ='/recommend/map?menuName=${menu.name}&menuId=${menu.menuId}'">좋아!</button>
</body>
</html>