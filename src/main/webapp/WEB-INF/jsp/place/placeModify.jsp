<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>정보 수정</title>
	<link rel="stylesheet" type="text/css" href="../css/place/placeFormStyle.css">
    <script type="text/javascript" src="../js/placeJoinForm.js"></script>
    </script>
</head>
<body>
    <div class="joinFormBox1">
        <div class="titleBox">
            가게정보 수정
        </div>
        <div class="joinFormBox2 text-center placeForm">
            <form:form modelAttribute="placeForm" method="post">
                <div class="row">
                    <label for="placeId" class="col col-3">아이디</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="place.placeId" id="placeId" class="input" readonly="true" />
                        <form:errors path="place.placeId" class="error error2"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="password" class="col col-3">비밀번호</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:password path="place.password" id="password" class="input" />
                        <form:errors path="place.password" class="error" />
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
                    <label for="name" class="col col-3">가게 상호명</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="place.name" id="name" class="input" />
                        <form:errors path="place.name" class="error" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="address" class="col col-3">주소</label>
                    <span class="line col col-3">- - - - - - - - -</span>
                    <div class="inputBox col col-5">
                        <form:input path="place.address" id="address" class="input" />
                        <form:errors path="place.address" class="error" />
                    </div>
                </div>
                <br/>

                </br>
                <div class="btnGroup">
                    <button class="btn btn-secondary backBtn me-5" type="button" onclick="location.href='/join'">취소하기</button>
                    <button class="btn btn-success registBtn ms-5" type="submit">등록하기</button>
                </div>
            </form:form>
        </div>

        <div class="horizonLine">
        </div>
    </div>

</body>
</html>