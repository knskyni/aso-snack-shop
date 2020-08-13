<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>会員情報 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
<%
//セッションから値を取得
UserBean user = (UserBean)request.getAttribute("user");
%>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>会員情報</h2>
            <hr>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">項目</th>
                        <th scope="col">内容</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">氏名</th>
                        <td><%= user.getLastName() %> <%= user.getFirstName() %>(<%= user.getLastNameFurigana() %> <%= user.getFirstNameFurigana() %>)</td>
                    </tr>
                    <tr>
                        <th scope="row">メールアドレス</th>
                        <td><%= user.getEmail() %></td>
                    </tr>
                    <tr>
                        <th scope="row">住所</th>
                        <td>〒<%= user.getPostalCode() %><br><%= user.getAddress() %></td>
                    </tr>
                    <tr>
                        <th scope="row">電話番号</th>
                        <td><%= user.getPhoneNumber() %></td>
                    </tr>
                </tbody>
            </table>

            <div class="row">
                <div class="col text-left">
                    <button type="button" onclick="history.back()" class="btn btn-light px-5">戻る</button>
                </div>
                <div class="col text-center">
                    <button type="button" onclick="location.href='delete/confirm'"class="btn btn-danger px-5">退会</button>
                </div>
                <div class="col text-center">
                    <button type="button" onclick="location.href='../account/change-password/input'"class="btn btn-warning px-3">パスワード変更</button>
                </div>
                <div class="col text-right">
                    <button type="button" onclick="location.href='update'"class="btn btn-primary px-5">変更</button>
                </div>
            </div>
            </div>
    </section>
	<jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>