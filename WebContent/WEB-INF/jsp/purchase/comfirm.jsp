<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=snack.bean.UserBean %>
<%@ page import=snack.bean.ItemBean %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<%
UserBean authInfo = (UserBean)request.getAttribute("userAuth");
int totalPrice = (int)request.getAttribute("totalPrice");
int fee = 350;
%>
<body>
    <jsp:include page="../header.jsp" />
        <div class="container">
            <div class="">
                <h1>注文確認</h1>
                <button type="button" class="btn btn-warning" onclick="location.href='comfirm'">注文を確定する</button>
            </div>
            <div class="">
                <h1>注文内容確認</h1>
                <label></label><%=authInfo.getAddress() %><br>
                //ここに届け日をセットする<br><br>
                <table>
                    <tr>
                        <th><label>商品の小計</label></th><td>\　<%=totalPrice %></td>
                    </tr>
                    <tr>
                        <th><label>配送料</label></th><td>\　<%=fee %></td>
                    </tr>
                    <tr>
                        <th><label>注文合計</label></th><td>\　<%=totalPrice + fee%></td>
                    </tr>
                    <tr>
                        <th><label>割引</label></th><td>\0</td>
                    </tr>
                    <tr>
                        <th><label>ご請求額</label></th><td>\　<%=totalPrice + fee%></td>
                    </tr>
                </table>
            </div>
        </div>
</body>
</html>