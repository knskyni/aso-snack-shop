<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>管理者用ログインページ | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
    <style type="text/css">
    section{
        margin-bottom: 10%;
        margin-top: 10%;
    }
    </style>
</head>
<body>
    <%
        String errMsg = (String)request.getAttribute("msg");
    %>
    <section>
        <div class="container">
            <form method="POST" id="check">
                <p>メールアドレス</p>
                <div class="form-group">
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <p><input type="email" id="inputEmail" name="email" placeholder="メールアドレス" class="form-control" required autofocus></p>
                </div>

                <p>パスワード</p>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only">Password</label>
                    <p><input type="password" id="inputPassword" name="password" placeholder="パスワード" class="form-control" required></p>
                </div>

                <p class="text-danger" id="msg">
                <%if(errMsg != null){ %>
                    <%= errMsg %>
                <%} %>
                </p>

                <p align="center"><input type="submit" value="ログイン" name="btn" class="btn btn-primary" style="width: 300px;"></p>
            </form>
        </div>
    </section>

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
