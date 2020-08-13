<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.helper.ErrorHelper" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container mb-5">
            <h2>パスワード変更</h2>
            <p>新しいパスワードに変更します。</p>
            <hr>
            <% if(ErrorHelper.exist(errors, "errors")) { %>
            <div class="alert alert-danger" role="alert">
                <ul class="m-0">
                <% for(String message : ErrorHelper.get(errors, "errors")) { %>
                    <li><%= message %></li>
                <% } %>
                </ul>
            </div>
            <% } %>
            <form method="POST">
              <div class="form-group row">
                <label for="old_password" class="col-sm-2 col-form-label">変更前</label>
                <div class="col-sm-10">
                  <input type="password" name="old_password" class="form-control" id="old_password" placeholder="Password">
                </div>
              </div>
              <div class="form-group row">
                <label for="new_password" class="col-sm-2 col-form-label">変更後</label>
                <div class="col-sm-10">
                  <input type="password" name="new_password" class="form-control" id="new_password" placeholder="Password">
                </div>
              </div>
              <div class="form-group row">
                <label for="new_password_confirm" class="col-sm-2 col-form-label">変更後（確認用）</label>
                <div class="col-sm-10">
                  <input type="password" name="new_password_confirm" class="form-control" id="new_password_confirm" placeholder="Password">
                </div>
              </div>
              <div class="text-center">
                <button class="btn btn-secondary" onclick="history.back()">戻る</button>
                <button class="btn btn-primary ml-4" type="submit">修正する</button>
              </div>
            </form>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>