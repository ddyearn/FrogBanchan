<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가입결과</title>
</head>
<body>
    <div>
        <p>가입 결과</p>
        <br/>
        ${user.username} <br/>
        ${user.password} <br/>
        ${user.name} <br/>
        ${user.nickname} <br/>
        ${user.phone} <br/>
        ${user.email} <br/>
        ${user.residentNo} <br/>
        ${user.address} <br/>
        <br/>
        <a href="/login">go to login</a>
    </div>
</body>
</html>