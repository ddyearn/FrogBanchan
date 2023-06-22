<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>식구 모집 정보</title>
	<link rel="stylesheet" type="text/css" href="../../css/party/viewStyle.css">
</head>
<body>
        <div class="titleWrap">
			모집 정보
			<br/>
		</div>
        <table class="tb">
        	<tr class="tr1">
        		<td class="td1">모집자</td>
        		<td><div class="div1">${party.creator}</div></td>
        		<td class="td1">날짜</td>
        		<td><div class="div1">${party.meetDate}</div></td>
        	</tr>
        	<tr class="tr1">
        		<td class="td1">가게</td>
        		<td><div class="div1">${place.name}</div></td>
        		<td class="td1">인원</td>
        		<td><div class="div1">4</div></td>
        	</tr>
        	<tr class="tr1">
        		<td class="td1">내용</td>
        		<td colspan="3" class="td3">${party.content}</td>
        	</tr>
        </table>
        <br/>
         <c:choose>
            <c:when test="${party.creator eq sessionScope.userSession.user.username}">
                <button class="updateButton" onclick="location.href='<c:url value='/party/update'><c:param name='partyId' value='${party.partyId}'/></c:url>'">모집 수정</button>
				<button class="deleteButton" onclick="location.href='<c:url value='/party/delete'><c:param name='partyId' value='${party.partyId}'/></c:url>'">모집 취소</button>
            </c:when>
         </c:choose>
   		<br/>
   		<br/>
   		<hr class="line"/>
   		<div class="titleWrap2">
			신청
			<br/>
		</div>
   		<table class="tb2">
		<c:forEach var="apply" items="${applyList}" varStatus="status">
			<tr class="tr0">
				<td class="td0">${apply.writer}</td>
				<td class="td0">${apply.content}</td>
				<td class="td0">${apply.writtenDate}</td>
				<c:choose>
            		<c:when test="${apply.writer eq sessionScope.userSession.user.username}">
            			<td class="td0"><a href='<c:url value="/apply/delete/${party.partyId}"><c:param name="applyId" value="${apply.applyId}"/></c:url>'>삭제</a></td>
          			</c:when>
          			<c:otherwise>
          				<td class="td0"></td>
          			</c:otherwise> 				
         		</c:choose>
			</tr>
		</c:forEach>
		</table>
   		<form:form action="/apply/create/${party.partyId}" modelAttribute="applyForm" method="post">
			<label for="content"></label>
			<form:input path="apply.content" class="input"/>
			<form:errors path="apply.content" class="error"/>
		
			<input class="createButton" type="submit" value="작성" />
		</form:form>
		<c:choose>
            <c:when test="${party.creator eq sessionScope.userSession.user.username}">
                <button class="acceptButton" onclick="location.href='<c:url value='/party/accept'><c:param name='partyId' value='${party.partyId}'/></c:url>'">수락하기</button>
            </c:when>
       </c:choose>
</body>
</html>