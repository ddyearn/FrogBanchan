<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <title>login</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <c:if test="${!empty errorMsg}">
        <div class="alert alert-warning alert-dismissible fade show errorMessageWrap" role="alert">
          <div class="d-flex">
            <div>
              <strong>${errorMsg}</strong>
            </div>
            <button type="button" class="btn-close" data-dismiss="alert" aria-label="Close"></button>
          </div>
        </div>
    </c:if>

    <div class="mainbox">
      <hr class="line" />
      <div class="page">
        <div class="logo">
          <img class="mainimg" src="../../img/logo.png" />
        </div>
        <div class="titleWrap">
          <hr class="line2"/>
          「LOGIN」
          <br/>
        </div>

        <div>
        	<form action='<c:url value="/login"/>' method="POST">
        		<div class="contentWrap">
          	  	<c:if test="${!empty loginForwardAction}">
                <input type="hidden" name="forwardAction"
                    value='<c:url value="${loginForwardAction}"/>' />
              	</c:if>
	          	<div class="inputTitle">아이디</div>
		         	<div class="inputWrap">
		           	<input type="text" class="input" name="id"
		             		placeholder="아이디를 입력하구리"
		            	 	value=""
		           	/>
		         	</div>
	          	<div class="inputTitle">비밀번호</div>
		          	<div class="inputWrap">
		           	<input type="password"
		              	class="input"
		              	name="password"
		              	placeholder="비밀번호를 입력하구리"
		              	value=""
		            />
		          	</div>
        		</div>
                <div class="bttnWrapper">
                  <button class="loginButton" type="submit" onClick={}>로그인</button>
                  &emsp;
                  <button class="joinButton" type="button" onClick="location.href='/user/register'">회원가입</button>
                </div>
	       </form>
        </div>
      </div>
    </div>
</body>
</html>