<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>PlaceMenuForm</title>
</head>
<body>
<h2>가게메뉴 수정</h2>

<form:form modelAttribute="placemenuForm" method="post">
    <label for="name">이름</label>:
    <form:input path="placeMenu.name"/> <br/>

    <label for="menuId">항목(메뉴)</label>:
    <form:input path="placeMenu.menuId"/> <br/>

    <label for="price">가격</label>:
    <form:input path="placeMenu.price"/> <br/>

    <label for="description">메뉴 설명</label>:
    <form:input path="placeMenu.description"/> <br/>

    <input type="button" value="뒤로가기" onclick="history.back()"/>
    <input type="submit" value="수정하기" />
    <input type="button" value="삭제하기" onclick="location.href='/placemenu/delete?placeMenuId=${placeMenuId}'"/>

</form:form>
</body>
</html>