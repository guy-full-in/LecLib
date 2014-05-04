<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 22.04.2014
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
    <title></title>
    <meta charset="utf-8">
</head>
<body>
    <h1>Лекции :


    <ul>
    <c:forEach items="${lectures}" var="lecture">
        <li><a href="/lecture/<c:out value="${lecture.id}"/>">${lecture.title}</a></li>
    </c:forEach>
    </ul>

    <a href="/lecture/new">Добавить лекцию</a>
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>
</body>
</html>
