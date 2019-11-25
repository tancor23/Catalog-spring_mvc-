<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <title>Create User</title>
    <meta charset="utf-8">
</head>
<body>

<div id="container">
    <div class="createUserForm">
        <form method="post" action="${pageContext.request.contextPath}/user/update">
            <input type="hidden" name="userId" value="${requestScope.userId}"/>
            First name: <label><input type="text" name="firstName" required/></label> Previous value: ${requestScope.firstName}<br>
            Last name: <label><input type="text" name="lastName" required/></label> Previous value: ${requestScope.lastName}<br>
            <input type="submit" value="Update">
        </form>
    </div>
</div>
<div>
    <form method="get" action="${pageContext.request.contextPath}/start">
        <input type="submit" name="back" value="Back"/>
    </form>
</div>
</body>

</html>

