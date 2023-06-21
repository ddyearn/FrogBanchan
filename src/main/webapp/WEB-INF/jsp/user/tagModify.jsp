<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>mainForCommon</title>
	<link rel="stylesheet" type="text/css" href="../../css/user/tagModifyStyle.css">
    <script type="text/javascript" src="../../js/tagModify.js"></script>
</head>
<body>
    <div class="hateListText1">
		<p>내가 싫어하는 것들</p>
    </div>
    <div class="hateListBox1">
        <div class="hateListBox2">
            <div class="hateListBox3">
                <c:forEach var="tag" items="${hateTagList}" varStatus="status">
                    <span class="hateTag" id="${tag}">${tag}</span>
                </c:forEach>
            </div>
        </div>
        <p class="hateListText2">
            추천에서 제외된다구리
        </p>
    </div>
    <div class="hateAddText1">
        태그 추가
    </div>
    <div class="hateAddBox1">
        <div class="hateAddBox2">
            <div class="hateAddBox3">
                <form id="hateAddForm" action="/user/tag" method="POST">
                    <input type="text" id="hateAddTag" value="" oninput="searchTag()" />
                    <button id="addHateBtn" type="button">추가</button>
                    <button class="btn btn-outline-warning shadow-sm saveBtn" type="submit">
                        태그 저장
                    </button>
                </form>
            </div>
        </div>
    </div>

    <button class="backBtn" type="button" onclick="location.href='/user/main'">뒤로가기</button>

    <div class="searchBox">
        <div class="searchResult" ></div>
    </div>

  </div>
</body>
</html>