<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../frogTop.jsp"%>

<!DOCTYPE html>
<html>
<head>
    <title>${team.name} 팀페이지</title>
	<link rel="stylesheet" type="text/css" href="../../css/team/teamPageStyle.css">
    <script type="text/javascript" src="../../js/teamPage.js"></script>

</head>
<body>
    <%!
        String getGender(String residentNo) {
            if ((Integer.parseInt(residentNo) % 10) % 2 == 0) {
                return "성별 : 여";
            } else {
                return "성별 : 남";
            }
        }
    %>

	<div class="recommendBox1">
		<div class="recommendBox2">
			<button class="recommendBtn" type="button" onClick="location.href='/recommend/team'" >
				<p class="recommendText">팀 메뉴<br/>추천받기</p>
			</button>
		</div>
	</div>

    <div class="teamNameBox">
        <p>< ${team.name} ></p>
    </div>

    <div class="circle-container">
        <c:forEach var="member" items="${memberList}" varStatus="status">
            <div class="btn-group">
                <div type="button" class="btn btn-outline-light dropdown-toggle circle" data-bs-toggle="dropdown" aria-expanded="false">
                    <p class="circleText">${member.nickname}</p>
                </div>

                <ul class="dropdown-menu">
                    <li class="memberInfoBox"><button class="btn dropdown-item">이름 : ${member.name}</button></li>
                    <c:set value="${member.residentNo}" var="residentNo" />
                    <li><button class="btn dropdown-item"><%= getGender(pageContext.getAttribute("residentNo").toString()) %></button></li>
                    <li class="memberInfoBox"><button class="btn dropdown-item">이메일 : ${member.email}</button></li>
                    <c:if test="${team.creator eq sessionScope.userSession.user.username}">
                        <li><hr class="dropdown-divider"></li>
                        <li>
                            <div class="d-flex justify-content-center dropdown-item">
                                <button class="btn btn-outline-danger" type="button" onclick="location.href='/team/deleteTeamMember?username=${member.username}'">팀원 삭제</button>
                            </div>
                        </li>
                    </c:if>
                </ul>
            </div>
        </c:forEach>
        <button class="btn btn-outline-dark add-button" type="button"
            data-bs-toggle="modal" data-bs-target="#addMemberModal" data-bs-whatever="@mdo">
            <p class="circleText">+</p>
        </button>
    </div>

    <div class="blockBox">
    </div>

    <div class="teamAddressBox">
        <p>- ${team.address} -</p>
    </div>

    <div class="btnBox">
        <c:choose>
            <c:when test="${team.creator eq sessionScope.userSession.user.username}">
                <div class="deleteTeamBtn">
                    <button class="btn btn-danger" type="button" onclick="checkDelete('/team/delete?teamId=${team.teamId}')">팀 삭제하기</button>
                </div>
                <div class="updateTeamBtn">
                    <button class="btn btn-warning" type="button" onclick="location.href='/team/update?teamId=${team.teamId}'">팀 정보 수정</button>
                </div>
            </c:when>
            <c:otherwise>
                <div class="quitTeamBtn">
                    <button class="btn btn-danger" type="button" onclick="location.href='/team/quitTeamMember?teamId=${team.teamId}&username=${sessionScope.userSession.user.username}'">팀 나가기</button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="backBtn">
        <button class="btn btn-secondary" type="button" onclick="location.href='/user/main'">뒤로가기</button>
    </div>


    <div class="modal fade" id="addMemberModal" tabindex="-1" aria-labelledby="addMemberModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5 addMemberBox" id="addMemberModalLabel">새로운 팀원</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/team/addTeamMember?teamId=${team.teamId}" method="POST">
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label">아이디</label>
                            <input type="text" class="form-control" name="username">
                        </div>
                        <div class="mb-3">
                            <label for="message-text" class="col-form-label">이메일</label>
                            <input type="text" class="form-control" name="email">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                            <button type="submit" class="btn btn-primary">추가</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
