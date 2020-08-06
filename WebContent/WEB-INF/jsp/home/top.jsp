<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="snack.bean.ItemBean" %>
 <%@ page import="snack.helper.WebHelper" %>
 <%@ page import="org.apache.commons.text.StringEscapeUtils" %>
<%
    String rootURL = WebHelper.getRootURL(request);

    ItemBean item = (ItemBean)session.getAttribute("item");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>トップページ</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<%= rootURL %>/css/bootstrap.min.css">
</head>
<body>
    <section>
        <div class="container">
            <!-- ここにHTMLを書き始める -->
            <div class="col-sm-10">
      <form action="/search-result/">
  <input id="search-input" type="text" name="search-key">
  <input id="search-buttom" class="btn btn-default" type="submit" value="item" method="get">

</form>
</div>
</div>
    </section>
    <table border="1">
  <tr>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
  </tr>
  <tr>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
  <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
 <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
  </tr>
   <tr>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
   <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
  <td width="150"><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>">
   <p><%= StringEscapeUtils.escapeHtml4(item.getName()) %></p><p><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %>></p>
   <button type="button" class="btn btn-default">詳細</button></td>
  </tr>
 </table>
    <!-- JavaScript -->
    <script src="./js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>
