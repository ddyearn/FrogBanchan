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
    <title>가게 메뉴 수정</title>
	<link rel="stylesheet" type="text/css" href="../../css/placemenu/placeMenuFormStyle.css">
</head>
<body>
    <div class="menuFormBox1">
        <div class="titleBox">
            가게 메뉴 수정
        </div>
        <div class="menuFormBox2 text-center placemenuForm">
            <form:form modelAttribute="placemenuForm" method="post">
                <div class="row mt-4">
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
                    <button class="btn btn-secondary backBtn me-4" type="button" onclick="history.go(-1)">취소하기</button>
                    <button class="btn btn-success registBtn ms-4" type="submit">수정하기</button>
                </div>
            </form:form>
        </div>

        <div class="horizonLine">
        </div>

        <button class="btn btn-outline-danger deleteBtn" type="button" onclick="location.href='/placemenu/delete?placeMenuId=${placeMenuId}'">삭제하기</button>
    </div>
</body>
</html>