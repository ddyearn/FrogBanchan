<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <title>login</title>
</head>
<body>
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
        	<form action='<c:url value="/user/login"/>' method="POST">
        		<div class="contentWrap">
          	  	<c:if test="${!empty loginForwardAction}">
                <input type="hidden" name="forwardAction"
                    value='<c:url value="${loginForwardAction}"/>' />
              	</c:if>
	          	<div class="inputTitle">아이디</div>
		         	<div class="inputWrap">
		           	<input type="text" class="input" name="username" 
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
	          <button class="loginButton" onClick={}>로그인</button>
	          &emsp;
	          <button class="joinButton" onClick={}>회원가입</button>
	        </div>
	       </form>
        </div>
      </div>
    </div>
</body>
</html>