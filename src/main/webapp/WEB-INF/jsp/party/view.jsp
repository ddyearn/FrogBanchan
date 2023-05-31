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
        <a href='<c:url value="/party/delete.do"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 삭제</a>
   		<a href='<c:url value="/party/update.do"><c:param name="partyId" value="${party.partyId}"/></c:url>'>식구 업뎃</a>
   		
    </div>
</body>
</html>