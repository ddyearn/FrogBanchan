<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TeamList</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>
<body>
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
</body>
</html>