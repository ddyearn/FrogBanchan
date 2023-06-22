<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <%!
        String getDate(String recordedDate) {
            return recordedDate.split(" ")[0];
        }

        String getTime(String recordedDate) {
            String time = recordedDate.split(" ")[1];
            return time.substring(0, 5);
        }

        String getPlaceName(String placeId) {
            return placeId.split("ANDMENU")[0];
        }

        String getMenuName(String placeId) {
            String[] str = placeId.split("ANDMENU");
            if (str.length == 1) {
                return "-";
            } else {
                return str[1];
            }
        }
    %>

    <ol class="list-group list-group-numbered">
        <c:if test="${fn:length(historyList) == 0}">
            <img class="upsetFrogIcon" src="../../img/frog_upset.jpg" />
            <div class="noListText">
                최근 방문한 가게가 없다구리
            </div>
        </c:if>
        <li class="list-group-item d-flex justify-content-between align-items-start historyItemBox">
            <div class="fw-bold ms-5 mt-3">
                방문 날짜
            </div>
            <div class="fw-bold ms-5">
                방문 가게<br/>
                &nbsp;&nbsp;(메뉴)
            </div>
          <span class="badge bg-warning rounded-pill mt-3">평점</span>
        </li>
        <c:forEach var="history" items="${historyList}" varStatus="status">
            <c:set value="${history.recordedDate}" var="recordedDate" />
            <c:set value="${history.placeId}" var="placeId" />
            <li class="list-group-item d-flex justify-content-between align-items-start historyItemBox btn btn-outline-warning"
                onclick="location.href='/history/update?historyId=${history.historyId}'">
                <div class="ms-2 mt-3">
                    <%= getDate(pageContext.getAttribute("recordedDate").toString()) %>&nbsp;
                    <%= getTime(pageContext.getAttribute("recordedDate").toString()) %>
                </div>
                <div class="fw-bold">
                    <%= getPlaceName(pageContext.getAttribute("placeId").toString()) %><br/>
                    <%= getMenuName(pageContext.getAttribute("placeId").toString()) %>
                </div>
              <span class="badge bg-warning rounded-pill mt-3">${history.score}</span>
            </li>
        </c:forEach>
      </ol>

</body>
