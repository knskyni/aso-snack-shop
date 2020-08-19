<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    ItemBean item = (ItemBean)session.getAttribute("deleteItem");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>商品削除 - 確認 | Sweeter</title>

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
            <h2>商品削除</h2>
            <p>以下の商品を削除します。よろしいですか。</p>
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
                        <th scope="row">画像</th>
                        <td><img class="img-fluid" style="max-height: 200px;" src="<%= rootURL + "/file/view?name=images/items/" + item.getImagePath() %>"></td>
                    </tr>
                    <tr>
                        <th scope="row">価格</th>
                        <td><%= item.getPrice() %></td>
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

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
