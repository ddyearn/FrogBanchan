<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>팀 생성 결과</title>
</head>
<body>
    <div>
        <p>팀 생성 결과</p>
        <br/>
        ${team.teamId} <br/>
        ${team.name} <br/>
        ${team.address} <br/>
        ${team.creator} <br/>
        <br/>
    </div>
</body>
</html>