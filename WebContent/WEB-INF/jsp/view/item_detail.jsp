<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    ItemBean item = (ItemBean)session.getAttribute("itemview");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <hr>
            <table class="table">
                <tbody>
                    <tr>
                        <th scope="row">商品名</th>
                        <td><%= StringEscapeUtils.escapeHtml4(item.getName()) %></td>
                    </tr>
                    <tr>
                        <th scope="row">説明文</th>
                        <td><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %></td>
                    </tr>
                    <tr>
                        <th scope="row">画像</th>
                        <td><img width="100%" src="<%= rootURL + "/img/item/" + item.getImagePath() %>"></td>
                    </tr>
                    <tr>
                        <th scope="row">価格</th>
                        <td><%= item.getPrice() %></td>
                    </tr>
                </tbody>
            </table>
            <form method="POST">
              <button type="submit" class="btn btn-primary float-right">カートに入れる</button>
              <button type="submit" class="btn btn-primary float-right">今すぐ購入する</button>
            </form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
