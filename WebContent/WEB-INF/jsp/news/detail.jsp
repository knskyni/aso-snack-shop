<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.bean.UserBean" %>
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
    %>
    <section>
        <div class="container">
            <h1 align="center">お知らせ</h1>
            <p><a href="home" class="btn btn-primary">HOME</a></p>
            <table class="table table-bordered">
                <tr>
                    <th><%= newsBean.getUpdatedAt() %></th>
                </tr>
                <tr>
                    <td><%= newsBean.getSubject() %></td>
                </tr>
                <tr>
                    <td><%= newsBean.getContent() %></td>
                </tr>
            </table>
            <div class="row">
                <div class="col-8">
                    <a href="list" class="btn btn-light">戻る</a>
                </div>
            <% if(userInfo != null && userInfo.getType() == "admin") { %>
                <div class="col-2" align="right">
                    <a href="update/input?id=<%= newsBean.getId() %>" class="btn btn-primary">更新</a>
                </div>
                <div class="col-2" align="right">
                    <a href="delete/confirm?id=<%= newsBean.getId() %>" class="btn btn-primary">削除</a>
                </div>
            <% } %>
            </div>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
