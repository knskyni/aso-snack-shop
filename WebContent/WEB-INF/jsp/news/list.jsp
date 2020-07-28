<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ一覧</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
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
	%>
    <section>
        <div class="container">
            <H1  align="center">お知らせ一覧</H1>
            <div class="row">
            	<div class="col-6">
            		<form action="home"  method="GET">
		            	<input type="submit" value="HOME" class="btn btn-primary">
		            </form>
            	</div>
            	<%if(userInfo == null){}else if(userInfo.getType() == "admin"){ %>
            	<div class="col-6" align="right">
            		<form action="create/input"  method="GET">
		            	<input type="submit" value="お知らせ追加" class="btn btn-primary">
		            </form>
            	</div>
            	<%} %>
            </div>


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
