<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入認証画面</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<%String msg  = (String)request.getAttribute("msg"); %>
</head>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
    <h1>購入認証</h1>
        <form action="auth" method="POST">
        <p><font color="red"><%if(msg != null){%>

                                <%=msg %>

                             <%} %>
            </font></p>
            <input type="text" class="form-control" name="email" placeholder="メールアドレス"><br>
            <input type="password" class="form-control" name="password" placeholder="パスワード"><br>
            <button type="submit" class="btn btn-warning">購入支払いへ</button>
        </form>
    </div>
</body>
</html>