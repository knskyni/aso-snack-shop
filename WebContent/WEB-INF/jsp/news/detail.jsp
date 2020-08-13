<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ詳細</title>

    <jsp:include page="../common/head.jsp" />
    <style type="text/css">
    table {
        table-layout: fixed;
        width: 100%;
    }

    table td {
        word-wrap: break-word;
    }

    section{
        margin-bottom: 10%;
        margin-top: 10%;
    }
    </style>
</head>
<body>
    <jsp:include page="../header.jsp" />
    <%
        NewsBean newsBean = (NewsBean)request.getAttribute("newsBean");
        UserBean userInfo = (UserBean)session.getAttribute("userInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    %>
    <section>
        <div class="container">
            <h1 class="text-center">お知らせ</h1>
            <div class="card mt-4">
                <div class="card-header">
                    件名: <%= newsBean.getSubject() %>
                    <span class="float-right">更新日: <%= sdf.format(newsBean.getUpdatedAt()) %></span>
                </div>
                <div class="card-body">
                    <%= newsBean.getContent() %>
                </div>
            </div>
        <% if(userInfo != null && userInfo.getType() == "admin") { %>
            <div class="mt-4 text-center">
                <a href="update/input?id=<%= newsBean.getId() %>" class="btn btn-primary">更新</a>
                <a href="delete/confirm?id=<%= newsBean.getId() %>" class="btn btn-danger ml-3">削除</a>
            </div>
        <% } %>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
