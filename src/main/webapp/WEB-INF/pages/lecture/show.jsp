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
</head>
<body>
<h1>${lecture.title}</h1>
${lecture.category.title} | ${lecture.university.fullTitle}<br/>
<pre>${lecture.text}</pre><br/>
Автор:  ${lecture.author.username} [${lecture.author.email}]<br/>
Создано: ${lecture.createdAt}<br/>
Изменено: ${lecture.updatedAt}<br/>
</body>
</html>
