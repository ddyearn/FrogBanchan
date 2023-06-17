<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
placemenuList 출력 test <br/>
<table style="width:70%">
    <tr><th>메뉴이름</th><th>가격</th></tr>
    <c:forEach var="placemenu" items="${placemenuList}" varStatus="status">
        <tr>
            <td>${placemenu.name}</td>
            <td>${placemenu.price}</td>
            <td><a href='<c:url value="/placemenu/update"><c:param name="placeMenuId" value="${placemenu.placeMenuId}"/></c:url>'>수정</a></td>
        </tr>
    </c:forEach>
</table>
<button value="뒤로가기" onclick="history.back()">뒤로가기</button>
<button value="추가하기" onclick="location.href='/placemenu/create'">추가하기</button>
</body>
</html>