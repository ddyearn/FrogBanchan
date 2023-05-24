<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>login</title>
</head>
<body>
    <p>login</p>
    <div>
        <form action='<c:url value="/user/login"/>' method="POST">
            <c:if test="${!empty loginForwardAction}">
                <input type="hidden" name="forwardAction"
                    value='<c:url value="${loginForwardAction}"/>' />
            </c:if>
            Username: <input type="text" name="username" size="20" value="" />
            Password: <input type="password" name="password" size="20" value="" />
            <button>login</button>
        </form>
    </div>
</body>
<div class="mainbox">
      <hr class="line" />
      <div class="page">
        <div class="logo">
          <img class="mainimg" src="../img/logo.png" />
        </div>
        <div class="titleWrap">
          <hr class="line2"/>
          「LOGIN」
          <br/>
        </div>
  
        <div class="contentWrap">
          <div class="inputTitle">아이디</div>
          <div class="inputWrap">
            <input class="input"
              placeholder="아이디를 입력하구리"
              value={id}
            />
          </div>
          
          <div class="inputTitle">비밀번호</div>
          <div class="inputWrap">
            <input type="password"
              class="input"
              placeholder="비밀번호를 입력하구리"
              value={pw}
            />
          </div>
        </div>
        <div class="bttnWrapper">
          <button onClick={onClickConfirmButton} class="loginButton">로그인</button>
          &emsp;
          <button class="joinButton">회원가입</button>
        </div>
      </div>
    </div>
</html>