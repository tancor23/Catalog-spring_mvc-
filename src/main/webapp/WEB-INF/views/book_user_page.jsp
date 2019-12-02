<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="/resources/images/shortcut_icon.png">
    <title>Book-User</title>
    <meta charset="utf-8">
</head>
<body>

<div id="container">
    <div class="bookUserForm">
        <h1>The bookEntity '${bookName}' is has: </h1>
        <c:choose>
            <c:when test="${bookUserSize=='0'}">
                <h1>No one</h1>
                <br />
            </c:when>
            <c:otherwise>
                <c:forEach items="${bookUsers}" var="bookUserName">
                    <h1> - '${bookUserName}' userEntity</h1>
                </c:forEach>
                <br />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div>
    <form method="get" action="${pageContext.request.contextPath}/main/">
        <input type="submit" name="back" value="Back"/>
    </form>
</div>

</body>

</html>

