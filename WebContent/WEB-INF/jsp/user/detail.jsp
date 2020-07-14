<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
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
            <form action="confirm" method="POST">
              <div class="row">
  				<div class="form-group col-sm-6">
    				<label for="text4c">名前</label>
    				<%= user.getLastName() %>

  				</div>
  				<div class="form-group col-sm-6">
    				<label for="text4d">　</label>
    				<%= user.getFirstName() %>
  				</div>
  			</div>
  			<div class="row">
  				<div class="form-group col-sm-6">
					<%= user.getLastNameFurigana() %>

  				</div>
  				<div class="form-group col-sm-6">
    				<%= user.getFirstNameFurigana() %>
  				</div>
  			</div>
  			<div class="form-group">
                <label for="subject">メールアドレス</label>
                 <%= user.getEmail() %>
            </div>
            <div class="form-group">
                <label for="subject">パスワード</label>
               <%= user.getPassword() %>

              </div>
				<div class="row">
                   <div class="form-group col-sm-4">
                   <label for="subject">郵便番号</label>
                      <%=user.getPostalCode() %>
                   </div>
                </div>
             <div>
			<div class="form-group">
                <label for="subject">住所</label>
                   <%=user.getAddress() %>
                </div>
              <div class="row">
              <div class="form-group col-sm-4">
                <label for="subject">電話番号</label>
                <%=user.getPhoneNumber() %>
              </div>
              </div>
            <div class="row">
                <div class="col-sm-6"><button type="button" onclick="location.href='input'" class="btn btn-light" >戻る</button></div>
                <div class="col-sm-6"><button type="submit" class="btn btn-primary">登録へ</button></div>
            </div>
            </div>
            </form>
    </section>

    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>