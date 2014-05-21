<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 22.04.2014
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<html>
<head>
    <title>Мои лекции</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.tablesorter.min.js"></script>
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


<div id="lectures" style="padding-left: 20px">
    <h2>Мои лекции :</h2>

    <c:choose>
        <c:when test="${empty myLectures}">
            У вас нет написанных лекций.<br/><br/>
        </c:when>
        <c:otherwise>
            <table id="myLectures" class="table table-striped tablesorter">
                <thead class="table-header-group">
                <tr>
                    <th>Название</th>
                    <th>Категория</th>
                    <th>Университет</th>
                    <th>Дата последнего изменения</th>
                </tr>
                </thead>
                <tbody class="table-row-group">
                <c:forEach items="${myLectures}" var="lecture">
                    <tr>
                        <td><a href="/lecture/${lecture.id}/>">${lecture.title}</a></td>
                        <td><a href="/category/${lecture.category.id}" title="${lecture.category.title}"> ${lecture.category.title}</a>
                        </td>
                        <td><a href="/university/${lecture.university.id}" title="${lecture.university.fullTitle}"> ${lecture.university.shortTitle} </a>
                        </td>
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
            У вас нет доступных лекций.
        </c:when>
        <c:otherwise>
            <table id="aveilableLectures" class="table table-striped tablesorter">
                <thead class="table-header-group">
                <tr>
                    <th>Название</th>
                    <th>Автор</th>
                    <th>Категория</th>
                    <th>Университет</th>
                    <th>Дата последнего изменения</th>
                </tr>
                </thead>
                <tbody class="table-row-group">
                <c:forEach items="${otherLectures}" var="lecture">
                    <tr>
                        <td><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></td>
                        <td>${lecture.author.username}</td>
                        <td><a href="/category/${lecture.category.id}" title="${lecture.category.title}"> ${lecture.category.title}</a>
                        </td>
                        <td><a href="/university/${lecture.university.id}" title="${lecture.university.fullTitle}"> ${lecture.university.shortTitle} </a>
                        </td>
                        <td><fmt:formatDate value="${lecture.updatedAt}" pattern="HH.mm dd.MM.yyyy"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>


    <script>
        $(document).ready(function () {
                    $("#myLectures").tablesorter();
                }
        );
        $(document).ready(function () {
                    $("#aveilableLectures").tablesorter();
                }
        );

    </script>
</div>

</body>
</html>
