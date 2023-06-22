<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>가게목록</title>
</head>
<body>
    <br/><br/><br/><br/>
    <c:forEach var="place" items="${placeList}" varStatus="status">
        <div>
            ${place.placeId}&nbsp;
            ${place.name}&nbsp;
            <button type="button" onClick="location.href='/place/view?placeId=${place.placeId}'">가게 정보 조회</button>
            <button type="button" onClick="location.href='/reservation/calendar?placeId=${place.placeId}'">이 가게 예약하러 가기</button>
        </div><br/>
    </c:forEach>
    <br/><br/>
    <button type="button" onClick="history.go(-1)">뒤로가기</button>
</body>
</html>