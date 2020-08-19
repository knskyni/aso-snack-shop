<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ一覧 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
    <style type="text/css">
     section{
    margin-bottom: 10%;
    margin-top: 10%;
    }
    table{
    margin-top: 2%;
    }
    </style>
</head>
<body>
    <jsp:include page="../header.jsp" />
	<%
    	List<NewsBean> news = (List<NewsBean>)request.getAttribute("news");
    	UserBean userInfo = (UserBean)session.getAttribute("userInfo");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	%>
    <section>
        <div class="container">
            <h1 align="center">お知らせ一覧</h1>
        <% if(userInfo != null && userInfo.getType().equals("admin")) { %>
            <div class="text-center my-3">
                <a href="create/input" class="btn btn-primary">お知らせを追加</a>
            </div>
        <% } %>

            <table class="table table-hover" style="border-bottom: 1px solid #dee2e6;">
            <%for(NewsBean newsBean : news) { %>
                <tr>
                    <th><%= sdf.format(newsBean.getUpdatedAt()) %></th>
                    <td><%= newsBean.getSubject() %></td>
                    <td><a href="show?id=<%=newsBean.getId() %>" class="btn btn-primary">詳細</a></td>
                </tr>
            <%} %>
            </table>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
