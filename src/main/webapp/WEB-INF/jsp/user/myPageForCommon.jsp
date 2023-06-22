<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                    <div class="col tagBox2">
                        <c:if test="${fn:length(hateTagList) == 0}">
                            <img class="surprisedFrogIcon" src="../../img/frog_surprised.jpg" />
                            <div class="noTagListText">
                                불호 태그가 없다구리 !
                            </div>
                        </c:if>
                        <c:import url="../user/tagList.jsp" >
                        </c:import>
                    </div>
                </div>
                <div class="row">
	                <button class="btn btn-outline-warning tagBtn" type="button" onClick="location.href='/user/tag'">태그 관리하기</button>
                </div>
            </div>

            <div class="historyBox">
                <div class="row">
                    <div class="col historyBox2">
                        <c:import url="../history/history.jsp" >
                        </c:import>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-outline-warning historyBtn" type="button" onClick="location.href='/history/list'">히스토리 관리</button>
                </div>
            </div>

            <div class="reservationBox">
                <div class="row">
                    <div class="col reservationBox2">
                        <c:if test="${fn:length(reservationList) == 0}">
                            <img class="frogFaceIcon" src="../../img/frog.jpg" />
                            <div class="noRsvListText">
                                예약이 없다구리
                            </div>
                        </c:if>
                    <ol class="list-group list-group-numbered">
                        <li class="list-group-item d-flex justify-content-between align-items-start historyItemBox">
                            <div class="fw-bold ms-5">
                                예약 날짜
                            </div>
                            <div class="fw-bold ms-5">
                                가게
                            </div>
                          <span class="badge bg-success rounded-pill">인원</span>
                        </li>
                        <c:forEach var="reservation" items="${reservationList}" varStatus="status">
                            <li class="list-group-item d-flex justify-content-between align-items-start reservationItemBox btn btn-outline-success">
                                <div class="ms-2 mt-1">
                                    ${reservation.reservationDate}
                                </div>
                                <div class="fw-bold mt-1">
                                    ${reservation.placeId}
                                </div>
                              <span class="badge bg-success rounded-pill mt-1">${reservation.seat}</span>
                            </li>
                        </c:forEach>
                      </ol>
                    </div>
                </div>
                <div class="row">
                    <button class="btn btn-outline-success reservationBtn" type="button" onClick="location.href='/user/reservation'">나의 예약 관리</button>
                </div>
            </div>

        </div>

    </div>
</body>
</html>