<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
    String rootURL = WebHelper.getRootURL(request);
    UserBean userInfo = (UserBean)session.getAttribute("userInfo");
%>
<nav class="navbar navbar-expand-md navbar-dark mb-4 shadow-sm" style="background-color: #d4b401;">
    <a class="navbar-brand" href="<%= rootURL %>/home"><i class="fas fa-cookie-bite"></i> Sweeter</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
    <% if(userInfo == null) { %>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/news/list">お知らせ</a>
            </li>
    <% } else if(userInfo.getType().equals("user")) { %>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/favorite/list">お気に入り</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/news/list">お知らせ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/user/detail">会員情報</a>
            </li>
    <% } else if(userInfo.getType().equals("admin")) { %>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/item/create/input">商品登録</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="<%= rootURL %>/news/list">お知らせ一覧</a>
            </li>
    <% } %>
        </ul>


        <div>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item text-center">
                    <form action="<%= rootURL %>/search" method="GET" class="form-inline mt-2 mt-md-0">
                        <input class="form-control mr-sm-2" type="text" name="word" placeholder="商品名で検索" aria-label="Search">
                        <button class="btn btn-danger my-2 my-sm-0" type="submit">検索</button>
                    </form>
                </li>
                <li class="nav-item text-center">
        <% if(userInfo != null) { %>
            <% if(userInfo.getType().equals("user")) { %>
                <%
                    Map<Integer, Integer> cart = (Map<Integer, Integer>)session.getAttribute("cart");
                    if(cart == null) cart = new HashMap<Integer, Integer>();
                %>
                <a class="btn btn-info ml-3" href="<%= rootURL %>/cart">カート<span class="badge badge-light badge-pill ml-2"><%= cart.size() %></span></a>
            <% } %>
                <a class="btn btn-success ml-3" href="<%= rootURL %>/logout">ログアウト</a>
        <% } else { %>
                <a class="btn btn-success ml-3" href="<%= rootURL %>/login">ログイン</a>
        <% } %>
                </li>
            </ul>
        </div>
    </div>
</nav>
