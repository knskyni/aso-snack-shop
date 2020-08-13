<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>ログイン | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<%String msg  = (String)request.getAttribute("msg"); %>
<body class="text-center">
    <style>
    html, body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: -webkit-box;
        display: flex;
        -ms-flex-align: center;
        -ms-flex-pack: center;
        -webkit-box-align: center;
        align-items: center;
        -webkit-box-pack: center;
        justify-content: center;
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }

    .form-signin {
        width: 100%;
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin .form-control {
        position: relative;
        box-sizing: border-box;
        height: auto;
        padding: 10px;
        font-size: 16px;
    }

    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    #new{
        margin-top: 15px;
    }

    </style>


    <div class="container">
        <form class="form-signin" action="login" method="POST">
        <p>
            <svg width="100px" height="100px" viewBox="0 0 16 16" class="bi bi-person-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                <path fill-rule="evenodd" d="M2 15v-1c0-1 1-4 6-4s6 3 6 4v1H2zm6-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            </svg>
        </p>

        <p>
        <% if(msg != null) { %>
            <font color="red"><%= msg %></font>
        <% } else { %>
            <font size="3">サインインしてください</font>
        <% } %>
        </p>

        <label for="inputEmail" class="sr-only">メールアドレス</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="メールアドレス" name="email" required autofocus>

        <label for="inputPassword" class="sr-only">パスワード</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="パスワード" name="password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit" >サインイン</button><br>

        <a href="user/input" id="new">新規登録はこちら</a>

        <p class="mt-5 mb-3 text-muted">&copy; 2019 - 2020</p>
        </form>
    </div>
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
