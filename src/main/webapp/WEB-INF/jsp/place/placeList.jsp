<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>가게목록</title>
	<link rel="stylesheet" type="text/css" href="../css/place/placeListStyle.css">
</head>
<body>
    <div class="titleBox">
        가게목록
    </div>
    <div class="placeFormBox1">
        <div class="placeFormBox2 text-center">
            <c:forEach var="place" items="${placeList}" varStatus="status">
            <div class="row">
                <div class="col col-3">
                    ${place.placeId}
                </div>
                <div class="inputBox col col-5">
                    ${place.name}
                </div>
                <div class="col col-2">
                    <button class="btn btn-outline-success" type="button" onClick="location.href='/place/view?placeId=${place.placeId}'">가게 정보 조회</button>
                </div>
            </div>
            </c:forEach>

            </br>
        </div>
    </div>
    <div class="btnGroup">
        <button class="btn btn-secondary backBtn type="button" onClick="history.go(-1)">뒤로가기</button>
    </div>
</body>
</html>