<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 07.05.2014
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Доступ</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand " href="/">LecLib</a>
        </div>

        <ul class="nav navbar-nav">
            <li>
                <button type="button" class="btn btn-link navbar-btn" onclick="javascript:history.back()">Вернуться
                    назад
                </button>
            </li>
        </ul>

        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
        <form action="${logoutUrl}" method="post" id="logoutForm">
        </form>

        <c:url value="/lecture/${lecture.id}/delete" var="deleteUrl"/>
        <form action="${deleteUrl}" method="post" id="editForm"></form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <div class="navbar-right ">
               <span style="font-size: 18px; padding-right: 10px">
                Добро пожаловать, ${pageContext.request.userPrincipal.name}!
               </span>
            <button class="btn btn-default" type="submit" onclick="javascript:formSubmit()">Выход</button>
        </div>

    </div>
</nav>

<div class="contentDiv">
    <h1>Редактирование прав доступа</h1>
    <blockquote>
    <p>Отметьте тех пользователей, кому вы хотели бы предоставить доступ к лекции.<br> По умолчанию, при создании лекции доступ раздается всем зарегистрированным на тот момент пользователям</p>
    </blockquote>
    Пользователи:

    <form:form commandName="lecture" method="post" action="/lecture/${lecture.id}/access">
        <div class="checkbox">
            <form:checkboxes path="readers" items="${users}" itemValue="id" itemLabel="username" delimiter="<br/>"/>
        </div>
        <input class="btn btn-success" type="submit" value="Изменить"/>
    </form:form>


</div>
</body>
</html>
