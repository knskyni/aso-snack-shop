<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="snack.bean.PurchaseBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>購入確認 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<%
UserBean authInfo = (UserBean)session.getAttribute("userAuth");
int totalPrice = (int)session.getAttribute("totalPrice");
int fee = 350;
String date = (String)session.getAttribute("date");
%>
<body>
    <jsp:include page="../header.jsp" />
        <div class="container">
            <div class="">
                <h1>注文確認</h1>
                <label>届け先　:</label><%=authInfo.getAddress() %><br>
                <label><%=date %></label><br><br>
                <form method="POST">
                    <input type="submit" class="btn btn-warning" value="注文を確定する">
                </form>
            </div>
            <div class="">
                <h1>注文内容確認</h1>

                <table>
                    <tr>
                        <th><label>商品の小計:</label></th><td>&yen;<%=totalPrice %></td>
                    </tr>
                    <tr>
                        <th><label>配送料:</label></th><td>&yen;<%=fee %></td>
                    </tr>
                    <tr>
                        <th><label>注文合計:</label></th><td>&yen;<%=totalPrice + fee%></td>
                    </tr>
                    <tr>
                        <th><label>割引:</label></th><td>&yen;0</td>
                    </tr>
                    <tr>
                        <th><label>ご請求額:</label></th><td>&yen;<%=totalPrice + fee%></td>
                    </tr>
                </table>
            </div>
        </div>
      <jsp:include page="../footer.jsp" />

      <jsp:include page="../common/javascript.jsp" />
</body>
</html>