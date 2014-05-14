<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 01.05.2014
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новая лекция</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div id="create-box">
    <h3>Новая лекция</h3>
    <form:form commandName="lecture" method="post" action="/lecture/new">
        <form:errors path="*" cssClass="error" element="div" />
        <table>
            <tr>
                <td>Название:</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td>Текст:</td>
                <td><form:textarea path="text"/></td>
            </tr>
            <tr>
                <td>Категория:</td>
                <td>
                    <form:select path="category" items="${categories}" itemValue="id" itemLabel="title"/>
                </td>
            </tr>
            <tr>
                <td>Университет:</td>
                <td>
                    <form:select path="university" items="${universities}" itemValue="id" itemLabel="shortTitle"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
