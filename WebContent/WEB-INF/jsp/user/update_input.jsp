<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="snack.helper.ErrorHelper" %>
<%@ page import="snack.bean.UserBean" %>
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    UserBean updateUserInfo = (UserBean)session.getAttribute("updateUserInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更 | Sweeter</title>
<jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
        <p>会員情報変更画面</p>
        <form action="update" method="POST">
            名前<br>
            <div class="row">
                <div class="col-sm-6"><input type="text" id ="name-form" class="form-control" name="lastName" placeholder="姓" value="<%= updateUserInfo.getLastName() %>"></div>
                <div class="col-sm-6"><input type="text" id ="name-form" class="form-control" name="firstName" placeholder="名" value="<%= updateUserInfo.getFirstName() %>"><br></div>
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
                <div class="col-sm-6"><input type="text" class="form-control" name="lastNameFurigana" placeholder="せい　ふりがな" value="<%= updateUserInfo.getLastNameFurigana() %>"></div>
                <div class="col-sm-6"> <input type="text" class="form-control" name="firstNameFurigana" placeholder="めい　ふりがな" value="<%= updateUserInfo.getFirstNameFurigana() %>"><br></div>
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
            <input type="text" class="form-control" name="email" placeholder="メールアドレス" value="<%= updateUserInfo.getEmail() %>"><br>
            <% if(ErrorHelper.exist(errors, "email")){ %>
                <% for(String message : ErrorHelper.get(errors, "email")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>郵便番号<br>
            <input type="text" class="form-control" name="postalNumber" placeholder="郵便番号" value="<%= updateUserInfo.getPostalCode() %>"><br>
            <% if(ErrorHelper.exist(errors, "postalNumber")){ %>
                <% for(String message : ErrorHelper.get(errors, "postalNumber")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>住所<br>
            <input type="text" class="form-control" name="address" placeholder="住所" value="<%= updateUserInfo.getAddress() %>"><br>
            <% if(ErrorHelper.exist(errors, "address")){ %>
                <% for(String message : ErrorHelper.get(errors, "address")) { %>
                    <font color="red"> <%= message %></font><br>
                <% } %>
            <% } %>

            <br>電話番号<br>
            <input type="text" class="form-control" name="phoneNumber" placeholder="電話番号" value="<%= updateUserInfo.getPhoneNumber() %>"><br>
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

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>