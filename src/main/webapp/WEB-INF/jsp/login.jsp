<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
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
</html>