<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>wellcome to list page</title>
</head>
<body>
    <a href="<c:url value="/initData" />">inser initial data</a>
    <a href="<c:url value="/addBook" />">Add Book</a>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>author</th>
        <th>ISBN</th>
        <th>Price</th>
        <th>publish Date</th>
        <th>Category</th>
    </tr>
    <c:forEach var="b" items="${books}">
        <tr>
            <td>${b.bookId}</td>
            <td>${b.name}</td>
            <td>${b.author}</td>
            <td>${b.bookDetail.isbn}</td>
            <td>${b.bookDetail.price}</td>
            <td>${b.bookDetail.publishDate}</td>
            <td>${b.category.cateName}</td>
            <td><a href="<c:url value="/edit/${b.bookId}" />">edit</a></td>
            <td><a href="<c:url value="/delete/${b.bookId}" />">delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
