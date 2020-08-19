<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>新規会員登録 - 確認 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
<%
//セッションから値を取得
UserBean user = (UserBean)session.getAttribute("user");
%>
    <jsp:include page="../header.jsp" />
    <section>
    <div class="container">
        <h2>会員登録</h2>
        <hr>
        <div class="row border-bottom">
            <label class="col-sm-2 col-form-label text-center border-right py-3">お名前</label>
            <div class="col-sm-10 col-form-label py-3">
                <%= user.getLastName() %> <%= user.getFirstName() %>(<%= user.getLastNameFurigana() %> <%= user.getFirstNameFurigana() %>)
            </div>
        </div>
        <div class="row border-bottom">
            <label class="col-sm-2 col-form-label text-center border-right py-3">メールアドレス</label>
            <div class="col-sm-10 col-form-label py-3">
                <%= user.getEmail() %>
            </div>
        </div>
        <div class="row border-bottom">
            <label class="col-sm-2 col-form-label text-center border-right py-3">郵便番号</label>
            <div class="col-sm-10 col-form-label py-3">
                〒<%= user.getPostalCode() %><br>
                <%= user.getAddress() %>
            </div>
        </div>
        <div class="row">
            <label class="col-sm-2 col-form-label text-center border-right py-3">電話番号</label>
            <div class="col-sm-10 col-form-label py-3">
                <%= user.getPhoneNumber() %>
            </div>
        </div>
        <form action="confirm" method="POST">
            <div class="text-center">
                <button type="button" onclick="location.href='input'" class="btn btn-light mr-4" >修正する</button>
                <button type="submit" class="btn btn-primary">登録する</button>
            </div>
        </form>
    </section>
    <jsp:include page="../footer.jsp" />
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
