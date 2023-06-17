<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PartyList</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}
</style>
</head>
<body>
partyList 출력 test <br/>
<table style="width:70%">
	<tr><th>식구 아이디</th><th>모집자</th><th>날짜</th><th>가게 아이디</th><th>내용</th></tr>
	<c:forEach var="party" items="${partyList}" varStatus="status">
		<tr>
			<td>${party.partyId}</td>
			<td>${party.creator}</td>
			<td>${party.meetDate}</td>
			<td>${party.placeId}</td>
			<td>${party.content}</td>
			<td><a href='<c:url value="/party/view"><c:param name="partyId" value="${party.partyId}"/></c:url>'>보기</a></td>
		</tr>
	</c:forEach>
</table>
<a href='<c:url value="/party/create"></c:url>'>파티 생성</a>
</body>
</html>