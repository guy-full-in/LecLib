package org.apache.jsp.WEB_002dINF.pages.lecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_var_value_nobody.release();
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>\r\n");
      out.write("    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("            <a class=\"navbar-brand \" href=\"/\">LecLib</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <ul class=\"nav navbar-nav\">\r\n");
      out.write("            <li>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-link navbar-btn\" onclick=\"javascript:history.back()\">Вернуться\r\n");
      out.write("                    назад\r\n");
      out.write("                </button>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${logoutUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\" id=\"logoutForm\">\r\n");
      out.write("            <input type=\"hidden\"\r\n");
      out.write("                   name=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${_csrf.parameterName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${_csrf.token}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_url_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deleteUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\" id=\"editForm\"></form>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function formSubmit() {\r\n");
      out.write("                document.getElementById(\"logoutForm\").submit();\r\n");
      out.write("            }\r\n");
      out.write("            function editFormSubmit() {\r\n");
      out.write("                document.getElementById(\"editForm\").submit();\r\n");
      out.write("            }\r\n");
      out.write("            function deleteFormSubmit() {\r\n");
      out.write("                document.getElementById(\"deleteForm\").submit();\r\n");
      out.write("            }\r\n");
      out.write("            function accessFormSubmit() {\r\n");
      out.write("                document.getElementById(\"accessForm\").submit();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"navbar-right \">\r\n");
      out.write("               <span style=\"font-size: 18px; padding-right: 10px\">\r\n");
      out.write("                Добро пожаловать, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.userPrincipal.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("!\r\n");
      out.write("               </span>\r\n");
      out.write("            <button class=\"btn btn-default\" type=\"submit\" onclick=\"javascript:formSubmit()\">Выход</button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin-left: 20px; margin-bottom: 50px\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"lecture\">\r\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.category.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" | ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.university.fullTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br/>\r\n");
      out.write("        <pre>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.text}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</pre>\r\n");
      out.write("        <br/>\r\n");
      out.write("        Автор: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.author.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" [<a href=\"mailto:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.author.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.author.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>]<br/>\r\n");
      out.write("        Создано: ");
      if (_jspx_meth_fmt_formatDate_0(_jspx_page_context))
        return;
      out.write("<br/>\r\n");
      out.write("        Изменено: ");
      if (_jspx_meth_fmt_formatDate_1(_jspx_page_context))
        return;
      out.write("<br/>\r\n");
      out.write("        Просмотров: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.reviews}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <hr/>\r\n");
      out.write("    <div id=\"comments\" style=\"width: 400px\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <hr/>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"form-inline\">\r\n");
      out.write("        <div id=\"errors\"></div>\r\n");
      out.write("        <input id=\"text\" class=\"form-control\" placeholder=\"Ваш комментарий...\"/>\r\n");
      out.write("        <button class=\"btn btn-default\" onclick=\"addComment();\">Написать</button>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("    /*<![CDATA[*/\r\n");
      out.write("    function loadComments() {\r\n");
      out.write("        var url = \"/lecture/\";\r\n");
      out.write("        url += ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("        url += \"/comments\";\r\n");
      out.write("        $.get(url, function (comments) {\r\n");
      out.write("            $('#comments').html('');\r\n");
      out.write("            if (comments.length == 0) {\r\n");
      out.write("                $('#comments').append('У этой лекции пока нет комментариев.');\r\n");
      out.write("            } else {\r\n");
      out.write("                var username = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.userPrincipal.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("                comments.forEach(function (comment) {\r\n");
      out.write("\r\n");
      out.write("                    var html = '<div class=\"comm\">';\r\n");
      out.write("                    if (username == comment.author.username) {\r\n");
      out.write("                        html += '<button class=\"delete\" aria-hidden=\"true\" onclick=\\\"deleteComment(';\r\n");
      out.write("                        html += comment.id;\r\n");
      out.write("                        html += ');\\\">&times;</button>';\r\n");
      out.write("                    }\r\n");
      out.write("                    html += '<div class=\"commenterAuthor\">';\r\n");
      out.write("                    html += comment.author.username;\r\n");
      out.write("                    html += '</div>';\r\n");
      out.write("                    html += '<div class=\"commentText\">' +\r\n");
      out.write("                            '<p class=\"\">';\r\n");
      out.write("                    html += comment.text;\r\n");
      out.write("                    html += '</p>' +\r\n");
      out.write("                            '<span class=\"date sub-text\"> at ';\r\n");
      out.write("                    var date = new Date(comment.createdAt);\r\n");
      out.write("                    html += date.getDay() + '.' + date.getMonth() + '.' + date.getFullYear() + ' ' + date.getHours() + ':' + date.getMinutes();\r\n");
      out.write("                    html += '</span></div></div>';\r\n");
      out.write("                    $('#comments').append(html);\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function addComment() {\r\n");
      out.write("        $('#errors').html('')\r\n");
      out.write("        var txt = $('input#text').val();\r\n");
      out.write("        if (txt.length < 10) {\r\n");
      out.write("            var html = '<div class=\"error\">';\r\n");
      out.write("            html += 'Минимальный размер комментария 10 символов';\r\n");
      out.write("            html += '</div>';\r\n");
      out.write("            $('#errors').html(html);\r\n");
      out.write("        } else {\r\n");
      out.write("            var url = \"/lecture/\";\r\n");
      out.write("            url += ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("            url += \"/comments/new\";\r\n");
      out.write("            $.post(url, {'text': txt}, function () {\r\n");
      out.write("                $('input#text').val(\"\");\r\n");
      out.write("                loadComments();\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function deleteComment(id) {\r\n");
      out.write("        var url = '/lecture/';\r\n");
      out.write("        url += ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("        url += '/comment/';\r\n");
      out.write("        url += id;\r\n");
      out.write("        url += '/delete';\r\n");
      out.write("        $.post(url, function () {\r\n");
      out.write("            loadComments();\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    $(loadComments());\r\n");
      out.write("\r\n");
      out.write("    /*]]>*/\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.userPrincipal.name == lecture.author.username}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <li style=\"margin-right: 10px\">\r\n");
        out.write("                    <button class=\"btn btn-primary navbar-btn\" onclick=\"location.href='/lecture/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/edit'\">\r\n");
        out.write("                        Редактировать\r\n");
        out.write("                    </button>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li style=\"margin-right: 10px\">\r\n");
        out.write("                    <button class=\"btn btn-success navbar-btn\" onclick=\"location.href='/lecture/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/access'\" data-toggle=\"modal\" data-target=\"#basicModal\">\r\n");
        out.write("                        Доступ\r\n");
        out.write("                    </button>\r\n");
        out.write("                </li>\r\n");
        out.write("                <li style=\"margin-right: 10px\">\r\n");
        out.write("                    <button class=\"btn btn-danger navbar-btn\" type=\"submit\" onclick=\"javascript:deleteFormSubmit()\">\r\n");
        out.write("                        Удалить\r\n");
        out.write("                    </button>\r\n");
        out.write("                </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/j_spring_security_logout");
    _jspx_th_c_url_0.setVar("logoutUrl");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_url_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent(null);
    _jspx_th_c_url_1.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("/lecture/${lecture.id}/delete", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_url_1.setVar("deleteUrl");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_var_value_nobody.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent(null);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.createdAt}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("HH.mm dd.MM.yyyy");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_1.setParent(null);
    _jspx_th_fmt_formatDate_1.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lecture.updatedAt}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_1.setPattern("HH.mm dd.MM.yyyy");
    int _jspx_eval_fmt_formatDate_1 = _jspx_th_fmt_formatDate_1.doStartTag();
    if (_jspx_th_fmt_formatDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_1);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_1);
    return false;
  }
}
