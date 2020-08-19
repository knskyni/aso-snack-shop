<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>購入前再認証 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<% String msg  = (String)request.getAttribute("msg");
   String email = (String)request.getAttribute("email");
%>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
    <h1>購入認証</h1>
        <form action="auth" method="POST">
            <p>
                <font color="red">
                <%if(msg != null){%>
                    <%= msg %>
                <%} %>
                </font>
            </p>
            <label>Eメール：<%=email %></label><br>
            <input type="password" class="form-control" name="password" placeholder="パスワード"><br>
            <button type="submit" class="btn btn-warning">購入支払いへ</button>
        </form>
    </div>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>