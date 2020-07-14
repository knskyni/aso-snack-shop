<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.helper.ErrorHelper" %>
<% HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報更新ページ</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
        <p>会員情報変更画面</p>
        <form action="update" method="POST">
            名前<br>
            <div class="row">
                <div class="col-sm-6"><input type="text" id ="name-form" class="form-control" name="lastName" placeholder="姓"></div>
                <div class="col-sm-6"><input type="text" id ="name-form" class="form-control" name="firstName" placeholder="名"><br></div>
            </div>
            <% if(ErrorHelper.exist(errors, "lastName")){ %>
                <% for(String message : ErrorHelper.get(errors, "lastName")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>
            <% if(ErrorHelper.exist(errors, "firstName")){ %>
                <% for(String message : ErrorHelper.get(errors, "firstName")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>ふりがな<br>
            <div class="row">
                <div class="col-sm-6"><input type="text" class="form-control" name="lastNameFurigana" placeholder="せい　ふりがな"></div>
                <div class="col-sm-6"> <input type="text" class="form-control" name="firstNameFurigana" placeholder="めい　ふりがな"><br></div>
            </div>
            <% if(ErrorHelper.exist(errors, "lastNameFurigana")){ %>
                <% for(String message : ErrorHelper.get(errors, "lastNameFurigana")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>
            <% if(ErrorHelper.exist(errors, "firstNameFurigana")){ %>
                <% for(String message : ErrorHelper.get(errors, "firstNameFurigana")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>メールアドレス<br>
            <input type="text" class="form-control" name="email" placeholder="メールアドレス"><br>
            <% if(ErrorHelper.exist(errors, "email")){ %>
                <% for(String message : ErrorHelper.get(errors, "email")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>郵便番号<br>
            <input type="text" class="form-control" name="postalNumber" placeholder="郵便番号"><br>
            <% if(ErrorHelper.exist(errors, "postalNumber")){ %>
                <% for(String message : ErrorHelper.get(errors, "postalNumber")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>住所<br>
            <input type="text" class="form-control" name="address" placeholder="住所"><br>
            <% if(ErrorHelper.exist(errors, "address")){ %>
                <% for(String message : ErrorHelper.get(errors, "address")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>電話番号<br>
            <input type="text" class="form-control" name="phoneNumber" placeholder="電話番号"><br>
            <% if(ErrorHelper.exist(errors, "phoneNumber")){ %>
                <% for(String message : ErrorHelper.get(errors, "phoneNumber")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>
            <div class="row">
                <div class="col-sm-6"><button type="button" onclick="location.href='show'" class="btn btn-light" >戻る</button></div>
                <div class="col-sm-6"><button type="submit" class="btn btn-primary">変更</button></div>
            </div>
        </form>
    </div>

    <!-- JavaScript -->
    <script src="../../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>