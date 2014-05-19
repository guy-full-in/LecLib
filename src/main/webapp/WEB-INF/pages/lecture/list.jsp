<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 22.04.2014
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<html>
<head>
    <title>Мои лекции</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">

        <div style="margin-top: 5px">
            <a class="navbar-brand" href="/">LecLib</a>
        </div>

        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <div class="navbar-right">
               <span style="font-size: 18px; padding-right: 10px">
                Добро пожаловать, ${pageContext.request.userPrincipal.name}!
               </span>
            <button class="btn btn-default" type="submit" onclick="javascript:formSubmit()">Выход</button>
        </div>

        <form action="/lecture/search" method="get" lass="navbar-form navbar-left" role="search">
            <div class="form-group">
                <div class="col-xs-3">
                    <input name="title" type="text" class="form-control" placeholder="Поиск лекции по заголовку...">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Поиск</button>
        </form>
    </div>
</nav>


<div style="padding-left: 20px">
    <h2>Мои лекции :</h2>

    <c:choose>
        <c:when test="${empty myLectures}">
            У вас нет написанных лекций<br/><br/>
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead class="table-header-group">
                <tr>
                    <td>Название</td>
                    <td>Категория</td>
                    <td>Университет</td>
                    <td>Дата последнего изменения</td>
                </tr>
                </thead>
                <tbody class="table-row-group">
                <c:forEach items="${myLectures}" var="lecture">
                    <tr>
                        <td><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></td>
                        <td>${lecture.category.title}</td>
                        <td>${lecture.university.shortTitle}</td>
                        <td><fmt:formatDate value="${lecture.updatedAt}" pattern="HH.mm dd.MM.yyyy"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

    <button class="btn btn-primary" onclick="location.href='/lecture/new'">Добавить лекцию</button>

    <h2>Доступные лекции:</h2>

    <c:choose>
        <c:when test="${empty otherLectures}">
            У вас нет доступных лекций
        </c:when>
        <c:otherwise>
            <table class="table table-striped">
                <thead class="table-header-group">
                <tr>
                    <td>Название</td>
                    <td>Автор</td>
                    <td>Категория</td>
                    <td>Университет</td>
                    <td>Дата последнего изменения</td>
                </tr>
                </thead>
                <tbody class="table-row-group">
                <c:forEach items="${otherLectures}" var="lecture">
                    <tr>
                        <td><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></td>
                        <td>${lecture.author.username}</td>
                        <td>${lecture.category.title}</td>
                        <td>${lecture.university.shortTitle}</td>
                        <td><fmt:formatDate value="${lecture.updatedAt}" pattern="HH.mm dd.MM.yyyy"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
