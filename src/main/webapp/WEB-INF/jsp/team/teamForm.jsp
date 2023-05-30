<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>TeamForm</title>
</head>
<body>
<h2>팀 생성</h2>

<form:form modelAttribute="teamForm" method="post">
<label for="teamId">팀아이디</label>: 
<form:input path="team.teamId" value="${team.teamId}" readonly="true"/> <br/>

<label for="name">팀명</label>: 
<form:input path="team.name"/>
<form:errors path="team.name"/> <br/>

<label for="address">주소</label>: 
<form:input path="team.address"/>
<form:errors path="team.address"/> <br/>

<label for="creator">팀장</label>: 
<form:input path="team.creator" value="${team.creator}" readonly="true"/> <br/>

<input type="submit" value="생성하기" />

</form:form>
</body>
</html>