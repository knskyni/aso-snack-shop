<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>
<%
    String rootURL = WebHelper.getRootURL(request);

	List<ItemBean> items = (List<ItemBean>)request.getAttribute("itemBean");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>トップページ</title>
    <!-- CSS -->
    <link rel="stylesheet" href="<%= rootURL %>/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <!-- ここにHTMLを書き始める -->
            <div class="row">
                <form action="search" method="GET" class="form-inline w-100">
                    <div class="col-9 col-md-11 pr-0">
                        <input class="form-control w-100" type="text" name="word" placeholder="商品名で検索" aria-label="Search">
                    </div>
                    <div class="col-3 col-md-1">
                        <button class="btn btn-primary w-100" type="submit">検索</button>
                    </div>
                </form>
            </div>
            <hr>
        <% for(int i = 0; i < items.size(); i++) { %>
            <% if(i % 4 == 0) { %>
            <div class="row">
            <% } %>
                <div class="col-md-3">
                    <div class="card h-100">
                      <div class="text-center d-flex align-items-center justify-content-center" style="height: 150px;">
                        <img style="max-height: 150px; max-width: 100%;" src="<%= rootURL + "/img/item/" + items.get(i).getImagePath() %>" alt="Card image cap">
                      </div>
                      <div class="card-body">
                        <h5 class="card-title"><%= items.get(i).getName() %></h5>
                        <p class="card-text"><%= items.get(i).getDescription() %></p>
                        <a href="item/show?id=<%=items.get(i).getId() %>" class="btn btn-primary">商品ページ</a>
                      </div>
                    </div>
                </div>
            <% if(i % 4 == 3 || i == items.size()) { %>
            </div>
            <% } %>
            <% if(i % 4 == 3) { %>
            <hr>
            <% } %>
        <% } %>

        </div>
    </section>
    <!-- JavaScript -->
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
