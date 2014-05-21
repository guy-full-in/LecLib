<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>${lecture.title}</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
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
                    <button class="btn btn-success navbar-btn" onclick="location.href='/lecture/${lecture.id}/access'" data-toggle="modal" data-target="#basicModal">
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
        </form>

        <c:url value="/lecture/${lecture.id}/delete" var="deleteUrl"/>
        <form action="${deleteUrl}" method="post" id="deleteForm"></form>

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

<div style="margin-left: 20px; margin-bottom: 50px">

    <div class="lecture">
        <h1>${lecture.title}</h1>
        ${lecture.category.title} | ${lecture.university.fullTitle}<br/>
        <pre>${lecture.text}</pre>
        <br/>
        Автор: ${lecture.author.username} [<a href="mailto:${lecture.author.email}">${lecture.author.email}</a>]<br/>
        Создано: <fmt:formatDate value="${lecture.createdAt}" pattern="HH.mm dd.MM.yyyy"/><br/>
        Изменено: <fmt:formatDate value="${lecture.updatedAt}" pattern="HH.mm dd.MM.yyyy"/><br/>
        Просмотров: ${lecture.reviews}
    </div>

    <hr/>
    <div id="comments" style="width: 400px">
    </div>
    <hr/>

    <div class="form-inline">
        <div id="errors"></div>
        <input id="text" class="form-control" placeholder="Ваш комментарий..."/>
        <button class="btn btn-default" onclick="addComment();">Написать</button>
    </div>



</div>
<script>
    /*<![CDATA[*/
    function loadComments() {
        var url = "/lecture/";
        url += ${lecture.id};
        url += "/comments";
        $.get(url, function (comments) {
            $('#comments').html('');
            if (comments.length == 0) {
                $('#comments').append('У этой лекции пока нет комментариев.');
            } else {
                var username = '${pageContext.request.userPrincipal.name}';
                comments.forEach(function (comment) {

                    var html = '<div class="comm">';
                    if (username == comment.author.username) {
                        html += '<button class="delete" aria-hidden="true" onclick=\"deleteComment(';
                        html += comment.id;
                        html += ');\">&times;</button>';
                    }
                    html += '<div class="commenterAuthor">';
                    html += comment.author.username;
                    html += '</div>';
                    html += '<div class="commentText">' +
                            '<p class="">';
                    html += comment.text;
                    html += '</p>' +
                            '<span class="date sub-text"> at ';
                    var date = new Date(comment.createdAt);
                    html += date.getDay() + '.' + date.getMonth() + '.' + date.getFullYear() + ' ' + date.getHours() + ':' + date.getMinutes();
                    html += '</span></div></div>';
                    $('#comments').append(html);
                });
            }
        })
    }

    function addComment() {
        $('#errors').html('')
        var txt = $('input#text').val();
        if (txt.length < 10) {
            var html = '<div class="error">';
            html += 'Минимальный размер комментария 10 символов';
            html += '</div>';
            $('#errors').html(html);
        } else {
            var url = "/lecture/";
            url += ${lecture.id};
            url += "/comments/new";
            $.post(url, {'text': txt}, function () {
                $('input#text').val("");
                loadComments();
            });
        }
    }

    function deleteComment(id) {
        var url = '/lecture/';
        url += ${lecture.id};
        url += '/comment/';
        url += id;
        url += '/delete';
        $.post(url, function () {
            loadComments();
        })
    }

    $(loadComments());

    /*]]>*/
</script>
</body>
</html>
