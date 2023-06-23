<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 가입</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="../css/joinStyle.css">
</head>
<body>
    <div class="btnGroup">
        <button class="button button1" type="button" onClick="location.href='/join/user'"><span>일반 회원</span></button><br/><br/>
        <button class="button button2" type="button" onClick="location.href='/join/place'"><span>사업자 회원</span></button>
        <br/><br/><br/>
        <button class="btn btn-outline-dark" type="button" onClick="location.href='/login'">로그인 화면으로</button>
    </div>
</body>
</html>