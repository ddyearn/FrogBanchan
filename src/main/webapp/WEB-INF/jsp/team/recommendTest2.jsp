<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>test</title>
</head>
<body>
	hate tags:
	<br/>
	<c:forEach var="tag" items="${hateList}" varStatus="status">
	    <span>${tag}</span>
	</c:forEach>
	<br/>
	selected members:
	<br/>
	<c:forEach var="member" items="${memberList}" varStatus="status">
	    <span>${member.name}</span>
	</c:forEach>
</body>
</html>