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
오늘은
<br/>
<span>${menu.name}</span>
<br/>
어때구리?
<button class="backButton" type="button" onclick="location.reload()">다시 추천해줘!</button>
<button class="createButton" type="button" onclick="location.href ='/recommend/map?menuName=${menu.name}&menuId=${menu.menuId}'">좋아!</button>
</body>
</html>