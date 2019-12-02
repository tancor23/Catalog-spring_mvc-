<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="/resources/images/shortcut_icon.png">
    <title>Create User</title>
    <meta charset="utf-8">
</head>
<body>

<div id="container">
    <div class="createUserForm">
        <form method="post" action="${pageContext.request.contextPath}/userEntity/create">
            First name: <label><input type="text" name="firstName" required/></label><br>
            Last name: <label><input type="text" name="lastName" required/></label><br>
            <input type="submit" value="Add">
        </form>
    </div>
</div>
<br>
<div>
    <form method="get" action="${pageContext.request.contextPath}/main/">
        <input type="submit" name="back" value="Back"/>
    </form>
</div>
</body>

</html>

