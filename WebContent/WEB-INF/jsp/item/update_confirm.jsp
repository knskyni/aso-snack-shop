<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    ItemBean item = (ItemBean)session.getAttribute("updateItem");
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
            <h2>商品更新</h2>
            <p>以下の内容で更新します。よろしいですか。</p>
            <hr>
            <table class="table">
                <tbody>
                    <tr>
                        <th scope="row">商品名</th>
                        <td><%= StringEscapeUtils.escapeHtml4(item.getName()) %></td>
                    </tr>
                    <tr>
                        <th scope="row">説明文</th>
                        <td><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %></td>
                    </tr>
                    <tr>
                        <th scope="row">価格</th>
                        <td><%= item.getPrice() %></td>
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
    <!-- JavaScript -->
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
