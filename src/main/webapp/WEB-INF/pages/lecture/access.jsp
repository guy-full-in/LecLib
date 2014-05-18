<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 07.05.2014
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Доступ</title>
</head>
<body>

    <form:form commandName="lecture" method="post" action="/lecture/${lecture.id}/access">
        <form:checkboxes path="readers" items="${users}" itemValue="id" itemLabel="username"/><br/>
        <input type="submit"/>
    </form:form>

</body>
</html>
