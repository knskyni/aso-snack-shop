<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ一覧</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="../header.jsp" />
	<%
	List<NewsBean> news = (List<NewsBean>)request.getAttribute("news");
	%>
    <section>
        <div class="container">
            <form action="home"  method="GET">
            <p><input type="submit" value="HOME" class="btn btn-primary"></p>
            </form>
            <H1  align="center">お知らせ一覧</H1>

            <table class="table table-hover">
	            <%for(NewsBean newsBean : news){ %>
           			<tr>
	           			<th scope="col" width="5%"><a href="show?id=<%=newsBean.getId() %>">➤</a></th>
	           			<th scope="col" width="20%">
	            			<a href="show?id=<%=newsBean.getId() %>"><%=newsBean.getUpdatedAt() %></a>
	           			</th>
	           			<td scope="col" width="75%">
	            			<a href="show?id=<%=newsBean.getId() %>"><%=newsBean.getSubject() %></a>
	            		</td>
            		</tr>
	            <%} %>
            </table>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />
    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
