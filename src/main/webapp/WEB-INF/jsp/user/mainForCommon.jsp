<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>mainForCommon</title>
	<link rel="stylesheet" type="text/css" href="../../css/mainStyle.css">

	<style>
		::-webkit-scrollbar {
			display: none;
		}
	</style>
</head>

<body>
	<img class="frogIcon" src="../../img/logo.png" />

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
                <p class="teamName">${team.name}(${teamMap[teamId]})</p>
            </button>
        </c:forEach>

		<button class="btn btn-outline-success shadow-sm teamBtn" type="button" onClick="location.href='/team/create'">
			<p class="teamCreateBtn">+</p>
		</button>
	  </div>
	</div>

  <div class="horizonLine">
  </div>

  <div class="tagListBox">
	<p class="tagListText">나의 불호 태그</p>
	<!-- history include? -->
  </div>
  <div class="partyListBox">
	<p class="partyListText">파티</p>
	<button type="button" onClick="location.href='/party/list'">파티 모집 보기</button>
  </div>


</body>


</html>