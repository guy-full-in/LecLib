<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Registration Page</title>
    <meta charset="utf-8">
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

        #registr-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<div id="registr-box">
    <h3>Registration</h3>
    <form:form method="POST" commandName="user" action="/registr">
        <form:errors path="*" cssClass="error" element="div" />
        <table>
            <tr>
                <td>User Name :</td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><form:password path="password" /></td>
            </tr>
            <tr>
                <td>Confirm password :</td>
                <td><form:password path="confirmPassword" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" /></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>