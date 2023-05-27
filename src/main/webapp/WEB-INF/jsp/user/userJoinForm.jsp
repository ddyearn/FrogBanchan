<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <form:form modelAttribute="userForm" method="post">
        <label for="username">아이디</label>:
        <form:input path="user.username"/>
        <form:errors path="user.username"/>
        <br/>
        <label for="password">비밀번호</label>:
        <form:password path="user.password" showPassword="true"/>
        <form:errors path="user.password"/>
        <br/>
        <label for="confirmPassword">비밀번호 확인</label>:
        <form:password path="confirmPassword" showPassword="true"/>
        <form:errors path="confirmPassword"/>
        <br/>
        <label for="name">이름</label>:
        <form:input path="user.name" />
        <form:errors path="user.name"/>
        <br/>
        <label for="nickname">닉네임</label>:
        <form:input path="user.nickname" />
        <form:errors path="user.nickname"/>
        <br/>
        <label for="phone">전화번호</label>:
        <form:input path="user.phone" />
        <form:errors path="user.phone"/>
        <br/>
        <label for="email">이메일</label>:
        <form:input path="user.email" />
        <form:errors path="user.email"/>
        <br/>
        <label for="residentNo">주민번호 7자리</label>:
        <form:input path="user.residentNo" />
        <form:errors path="user.residentNo"/>
        <br/>
        <label for="address">주소</label>:
        <form:input path="user.address" />
        <form:errors path="user.address"/>
        <br/>

        </br>
        <input type="submit" value="가입하기" />
    </form:form>
</body>
</html>