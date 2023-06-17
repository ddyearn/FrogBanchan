<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>팀원 관리</title>
	<link rel="stylesheet" type="text/css" href="../../css/team/teamPageStyle.css">
    <script>
        function showPopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "block";
        }

        function hidePopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "none";
        }

        function deleteCircle() {
            var circle = document.getElementById("circle");
            circle.remove();
            hidePopup();
        }

        function addCircle() {
            var circleContainer = document.getElementById("circle-container");
            var circleCount = circleContainer.childElementCount;
            var circle = document.createElement("div");
            circle.id = "circle";
            circle.className = "circle";
            circle.onclick = showPopup;
            circle.style.left = circleCount * 110 + "px";
            circleContainer.insertBefore(circle, circleContainer.lastElementChild);
        }
    </script>
</head>
<body>
    <div id="recommend" onclick="location.href='/recommend/team'">
        추천하러가기
    </div>

    <div id="circle-container" class="circle-container">
        <c:forEach var="member" items="${memberList}" varStatus="status">
            <div id="circle" class="circle" onclick="showPopup()">${member.nickname}</div>
        </c:forEach>
        <div id="add-button" class="add-button" onclick="addCircle()">+</div>
    </div>
    
    <div id="popup" class="popup">
        <div class="delete-button">
            <button onclick="deleteCircle()">삭제</button>
        </div>
    </div>
</body>
</html>
