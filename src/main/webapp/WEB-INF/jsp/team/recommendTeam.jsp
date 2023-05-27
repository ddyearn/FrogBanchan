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
    <div class="memberSelectBox memberScroll2">
        <div class="memberCircle">
            <div class="addBadge">
                <button class="badge rounded-pill text-bg-primary">+</button>
            </div>
            <p class="memberCircleText">팀원1</p>
        </div>
        <div class="memberCircle ">
            <div class="addBadge">
                <button class="badge rounded-pill text-bg-primary">+</button>
            </div>
            <p class="memberCircleText">팀원2</p>
        </div>
        <div class="memberCircle">
            <div class="addBadge">
                <button class="badge rounded-pill text-bg-primary">+</button>
            </div>
            <p class="memberCircleText">팀원4</p>
        </div>
        <div class="memberCircle">
            <div class="addBadge">
                <button class="badge rounded-pill text-bg-primary">+</button>
            </div>
            <p class="memberCircleText">팀원5</p>
        </div>
        <div class="memberCircle">
            <div class="addBadge">
                <button class="badge rounded-pill text-bg-primary">+</button>
            </div>
            <p class="memberCircleText">팀원6</p>
        </div>
    </div>

    <div class="memberSelectTextBox">
        <p class="memberSelectText1">팀원 선택</p>
    </div>
    <div class="memberSelectedBox1">
        <div class="memberSelectedBox2">
            <div class="memberCircle">
                <div class="removeBadge">
                    <button class="badge rounded-pill text-bg-danger">X</button>
                </div>
                <p class="memberCircleText">팀원3</p>
            </div>
            <div class="memberCircle">
                <div class="removeBadge">
                    <button class="badge rounded-pill text-bg-danger">X</button>
                </div>
                <p class="memberCircleText">팀원7</p>
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
            현재 선택된 멤버들의 불호 음식 목록은 추천 메뉴에서 제외된다구리
        </p>
    </div>
</body>
</html>