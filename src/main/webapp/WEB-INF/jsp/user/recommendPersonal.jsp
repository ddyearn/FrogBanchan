<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>추천 | TEAM</title>
	<link rel="stylesheet" type="text/css" href="../../css/rcmdMainStyle.css">
</head>
<body>
    <div class="likeListText1">
        땡겨요 리스트
    </div>
    <div class="likeListBox1">
        <div class="likeListBox2">
            <div class="likeListBox3">
                <span class="likeTag">
                    떡볶이
                </span>
                <span class="likeTag">
                    파스타
                </span>
                <span class="likeTag">
                    돈까스
                </span>
            </div>
        </div>
        <p class="likeListText2">
            추천될 확률이 올라간다구리
        </p>
    </div>

    <div class="horizonLine"></div>

    <div class="hateListText1">
        싫어요 리스트
    </div>
    <div class="hateListBox1">
        <div class="hateListBox2">
            <div class="hateListBox3">
                <span class="hateTag">
                    회
                </span>
                <span class="hateTag">
                    피자
                </span>
                <span class="hateTag">
                    냉면
                </span>
            </div>
        </div>
        <p class="hateListText2">
            회원님의 불호 음식 목록은 추천 메뉴에서 제외된다구리
        </p>

    <button type=button onClick="location.href='/recommend/personal/test1'">추천 go</button>
    </div>
</body>
</html>