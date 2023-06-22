<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/history/historyFormStyle.css">
    <title>historyForm</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $(".error").click(function() {
                $(this).hide();
                $(this).siblings(".input").focus();
            });
        });
    </script>
</head>
<body>
<div class="mainbox">
    <hr class="line" />
    <div class="page">
        <form:form modelAttribute="historyForm" method="post">
            <div class="titleWrap">${history.placeId}</div> <!--장소 아이디 -> 장소이름으로 바꾸기-->
            <div class="contentWrap">
                <div>의 음식은 어떠셨나구리? 별점을 남겨주시구리~!</div>
                <label for="score">별점</label>:
                <form:input path="history.score" value="${history.score}" readonly="false"/> <br/>
                <div class="starpoint_wrap">
                    <div class="starpoint_box">
                        <label for="starpoint_1" class="label_star" title="0.5"><span class="blind">0.5점</span></label>
                        <label for="starpoint_2" class="label_star" title="1"><span class="blind">1점</span></label>
                        <label for="starpoint_3" class="label_star" title="1.5"><span class="blind">1.5점</span></label>
                        <label for="starpoint_4" class="label_star" title="2"><span class="blind">2점</span></label>
                        <label for="starpoint_5" class="label_star" title="2.5"><span class="blind">2.5점</span></label>
                        <label for="starpoint_6" class="label_star" title="3"><span class="blind">3점</span></label>
                        <label for="starpoint_7" class="label_star" title="3.5"><span class="blind">3.5점</span></label>
                        <label for="starpoint_8" class="label_star" title="4"><span class="blind">4점</span></label>
                        <label for="starpoint_9" class="label_star" title="4.5"><span class="blind">4.5점</span></label>
                        <label for="starpoint_10" class="label_star" title="5"><span class="blind">5점</span></label>
                        <input type="radio" name="starpoint" id="starpoint_1" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_2" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_3" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_4" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_5" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_6" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_7" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_8" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_9" class="star_radio">
                        <input type="radio" name="starpoint" id="starpoint_10" class="star_radio">
                        <span class="starpoint_bg"></span>
                    </div>
                </div>

                <div>무슨 메뉴를 먹었는지 알려주시구리~!</div>

                <form:label path="history.placeMenuId">메뉴</form:label>:
                <c:forEach var="placeMenu" items="${placeMenuList}" varStatus="status">
                <label class="btn btn-outline-success form-check">
                    <form:radiobutton path="history.placeMenuId" name="history.placeMenuId" value="${placeMenu.placeMenuId}" label="${placeMenu.name}" class="btn-check"  autocomplete="off"/>
                </label>
                            <%--                    <form:label path="history.placeMenuId" class="" for="${placeMenu.placeMenuId}">${placeMenu.name}</form:label>id="${placeMenu.placeMenuId}"--%>
                </c:forEach>
<%--                <form:input path="history.placeMenuId" value="${history.placeMenuId}" readonly="false" type="hidden" id="${history.placeMenuId}" name="${history.placeMenuId}"/>--%>



                <br/>
            </div>
            <div class="bttnWrapper">
                <!--폼 입력받는 부분에서는 history.back이나 history.go(-1) 동작 이상 있을 수 있음-->
                <button class="backButton" type="button" onclick="location.href ='/history/list'">뒤로가기</button>
                <button class="createButton" type="submit">저장하기</button>
                <button class="deleteButton" type="button" onclick="location.href='/placemenu/delete?placeMenuId=${placeMenuId}'">삭제하기</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>