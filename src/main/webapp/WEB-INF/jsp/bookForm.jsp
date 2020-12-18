<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>wellcome to list page</title>
</head>
<body>
<table>
    <%--@elvariable id="book" type="Book"--%>
    <c:url var="addBook" value="/addBook" />
    <form:form action="${addBook}" method="POST" modelAttribute="book">

        <c:if test="${book.bookId != 0}">
            <form:hidden path="bookId"/>
            <form:hidden path="bookDetail.bookDetailId"/>
        </c:if>


        <form:label path="name">Name</form:label><br>
        <form:input path="name"/><br>

        <form:label path="author">Author</form:label><br>
        <form:input path="author"/><br>

        <form:label path="bookDetail.isbn">ISBN</form:label><br>
        <form:input path="bookDetail.isbn"/><br>


        <form:label path="bookDetail.price">Price</form:label><br>
        <form:input path="bookDetail.price"/><br>

        <form:label path="bookDetail.numberOfPage">Number Of Page</form:label><br>
        <form:input path="bookDetail.numberOfPage"/><br>

        <form:label path="bookDetail.publishDate">Publish date</form:label><br>
        <form:input path="bookDetail.publishDate" type="date"/><br>

        <form:label path="category.cateId">category</form:label><br>
        <form:select path="category.CateId" items="${cateList}"/><br>

        <input type="submit" save="save">
    </form:form>


</table>
</body>
</html>
