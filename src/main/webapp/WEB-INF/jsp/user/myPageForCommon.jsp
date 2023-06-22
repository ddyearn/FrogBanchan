<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>마이페이지</title>
	<link rel="stylesheet" type="text/css" href="../../css/user/myPageStyle.css">
</head>
<body>
    <div class="myPageBox1">
        <div class="titleBox">
            마이페이지
        </div>
        <div class="myPageBox2 text-center">
            <div class="userInfoBox">
                <div class="row mt-4">
                    <span class="col col-3 ms-3">아이디</span>
                    <span class="col col-2 line">- - -</span>
                    <span class="col col-6">${user.username}</span>
                </div>
                <div class="row">
                    <span class="col col-3 ms-3">이름</span>
                    <span class="col col-2 line">- - -</span>
                    <span class="col col-6">${user.name}</span>
                </div>
                <div class="row">
                    <span class="col col-3 ms-3">닉네임</span>
                    <span class="col col-2 line">- - -</span>
                    <span class="col col-6">${user.nickname}</span>
                </div>
                <div class="row">
                    <span class="col col-3 ms-3">휴대전화</span>
                    <span class="col col-2 line">- - -</span>
                    <span class="col col-6">${user.phone}</span>
                </div>
                <div class="row">
                    <span class="col col-3 ms-3">이메일</span>
                    <span class="col col-2 line">- - -</span>
                    <span class="col col-6">${user.email}</span>
                </div>
                <div class="row">
                    <button class="btn btn-success modifyBtn" type="button" onClick="location.href='/user/modify'">내 정보 관리</button>
                </div>
            </div>

            <div class="tagBox">
                <div class="row">
                </div>
                <div class="row">
	                <button class="btn btn-outline-warning tagBtn" type="button" onClick="location.href='/user/tag'">태그 관리하기</button>
                </div>
            </div>

            <div class="historyBox">
                <c:out value="${history}" />
                <div class="row">
                    <div class="col historyBox2">
                        <c:import url="${request.getContextPath()}/WEB-INF/jsp/history/history.jsp" >
                        </c:import>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-outline-warning historyBtn" type="button" onClick="location.href='/history/list'">히스토리 관리</button>
                </div>
            </div>

            <div class="reservationBox">
                <div class="row">
                </div>
                <div class="row">
                    <button class="btn btn-outline-warning reservationBtn" type="button" onClick="location.href='/user/reservation'">나의 예약 관리</button>
                </div>
            </div>

        </div>

    </div>
</body>
</html>