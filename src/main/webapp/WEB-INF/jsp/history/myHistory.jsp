<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>히스토리</title>
	<link rel="stylesheet" type="text/css" href="../../css/history/myHistoryStyle.css">
</head>
<body>
    <div class="testBox">
        historyList 출력 test <br/>
        <table style="width:70%">
            <tr><th>날짜</th><th>가게 이름</th><th>별점</th></tr>
            <c:forEach var="history" items="${historyList}" varStatus="status">
                <tr>
                    <td>${history.recordedDate}</td>
                    <td>${history.placeId}</td>
                    <td>${history.score}</td>
                    <td><a href='<c:url value="/history/update"><c:param name="historyId" value="${history.historyId}"/></c:url>'>수정</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="historyBox">
        <c:import url="./history.jsp">
        </c:import>
    </div>
</body>
</html>