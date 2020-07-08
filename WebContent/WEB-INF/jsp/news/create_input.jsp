<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.helper.ErrorHelper" %>
<%@ page import="snack.helper.StringHelper" %>
<%@ page import="snack.bean.NewsBean" %>

<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    NewsBean news = (NewsBean)session.getAttribute("news");
    if(news == null) news = new NewsBean();
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
            <p>サイト内のお知らせを登録します。</p>
            <hr>
            <form action="" method="POST">
              <div class="form-group">
                <label for="subject">件名</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="タイトル" value="<%= StringHelper.nullToBlank(news.getSubject()) %>">
                <small class="form-text text-muted">必須、32文字以内</small>
                <% if(ErrorHelper.exist(errors, "subject")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "subject")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="form-group">
                <label for="content">内容</label>
                <textarea class="form-control" id="content" name="content" rows="7"><%= StringHelper.nullToBlank(news.getContent()) %></textarea>
                <small class="form-text text-muted">HTML使用可能、4096文字以内</small>
                <% if(ErrorHelper.exist(errors, "content")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "content")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
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
