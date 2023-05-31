<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>PartyUpdateForm</title>
</head>
<body>
<h2>파티 수정</h2>

<form:form modelAttribute="partyForm" method="post">
<label for="creator">모집자</label>: 
<form:input path="party.creator" value="${party.creator}" readonly="true"/> <br/>

<label for="meetDate">날짜</label>: 
<form:input path="party.meetDate"/>
<form:errors path="party.meetDate"/> <br/>

<label for="address">가게</label>: 
<form:input path="party.placeId"/>
<form:errors path="party.placeId"/> <br/>

<label for="content">내용</label>: 
<form:input path="party.content"/>
<form:errors path="party.content"/> <br/>

<input type="submit" value="수정하기" />

</form:form>
</body>
</html>