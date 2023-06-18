<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/team/teamFormStyle.css">
    <title>TeamForm</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
        $(document).ready(function() {
            $(".error").click(function() {
                $(this).hide();
                $(this).siblings(".input").focus();
            });
        });
    </script>
</head>
<body>
    <div class="mainbox">
      <hr class="line" />
      <div class="page">
        <div class="titleWrap">
           팀 수정
          <br/>
        </div>
        		<form:form modelAttribute="teamForm" method="post">
        		<div class="contentWrap">
	          	<label for="teamId" class="inputTitle">팀 아이디</label>
	          		<div class="line2">- - - - -  - - -</div>
		         	<div class="readonly">
		           	<form:input path="team.teamId" class="readonlyInput" value="${team.teamId}" readonly="true"/><br/>
		         	</div>
	          	<label for="name" class="inputTitle">팀명</label>
	          		<div class="line2">- - - - -  - - -</div>
		         	<div class="inputWrap">
		           	<form:input path="team.name" class="input"/>
		           	<form:errors path="team.name" class="error"/><br/>
		         	</div>
		       <label for="address" class="inputTitle">주소</label>
		       		<div class="line2">- - - - - - - -</div>
		         	<div class="inputWrap">
		           	<form:input path="team.address" class="input"/>
		           	<form:errors path="team.address" class="error"/><br/>
		         	</div>
		        <label for="creator" class="inputTitle">팀장</label>
		        	<div class="line2">- - - - - - - -</div>
		         	<div class="readonly">
		           	<form:input path="team.creator" class="readonlyInput" value="${team.creator}" readonly="true"/><br/>
		         	</div>
        		</div>
        		<div class="bttnWrapper">
                	<button class="backButton" type="button" onclick="history.go(-1)">뒤로가기</button>
                	&emsp;
                	<button class="createButton" type="submit">수정하기</button>
                </div>
	       </form:form>
        </div>
      </div>
</body>
</html>