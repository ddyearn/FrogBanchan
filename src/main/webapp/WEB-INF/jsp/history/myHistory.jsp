<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>히스토리 목록</title>
	<link rel="stylesheet" type="text/css" href="../../css/history/myHistoryStyle.css">
</head>
<body>
    <div class="historyBox1">
        <div class="titleBox">
            나의 히스토리
        </div>
        <div class="historyBox2">
            <div class="historyBox3">
                <c:import url="./history.jsp">
                    <c:param name="historyList" value="${historyList}" />
                </c:import>
            </div>
        </div>

        <div class="horizonLine"></div>

        <div class="btnGroup">
            <button class="btn btn-secondary backBtn me-4" type="button" value="뒤로가기" onclick="location.href='/user/myPage'">뒤로가기</button>
        </div>
    </div>
</body>
</html>