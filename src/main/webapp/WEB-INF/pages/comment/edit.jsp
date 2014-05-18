<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 06.05.2014
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование поста</title>
</head>
<body>
    <form:form commandName="comment" method="post" action="/lecture/${comment.lecture.id}/comment/${comment.id}/edit">
        <form:hidden path="id"/>
        <form:errors path="*" cssClass="error" element="div" />
        <label>Текст:</label><br>
        <form:textarea path="text"/><br>
        <input type="submit"/>
    </form:form>
</body>
</html>
