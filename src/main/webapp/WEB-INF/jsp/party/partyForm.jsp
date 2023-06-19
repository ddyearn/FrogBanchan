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
    <link rel="stylesheet" type="text/css" href="../../../css/party/formStyle.css">
	<title>PartyForm</title>
</head>
<body>
	<div class="mainbox">
      <hr class="line" />
      <div class="page">
        <div class="titleWrap">
			식구 모집
			<br/>
		</div>
			<form:form modelAttribute="partyForm" method="post">
			<div class="contentWrap">
			<label for="creator" class="inputTitle">모집자</label>
			<div class="line2">- - - - -  - - -</div>
		    <div class="readonly">
			<form:input path="party.creator" class="readonlyInput" value="${party.creator}" readonly="true"/> <br/>
			</div>
			<label for="meetDate" class="inputTitle">날짜</label>
			<div class="line2">- - - - -  - - -</div>
			<div class="inputWrap">
			<form:input path="party.meetDate" class="input"/>
			<form:errors path="party.meetDate" class="error"/> <br/>
			</div>
			<label for="address" class="inputTitle">가게</label>
			<div class="line2">- - - - - - - -</div>
		    <div class="inputWrap">
			<form:input path="party.placeId" class="input"/>
			<form:errors path="party.placeId" class="error"/> <br/>
			</div>
			<label for="content" class="inputTitle">내용</label>
			<div class="contentWrap2">
			<form:textarea path="party.content" cols="400" rows="3" class="content"/>
			<form:errors path="party.content" class="errorContent"/> <br/>
			</div>
			</div>
			<div class="bttnWrapper">
                	<button class="backButton" type="button" onclick="location.href ='/party/list'">뒤로가기</button>
                	&emsp;
                	<button class="createButton" type="submit">등록하기</button>
            </div>
          </form:form>
        </div>
      </div>
</body>
</html>