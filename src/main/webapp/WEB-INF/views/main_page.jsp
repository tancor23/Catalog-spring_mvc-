<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <title>ITRex Group. Servlets. Catalog</title>
    <meta charset="UTF-8">
</head>
<body>

<div id="container">

    <div id="menu">
        <div class="menuUserAction">
        </div>
    </div>

    <div id="userTable">
        <h2>Users</h2>
        <table title="Users" border="1">
            <tr>
                <th>First Name</th>
                <th>Second Name</th>
                <th>Was created at</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach items="${userEntities}" var="userEntity">
                <tr>
                    <td class="first_name">${userEntity.firstName}</td>
                    <td class="last_name">${userEntity.lastName}</td>
                    <td class="created_at">${userEntity.createdAt}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/userEntity/delete">
                            <input type="hidden" name="userId" value="${userEntity.id}"/>
                            <input type="submit" name="delete" value="Delete"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/userEntity/update_page">
                            <input type="hidden" name="userId" value="${userEntity.id}"/>
                            <input type="hidden" name="firstName" value="${userEntity.firstName}"/>
                            <input type="hidden" name="lastName" value="${userEntity.lastName}"/>
                            <input type="submit" name="update" value="Update"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/user_book/user_info">
                            <input type="hidden" name="userId" value="${userEntity.id}"/>
                            <input type="submit" name="bookEntities" value="Books"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form method="get" action="${pageContext.request.contextPath}/userEntity/">
            <input type="submit" name="createUser" value="Create New User"/>
        </form>
    </div>

    <div id="bookTable">
        <h2>Books</h2>
        <table border="1" title="Books">
            <tr>
                <th>Name of Book</th>
                <th>Name of Author</th>
                <th>Count of Page</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach items="${bookEntities}" var="bookEntity">
                <tr>
                    <td class="book_name">${bookEntity.name}</td>
                    <td class="author_name">${bookEntity.author}</td>
                    <td class="count_of_page">${bookEntity.page}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/bookEntity/delete">
                            <input type="hidden" name="bookId" value="${bookEntity.id}"/>
                            <input type="submit" name="delete" value="Delete"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/bookEntity/update_page">
                            <input type="hidden" name="bookId" value="${bookEntity.id}"/>
                            <input type="hidden" name="bookName" value="${bookEntity.name}"/>
                            <input type="hidden" name="authorName" value="${bookEntity.author}"/>
                            <input type="hidden" name="countOfPage" value="${bookEntity.page}"/>
                            <input type="submit" name="update" value="Update"/>
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/user_book/book_info">
                            <input type="hidden" name="bookId" value="${bookEntity.id}"/>
                            <input type="submit" name="userEntities" value="Users"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form method="get" action="${pageContext.request.contextPath}/bookEntity/">
            <input type="submit" name="createBook" value="Create New Book"/>
        </form>
    </div>

    <div id="UserBookMappingContainer">
        <br>
        <form method="get" action="${pageContext.request.contextPath}/user_book/add_mapping">
            <input type="submit" name="createUser" value="Add User-Book Mapping"/>
        </form>
    </div>
</div>
</body>

</html>

