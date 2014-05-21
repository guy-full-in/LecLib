<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Registration Page</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<div>
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
        </div>
    </nav>
    <h3 align="center">Регистрация</h3><br>
    <form:form cssClass="form-horizontal" method="POST" commandName="user" action="/registr">
        <form:errors path="*" cssClass="error" element="div" />
        <div class="form-group">
            <label for="username" class="col-sm-5 control-label">Логин</label>

            <div class="col-sm-2">
                <input type="text" class="form-control" id="username" name="username" placeholder="Логин">
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-5 control-label">E-mail</label>

            <div class="col-sm-2">
                <input type="text" class="form-control" id="email" name="email" placeholder="E-mail">
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-5 control-label">Пароль</label>

            <div class="col-sm-2">
                <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword" style="margin-top: -10px" class="col-sm-5 control-label">Подтверждение<br> пароля</label>

            <div class="col-sm-2">
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Подтверждения пароля">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-4">
                <button type="submit" class="btn btn-success">Регистрация</button>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>


        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>User Name :</td>--%>
                <%--<td><form:input path="username" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Email :</td>--%>
                <%--<td><form:input path="email" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Password :</td>--%>
                <%--<td><form:password path="password" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Confirm password :</td>--%>
                <%--<td><form:password path="confirmPassword" /></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan="2"><input type="submit" /></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    </form:form>
</div>
</body>
</html>