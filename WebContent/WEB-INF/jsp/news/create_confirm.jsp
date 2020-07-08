<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    NewsBean news = (NewsBean)session.getAttribute("news");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>お知らせ登録</h2>
            <p>以下の内容で登録します。よろしいですか。</p>
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
              <button type="submit" class="btn btn-primary float-right">確認</button>
            </form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="../../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>