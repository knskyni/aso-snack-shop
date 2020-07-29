<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.helper.ErrorHelper" %>
<%@ page import="snack.helper.StringHelper" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="snack.bean.ItemBean" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    ItemBean item = (ItemBean)session.getAttribute("createItem");
    if(item == null) item = new ItemBean();
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
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>商品新規追加</h2>
            <p>商品を新しく追加します。</p>
            <hr>
            <form method="POST" enctype="multipart/form-data">
              <div class="form-group">
                <label for="name">商品名</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="タイトル" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(item.getName())) %>">
                <small class="form-text text-muted">必須、64文字以内</small>
                <% if(ErrorHelper.exist(errors, "name")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "name")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="form-group">
                <label for="description">説明文</label>
                <textarea class="form-control" id="description" name="description" rows="7"><%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(item.getDescription())) %></textarea>
                <small class="form-text text-muted">HTML使用可能、4096文字以内</small>
                <% if(ErrorHelper.exist(errors, "description")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "description")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="form-group">
                <label for="image">商品画像</label>
                <input type="file" class="form-control-file" id="image" name="image" accept="image/jpeg, image/png">
                <small class="form-text text-muted">必須</small>
                <% if(ErrorHelper.exist(errors, "image")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "image")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="form-group">
                <label for="price">価格</label>
                <input type="number" name="price" class="form-control col-md-4" id="price" value="<%= item.getPrice() %>">
                <small class="form-text text-muted">必須</small>
                <% if(ErrorHelper.exist(errors, "price")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "price")) { %>
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
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
