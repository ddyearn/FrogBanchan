<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>정보 수정</title>
	<link rel="stylesheet" type="text/css" href="../../css/user/userFormStyle.css">
	<link rel="stylesheet" type="text/css" href="../../css/topStyle.css">
    <script type="text/javascript" src="../js/userModify.js"></script>
</head>
<body>
    <div class="joinFormBox1">
        <div class="titleBox">
            회원정보 수정
        </div>
        <div class="joinFormBox2 text-center">
            <form:form modelAttribute="userForm" method="post">
                <div class="row">
                    <label for="username" class="col col-3">아이디</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="user.username" id="username" class="input" readonly="true" />
                        <form:errors path="user.username" class="error error2"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="password" class="col col-3">비밀번호</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:password path="user.password" id="password" class="input" />
                        <form:errors path="user.password" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="confirmPassword" class="col col-3">비밀번호 확인</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:password path="confirmPassword" id="confirmPassword" class="input" />
                        <form:errors path="confirmPassword" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="name" class="col col-3">이름(본명)</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="user.name" id="name" class="input" />
                        <form:errors path="user.name" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="nickname" class="col col-3">닉네임</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-3">
                        <form:input path="user.nickname" id="nickname" class="input" />
                        <form:errors path="user.nickname" class="error error2" />
                    </div>
                    <div class="col col-2">
                        <button class="ms-4 btn btn-success checkNicknameBtn" type="button" onclick="checkExistNickname()">중복확인</button>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="phone" class="col col-3">전화번호</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="user.phone" id="phone" class="input" />
                        <form:errors path="user.phone" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="email" class="col col-3">이메일</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="user.email" id="email" class="input" type="email" />
                        <form:errors path="user.email" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="residentNo" class="col col-3">주민번호 7자리</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <div class="inputResiBox">
                            <form:input id="residentNo1" path="residentNo1" class="input inputResi" />&nbsp;-&nbsp;
                            <form:input id="residentNo2" path="residentNo2" class="input inputResi" />******
                        </div>
                        <form:errors path="user.residentNo" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="address" class="col col-3">주소</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="user.address" id="address" class="input" />
                        <form:errors path="user.address" class="error" />
                    </div>
                </div>
                <br/>

                </br>
                <div class="btnGroup">
                    <button class="btn btn-secondary backBtn me-5" type="button" onclick="location.href='/user/myPage'">취소하기</button>
                    <button class="btn btn-success registBtn ms-5" type="submit" onclick="return checkExist();">수정하기</button>
                </div>
            </form:form>
        </div>

        <div class="horizonLine">
        </div>
    </div>
    <button type="button" onClick="location.href='/user/delete'">탈퇴하기</button>
</body>
</html>