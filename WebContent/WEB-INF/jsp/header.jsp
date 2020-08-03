<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<%
    UserBean userInfo = (UserBean)session.getAttribute("userInfo");
%>
<%
 String type = userInfo.getType();
%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand">Aso Snack Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">

        <%if(userInfo.getType() == "admin"){ %>
                <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                <a class="nav-link" href="/item/create/input">商品登録</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="/news/list">お知らせ一覧</a>
                </li>
                </ul>

        <% }else if(userInfo.getType() == "user"){ %>
                <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                <a class="nav-link" href="/favorite/list">お気に入り</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="/news/list">お知らせ</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="/user/detail">会員情報</a>
                </li>
                </ul>
        <% } %>

    <form action="/search" method="GET" class="form-inline mt-2 mt-md-0">
    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
    </form>
    <div>
    <nav>
        <a class="p-2 text-muted" href="/cart">カート</a>
        <a class="p-2 text-muted" href="/logout">ログアウト</a>
    </nav>
    </div>
    </div>
</nav>
