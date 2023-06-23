<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>메인 화면</title>
	<link rel="stylesheet" type="text/css" href="../../css/mainStyle.css">

	<style>
		::-webkit-scrollbar {
			display: none;
		}
	</style>
</head>

<body>
    <%!
        String getDate(String meetDate) {
            return meetDate.split(" ")[0];
        }
    %>

	<img class="frogLogoIcon" src="../../img/logo.jpg" />

	<div class="recommendBox1">
		<div class="recommendBox2">
			<button class="recommendBtn" type="button" onClick="location.href='/recommend/personal'" >
				<p class="recommendText">메뉴 추천<br/>바로가기</p>
			</button>
		</div>
	</div>

  <div class="teamBox1">
	  <div class="teamBox2">

		<p class="teamBoxText">내가 속한 그룹</p>
        <c:forEach var="team" items="${teamList}" varStatus="status">
            <c:set var="teamId" value="${team.teamId}" />
            <button class="btn btn-outline-success shadow-sm teamBtn" onClick="location.href='/team/main/${teamId}'">
                <img class="frogTeamIcon" src="../../img/frog.jpg" />
                <p class="teamName">${team.name}(${teamMap[teamId]})</p>
            </button>
        </c:forEach>

		<button class="btn btn-outline-success shadow-sm teamBtn createTeamBtn" type="button" onClick="location.href='/team/create'">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="#A6A6A6" class="bi bi-plus-circle" viewBox="0 0 16 16">
              <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
              <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
            </svg>
		</button>
	  </div>
	</div>

  <div class="horizonLine">
  </div>

  <div class="placeListBox">
	<p class="placeListText">
	    <button class="btn btn-dark" type="button" onClick="location.href='/place/list'">가게 둘러보기</button>
	</p>
    <div class="placeBox">
        <div class="row">
            <div class="col placeBox2">
                <ol class="list-group list-group-numbered">
                    <li class="list-group-item d-flex justify-content-between align-items-start placeItemBox">
                        <div class="fw-bold ms-5">가게</div>
                        <div class="fw-bold ms-5">내용</div>
                        <div class="fw-bold ms-5">평가</div>
                    </li>
                    <c:forEach var="place" items="${placeList}" varStatus="status">
                        <li class="list-group-item d-flex justify-content-between align-items-start placeItemBox btn btn-outline-success">
                            <div class="ms-2 mt-1">
                                ${fn:substring(place.address,0,7)}...
                            </div>
                            <span class="badge bg-success rounded-pill mt-1">${place.name}</span>
                            <div class="fw-bold mt-1">
                                ${place.totalScore}
                            </div>
                        </li>
                    </c:forEach>
                </ol>
            </div>
        </div>
    </div>
    <div class="partyListBox">
    <p class="partyListText">
        <button class="btn btn-dark" type="button" onClick="location.href='/party/list'">파티 모집 보기</button>
    </p>
    <div class="partyBox">
        <div class="row">
            <div class="col partyBox2">
            <ol class="list-group list-group-numbered">
                <li class="list-group-item d-flex justify-content-between align-items-start partyItemBox">
                    <div class="fw-bold ms-5">날짜</div>
                    <div class="fw-bold ms-5">내용</div>
                    <div class="fw-bold ms-5">가게</div>
                </li>
                <c:forEach var="party" items="${partyList}" varStatus="status">
                    <c:set value="${party.meetDate}" var="meetDate" />
                    <li class="list-group-item d-flex justify-content-between align-items-start partyItemBox btn btn-outline-success">
                        <div class="ms-2 mt-1">
                            <%= getDate(pageContext.getAttribute("meetDate").toString()) %>
                        </div>
                        <span class="badge bg-success rounded-pill mt-1">${fn:substring(party.content,0,7)}...</span>
                        <div class="fw-bold mt-1">
                            ${fn:substring(party.placeId,0,3)}...
                        </div>
                    </li>
                </c:forEach>
              </ol>
            </div>
        </div>
  </div>


</body>


</html>