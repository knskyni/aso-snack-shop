<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    NewsBean news = (NewsBean)session.getAttribute("deleteNews");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= rootURL %>/css/bootstrap.min.css">
</head>
<body>
    <style>
    .table {
        overflow-wrap: break-word;
        word-wrap: break-word;
        word-break: break-all;
    }

    th {
        word-break: keep-all;
    }
    </style>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>お知らせ削除</h2>
            <p>以下のお知らせを削除します。よろしいですか。</p>
            <hr>
            <table class="table">
                <tbody>
                    <tr>
                        <th scope="row">件名</th>
                        <td><%= StringEscapeUtils.escapeHtml4(news.getSubject()) %></td>
                    </tr>
                    <tr>
                        <th scope="row">内容</th>
                        <td><%= news.getContent() %></td>
                    </tr>
                </tbody>
            </table>
            <form method="POST">
              <button type="submit" class="btn btn-primary float-right">削除</button>
            </form>
            <div class="clearfix"></div>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />
    <!-- JavaScript -->
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
