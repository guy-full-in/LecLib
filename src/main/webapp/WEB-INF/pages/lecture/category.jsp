<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 18.05.2014
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Результаты поиска</title>
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
    </div>
</nav>
<div class="contentDiv">
    <c:choose>
        <c:when test="${empty lectures}">
            Ничего не найдено.
        </c:when>
        <c:otherwise>
            <h3>${category}:</h3>
            <table id="lectures" class="table table-striped">
                <thead class="table-header-group">
                <tr>
                    <th>Название</th>
                    <th>Автор</th>
                    <th>Университет</th>
                    <th>Дата последнего изменения</th>
                </tr>
                </thead>
                <tbody class="table-row-group">
                <c:forEach items="${lectures}" var="lecture">
                    <tr>
                        <td><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></td>
                        <td>${lecture.author.username}</td>
                        <td>${lecture.university.shortTitle}</td>
                        <td><fmt:formatDate value="${lecture.updatedAt}" pattern="HH.mm dd.MM.yyyy"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>

<script>
    $(document).ready(function () {
                $("#lectures").tablesorter();
            }
    );
</script>

</body>
</html>