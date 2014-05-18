<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 04.05.2014
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${lecture.title}</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
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
            <c:if test="${pageContext.request.userPrincipal.name == lecture.author.username}">
                <li style="margin-right: 10px">
                    <button class="btn btn-primary navbar-btn" onclick="location.href='/lecture/${lecture.id}/edit'">
                        Редактировать
                    </button>
                </li>
                <li style="margin-right: 10px">
                    <button class="btn btn-success navbar-btn" onclick="location.href='/lecture/${lecture.id}/access'">
                        Доступ
                    </button>
                </li>
                <li style="margin-right: 10px">
                    <button class="btn btn-danger navbar-btn" type="submit" onclick="javascript:deleteFormSubmit()">
                        Удалить
                    </button>
                </li>
            </c:if>
        </ul>

        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>

        <c:url value="/lecture/${lecture.id}/delete" var="deleteUrl"/>
        <form action="${deleteUrl}" method="post" id="editForm"></form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
            function editFormSubmit() {
                document.getElementById("editForm").submit();
            }
            function deleteFormSubmit() {
                document.getElementById("deleteForm").submit();
            }
            function accessFormSubmit() {
                document.getElementById("accessForm").submit();
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

<div style="margin-left: 20px">
    <h1>${lecture.title}</h1>
    ${lecture.category.title} | ${lecture.university.fullTitle}<br/>
    <pre style="width: 80%">${lecture.text}</pre>
    <br/>
    Автор: ${lecture.author.username} [${lecture.author.email}]<br/>
    Создано: ${lecture.createdAt}<br/>
    Изменено: ${lecture.updatedAt}<br/>
    Просмотров: ${lecture.reviews}

    <br/><br/>

    <c:forEach var="comm" items="${comments}">
        <div style="border: 1px solid #000; width: 300px; margin-top: 5px; padding-left: 10px">
            <p>${comm.author.username}:<br>
                    ${comm.text}</p>
            <table style="border-spacing: 0; width: 100%">
                <tr>
                    <td>${comm.createdAt}</td>
                    <c:if test="${pageContext.request.userPrincipal.name == comm.author.username}">
                        <td style="text-align: right">
                            <form method="post" action="/lecture/${lecture.id}/comment/${comm.id}/delete">
                                <input type="submit" value="Удалить">
                            </form>
                            <a href="/lecture/${lecture.id}/comment/${comm.id}/edit">Изменить</a>
                        </td>
                    </c:if>
                </tr>
            </table>
        </div>
    </c:forEach>
    <br>

    <form:form commandName="comment" method="post" action="/lecture/${lecture.id}/comment/new">
        <form:errors path="*" cssClass="error" element="div"/>
        <label>Текст:</label><br>
        <form:textarea path="text"/><br>
        <input type="submit"/>
    </form:form>

</div>

<%--<div>--%>
<%--<div id="comments">--%>

<%--</div>--%>
<%--</div>--%>

<%--<script>--%>
<%--/*<![CDATA[*/--%>
<%--$(function(){--%>
<%--var url =/*[["|/lecture/${lecture.id}/comments|"]]*/ "/lecture/${lecture.id}/comments";--%>
<%--$.get(url, function(comments){--%>
<%--comments.forEach(function(comment){--%>
<%--var html = '<div><span>';--%>
<%--html += comment.author.username;--%>
<%--html += ':</span><br /><span>';--%>
<%--html += comment.text;--%>
<%--html +='</span></div>';--%>
<%--$('#comments').append(html);--%>
<%--});--%>
<%--})--%>
<%--});--%>
<%--/*}}>*/--%>
<%--</script>--%>
</body>
</html>
