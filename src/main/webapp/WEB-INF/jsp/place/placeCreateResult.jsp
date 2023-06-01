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
        ${place.placeId} <br/>
        ${place.password} <br/>
        ${place.name} <br/>
        ${place.address} <br/>
        <br/>
        <a href="/login">go to login</a>
    </div>
</body>
</html>