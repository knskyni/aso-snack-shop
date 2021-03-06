<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    NewsBean news = (NewsBean)session.getAttribute("updateNews");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ更新 - 確認 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
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
            <h2>お知らせ更新</h2>
            <p>以下の内容で更新します。よろしいですか。</p>
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
            <div class="clearfix"></div>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
