<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가게 메뉴</title>
    <link rel="stylesheet" type="text/css" href="../../css/placemenu/placeMenuListStyle.css">
</head>
<body>
    <%!
        String getMenuName(String description) {
            return description.split("&AND&")[0];
        }

        String getTagList(String description) {
            return description.split("&AND&")[1];
        }

        String getDescription(String description) {
            String[] str = description.split("&AND&");
            if (str.length == 2) {
                return "-";
            } else {
                return str[2];
            }
        }
    %>
    <div class="menuListBox1">
        <div class="titleBox">
            가게 메뉴
        </div>
        <div class="menuListBox2">
            <div class="menuListBox3 accordion" id="menuListBox3">
                <c:forEach var="placemenu" items="${placemenuList}" varStatus="status">
                    <c:set value="${placemenu.description}" var="description" />
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed row" type="button" data-bs-toggle="collapse" aria-expanded="false" data-bs-target="#${placemenu.placeMenuId}" aria-controls="${placemenu.placeMenuId}">
                                <span class="menu col">${placemenu.name}</span>|
                                <span class="menu col">${placemenu.price}원</span>
                            </button>
                        </h2>
                        <div id="${placemenu.placeMenuId}" class="accordion-collapse collapse" data-bs-parent="#menuListBox3">
                            <div class="accordion-body menuInfoBox">
                                <div class="menuInfo">
                                    <p>분류 : <%= getMenuName(pageContext.getAttribute("description").toString()) %></p>
                                    <p>설명 : <%= getDescription(pageContext.getAttribute("description").toString()) %></p>
                                    <p>태그 : <%= getTagList(pageContext.getAttribute("description").toString()) %></p>
                                </div>
                                <button class="btn btn-outline-success updateBtn" type="button" onclick="location.href='/placemenu/update?placeMenuId=${placemenu.placeMenuId}'">
                                    수정
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="horizonLine"></div>

        <div class="btnGroup">
            <button class="btn btn-secondary backBtn me-4" type="button" value="뒤로가기" onclick="location.href='/place/main'">메인으로</button>
            <button class="btn btn-outline-success createBtn ms-4" type="button" value="추가하기" onclick="location.href='/placemenu/create'">추가하기</button>
        </div>

    </div>


</body>
</html>