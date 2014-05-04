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
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        #create-box {
            width: 400px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
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
                    <form:select path="category">
                        <c:forEach var="category" items="${categories}" >
                            <form:option value="${category}" label="${category.key}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Университет:</td>
                <td>
                    <form:select path="university">
                        <c:forEach var="university" items="${universities}" >
                            <form:option value="${university.value}" label="${university.key}"/>
                        </c:forEach>
                    </form:select>

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
