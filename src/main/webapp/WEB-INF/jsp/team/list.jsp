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
teamList 출력 test <br/>
<table style="width:70%">
	<tr><th>팀 아이디</th><th>팀명</th><th>주소</th><th>팀장</th></tr>
	<c:forEach var="team" items="${teamList}" varStatus="status">
		<tr>
			<td>${team.teamId}</td>
			<td>${team.name}</td>
			<td>${team.address}</td>
			<td>${team.creator}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>