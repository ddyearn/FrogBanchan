<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>팀원 관리</title>
	<link rel="stylesheet" type="text/css" href="../../css/team/teamPageStyle.css">
    <script type="text/javascript" src="../../js/teamPage.js"></script>

</head>
<body>
    <div id="recommend" onclick="location.href='/recommend/team'">
        추천하러가기
    </div>

    <div class="circle-container">
        <c:forEach var="member" items="${memberList}" varStatus="status">
            <div id="circle" type="button" class="circle" onclick="showPopup()">${member.nickname}</div>
        </c:forEach>
        <div id="add-button" type="button" class="add-button" onclick="addCircle()">+</div>
    </div>
    
    <div id="popup" class="popup">
        <div class="delete-button">
            <button type="button" onclick="deleteCircle()">삭제</button>
        </div>
    </div>

    <div>
        <button type="button" onclick="history.back()">뒤로가기</button>&nbsp;
        <button type="button" onclick="location.href='/team/update?teamId=${team.teamId}'">팀 정보 수정</button>
    </div>
</body>
</html>
