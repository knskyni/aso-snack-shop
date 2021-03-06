<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="snack.bean.ItemBean" %>
<%
    String rootURL = WebHelper.getRootURL(request);
    List<ItemBean> favItems = (List<ItemBean>)request.getAttribute("favItems");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お気に入り一覧 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>お気に入り一覧</h2>
            <p>お気に入り登録した商品です。</p>
            <hr>
            <% for(ItemBean item : favItems) { %>
            <div class="card">
                <div class="row">
                    <div class="col-md-4 text-center">
                        <img style="max-width: 300px; max-height: 200px;" src="<%= rootURL + "/file/view?name=images/items/" + item.getImagePath() %>">
                    </div>
                    <div class="col-md-8" style="min-height: 1px; padding: 1.25rem;">
                        <h4 class="card-title"><%= item.getName() %></h4>
                        <p class="card-text"><%= item.getDescription() %></p>
                        <a class="btn btn-primary" href="../item/show?id=<%= item.getId() %>">商品ページ</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </section>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
