<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.helper.WebHelper" %>
<%
    String rootURL = WebHelper.getRootURL(request);
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>パスワード変更 - 完了 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <div class="text-center">
                <h2 class="text-center">パスワード変更完了</h2>
                <hr>
                <p>
                    パスワードの変更が完了しました。<br>
                    以下のボタンからログインし直してください。
                </p>
                <hr>
                <a href="<%= rootURL %>/login" class="btn btn-primary">ログイン</a>
            </div>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>