<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>추천 | User</title>
	<link rel="stylesheet" type="text/css" href="../../css/user/rcmdPersonalStyle.css">
    <script type="text/javascript" src="../../js/rcmdPersonal.js"></script>
</head>
<body>
    <div class="likeListText1">
        땡겨요 리스트
    </div>
    <div class="likeListBox1">
        <div class="likeListBox2">
            <div class="likeListBox3">
            </div>
        </div>
        <p class="likeListText2">
            추천될 확률이 올라간다구리
        </p>
    </div>
    <div class="likeAddText1">
        태그 추가
    </div>
    <div class="likeAddBox1">
        <div class="likeAddBox2">
            <div class="likeAddBox3">
                <form id="likeAddForm">
                    <input type="text" style="display:none;" />
                    <input type="text" name="likeAddTag" value="" />
                    <button id="addLikeBtn" type="button">추가</button>
                </form>
            </div>
        </div>
    </div>

    <div class="horizonLine"></div>

    <div class="hateListText1">
        싫어요 리스트
    </div>
    <div class="hateListBox1">
        <div class="hateListBox2">
            <div class="hateListBox3">
                <c:forEach var="tag" items="${hateList}" varStatus="status">
                    <span class="hateTag">
                        ${tag}
                    </span>
                </c:forEach>
            </div>
        </div>
        <p class="hateListText2">
            회원님의 불호 음식 목록은 추천 메뉴에서 제외된다구리
        </p>
        <div class="hateAddText1">
            태그 추가
        </div>
        <div class="hateAddBox1">
            <div class="hateAddBox2">
                <div class="hateAddBox3">
                    <form id="hateAddForm">
                        <input type="text" style="display:none;" />
                        <input type="text" name="hateAddTag" value="" />
                        <button id="addHateBtn" type="button">추가</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="recommendBox">
        <form id="recommendForm" action="<c:url value='/recommend/personal/test1' />" method="POST">
            <c:forEach var="tag" items="${hateList}" varStatus="status">
                <input type="hidden" name="hateTags" value="${tag}" />
            </c:forEach>
            <button type="submit" >추천 go</button>
        </form>
    </div>
</body>
</html>