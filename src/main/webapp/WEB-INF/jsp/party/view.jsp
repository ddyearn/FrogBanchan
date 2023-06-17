<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식구 정보</title>
<style>
	table, th, td {
	    border: 1px solid black;
	    border-collapse: collapse;
	    text-align: center;
}
</style>
</head>
<body>
    <div>
        <p>식구 정보</p>
        <br/>
        ${party.creator} <br/>
        ${party.meetDate} <br/>
        ${party.placeId} <br/>
        ${party.content} <br/>
        <br/>
        <a href='<c:url value="/party/delete"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 삭제</a>
   		<a href='<c:url value="/party/update"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 업뎃</a>
   		<br/>
   		<br/>
   		<br/>
   		<table style="width:70%">
		<tr><th>신청자</th><th>내용</th><th>작성일자</th></tr>
		<c:forEach var="apply" items="${applyList}" varStatus="status">
			<tr>
				<td>${apply.writer}</td>
				<td>${apply.content}</td>
				<td>${apply.writtenDate}</td>
				<td><a href='<c:url value="/apply/delete"><c:param name="applyId" value="${apply.applyId}"/></c:url>'>삭제</a></td>
			</tr>
		</c:forEach>
		</table>
   		<form:form modelAttribute="applyForm" method="post">
			<label for="content">식구 신청</label>: 
			<form:input path="apply.content"/>
			<form:errors path="apply.content"/>
		
			<input type="submit" value="등록하기" />
		</form:form>
    </div>
</body>
</html>