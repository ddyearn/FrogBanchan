<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>마이페이지</title>
</head>
<body>
    <br/> <br/> <br/>
    <button type="button" onClick="location.href='/user/modify'">내 정보 관리</button>
    <button type="button" onClick="location.href='/history/myHistory'">히스토리 관리</button>
    <button type="button" onClick="location.href='/user/reservation'">예약 관리</button>
    <br/>
    ${user.username} <br/>
    ${user.password} <br/>
    ${user.name} <br/>
    ${user.nickname} <br/>
    ${user.phone} <br/>
    ${user.email} <br/>
    ${user.residentNo} <br/>
    ${user.address} <br/>
</body>
</html>