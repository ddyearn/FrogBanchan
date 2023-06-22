<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
        <div class="hateListBox2">
            <div class="hateListBox3">
                <c:forEach var="tag" items="${hateTagList}" varStatus="status">
                    <span class="btn btn-outline-warning hateTag" id="${tag}">${tag}</span>
                </c:forEach>
            </div>
        </div>
</body>