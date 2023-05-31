<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>팀 정보</title>
</head>
<body>
    <div>
        <p>팀 정보</p>
        <br/>
        ${team.teamId} <br/>
        ${team.name} <br/>
        ${team.address} <br/>
        ${team.creator} <br/>
        <br/>
        <a href='<c:url value="/team/delete.do"><c:param name="teamId" value="${team.teamId}"/></c:url>'>팀 삭제</a>
   		<a href='<c:url value="/team/update.do"><c:param name="teamId" value="${team.teamId}"/></c:url>'>팀 업뎃</a>
   		
    </div>
</body>
</html>