<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
<h1>${lecture.title}</h1>
${lecture.category.title} | ${lecture.university.fullTitle}<br/>
<pre>${lecture.text}</pre><br/>
Автор:  ${lecture.author.username} [${lecture.author.email}]<br/>
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
                    <td style="text-align: right">
                        <form method="post" action="/lecture/${lecture.id}/comment/delete/${comm.id}">
                            <input type="submit" value="Удалить">
                        </form>
                        <a href="/lecture/${lecture.id}/comment/edit/${comm.id}">Изменить</a></td>
                </tr>
            </table>
        </div>
    </c:forEach>
<br>

<form:form commandName="comment" method="post" action="/lecture/${lecture.id}/comment/new">
    <form:errors path="*" cssClass="error" element="div" />
    <label>Текст:</label><br>
    <form:textarea path="text"/><br>
    <input type="submit"/>
</form:form>
</body>
</html>
