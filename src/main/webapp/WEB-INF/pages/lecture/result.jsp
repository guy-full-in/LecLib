<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 18.05.2014
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результаты поиска</title>
</head>
<body>
    <ul>
        <c:forEach var="lecture" items="${lectures}">
            <li><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
