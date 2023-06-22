<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>가게 메뉴 등록</title>
	<link rel="stylesheet" type="text/css" href="../../css/placemenu/placeMenuFormStyle.css">
    <script type="text/javascript" src="../../js/placeMenuForm.js"></script>
</head>
<body>
    <div class="menuFormBox1">
        <div class="titleBox">
            가게 메뉴 등록
        </div>
        <div class="menuFormBox2 text-center placeForm">
            <form:form modelAttribute="placemenuForm" method="post">
                <div class="row">
                    <label for="name" class="col col-3">이름</label>
                    <div class="inputBox col col-5">
                        <form:input path="placeMenu.name" id="name" class="input" autofocus="true" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="menuId" class="col col-3">항목(메뉴)</label>
                    <div class="inputBox col col-5">
                        <form:input path="placeMenu.menuId" id="menuId" class="input" readonly="true" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col col-3">
                        <button class="ms-4 btn btn-success" type="button" onclick="searchMenu()">메뉴 검색</button>
                    </div>
                    <div class="inputBox col col-5">
                        <input id="search" name="search" class="input" placeholder="메뉴를 검색하세요" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="price" class="col col-3">가격</label>
                    <div class="inputBox col col-5">
                        <form:input path="placeMenu.price" id="price" class="input" />
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label for="description" class="col col-3">메뉴 설명</label>
                    <div class="inputBox col col-5">
                        <form:textarea path="placeMenu.description" id="description" class="input" rows="3" />
                    </div>
                </div>
                <br/>

                </br>
                <div class="btnGroup">
                    <button class="btn btn-secondary backBtn" type="button" onclick="history.go(-1)">취소하기</button>
                    <button class="btn btn-light resetBtn" type="reset">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-counterclockwise" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"/>
                            <path d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"/>
                        </svg>
                    </button>
                    <button class="btn btn-success registBtn" type="submit" onclick="return checkExistMenu();">등록하기</button>
                </div>
            </form:form>
        </div>

        <div class="horizonLine">
        </div>
    </div>
</body>
</html>