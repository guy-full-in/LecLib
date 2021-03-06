<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 01.05.2014
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Новая лекция</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
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
    <h3>Новая лекция</h3>

    <div class="lecForm">
    <form:form cssClass="form-horizontal" commandName="lecture" method="post" action="/lecture/new">
        <form:errors path="*" cssClass="error" element="div"/>
        <div class="form-group">
            <label class="col-sm-1 control-label" for="title">Название:</label>

            <div class="col-sm-5">
                <form:input cssClass="form-control" id="title" path="title"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label" for="text">Название:</label>

            <div class="col-sm-9 ">
                <form:textarea cssStyle="height: 300px" cssClass="form-control" id="text" path="text"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label" for="category">Категория:</label>
            <div class="col-sm-3">
                <form:select id="category" cssClass="form-control" path="category" items="${categories}" itemValue="id"
                             itemLabel="title" title="title"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label" for="university">Университет:</label>
            <div class="col-sm-3">
                <form:select id="university" cssClass="form-control" path="university" items="${universities}"
                             itemValue="id" itemLabel="shortTitle" title="fullTitle"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Создать</button>
    </form:form>
</div>
</div>
</body>
</html>
