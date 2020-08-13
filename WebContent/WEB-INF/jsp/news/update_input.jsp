<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.helper.ErrorHelper" %>
<%@ page import="snack.helper.StringHelper" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    NewsBean news = (NewsBean)session.getAttribute("updateNews");
    if(news == null) news = new NewsBean();
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ更新 - 入力 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>お知らせ更新</h2>
            <p>公開済みのお知らせを更新します。</p>
            <hr>
            <form method="POST">
              <div class="form-group">
                <label for="subject">件名</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="タイトル" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(news.getSubject())) %>">
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
                <textarea class="form-control" id="content" name="content" rows="7"><%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(news.getContent())) %></textarea>
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
            <div class="clearfix"></div>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
