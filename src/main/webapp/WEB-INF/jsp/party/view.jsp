<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>식구 정보</title>
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
        
        <table style="width:70%">
		<tr><th>신청자</th><th>내용</th><th></th></tr>
		<c:forEach var="apply" items="${applyList}" varStatus="status">
			<tr>
				<td>${apply.writer}</td>
				<td>${apply.content}</td>
				<td><a href='<c:url value="/apply/delete"><c:param name="applyId" value="${apply.applyId}"/></c:url>'>삭제</a></td>
			</tr>
		</c:forEach>
	</table>
        <a href='<c:url value="/party/delete"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 삭제</a>
   		<a href='<c:url value="/party/update"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 업뎃</a>
   		
    </div>
</body>
</html>