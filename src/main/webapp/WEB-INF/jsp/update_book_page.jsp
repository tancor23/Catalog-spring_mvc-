<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <title>Create Book</title>
    <meta charset="utf-8">
</head>
<body>

<div id="container">
    <div class="createBookForm">
        <form method="post" action="${pageContext.request.contextPath}/book/update">
            <input type="hidden" name="bookId" value="${requestScope.bookId}"/>
            First name: <label><input type="text" name="bookName" required/></label> Previous value: ${requestScope.bookName}<br>
            Last name: <label><input type="text" name="authorName" required/></label> Previous value: ${requestScope.authorName}<br>
            Last name: <label><input type="text" name="countOfPage" required/></label> Previous value: ${requestScope.countOfPage}<br>
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

