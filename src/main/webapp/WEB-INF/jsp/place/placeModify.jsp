<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>정보 수정</title>
</head>
<body>
    <form:form modelAttribute="placeForm" method="post">
        <label for="placeId">아이디</label>:
        <form:input path="place.placeId" readonly="true" />
        <br/>
        <label for="password">비밀번호</label>:
        <form:password path="place.password" showPassword="true"/>
        <form:errors path="place.password"/>
        <br/>
        <label for="confirmPassword">비밀번호 확인</label>:
        <form:password path="confirmPassword" showPassword="true"/>
        <form:errors path="confirmPassword"/>
        <br/>
        <label for="name">가게명</label>:
        <form:input path="place.name" />
        <form:errors path="place.name"/>
        <br/>
        <label for="address">주소</label>:
        <form:input path="place.address" />
        <form:errors path="place.address"/>
        <br/>

        </br>
        <input type="submit" value="수정하기" />
    </form:form>
    <button type="button" onClick="location.href='/place/delete'">탈퇴하기</button>
</body>
</html>