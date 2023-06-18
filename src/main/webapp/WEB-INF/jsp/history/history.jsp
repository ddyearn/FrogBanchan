<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <%!
        String getDate(String recordedDate) {
            return recordedDate.split(" ")[0];
        }
    %>

    <ol class="list-group list-group-numbered">
        <c:forEach var="history" items="${historyList}" varStatus="status">
            <c:set value="${history.recordedDate}" var="recordedDate" />
            <li class="list-group-item d-flex justify-content-between align-items-start historyItemBox">
                <div class="ms-2 mt-3">
                    <%= getDate(pageContext.getAttribute("recordedDate").toString()) %>
                </div>
                <div class="fw-bold">
                    ${history.placeId} (place이름으로 변경)<br/>
                    ${history.placeMenuId} (menu이름으로 변경)
                </div>
              <span class="badge bg-warning rounded-pill mt-3">${history.score}</span>
            </li>
        </c:forEach>
      </ol>

</body>
