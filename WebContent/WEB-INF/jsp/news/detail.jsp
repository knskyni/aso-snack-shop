<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>お知らせ詳細</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <style type="text/css">
    table{
    table-layout: fixed;
    width: 100%;
    }
    table td{
    word-wrap: break-word;
    }
    </style>
</head>
<body>
    <jsp:include page="../header.jsp" />
	<%
	NewsBean newsBean = (NewsBean)request.getAttribute("newsBean");
	%>
    <section>
        <div class="container">
            <form action="home"  method="GET">
            <p><input type="submit" value="HOME" class="btn btn-primary"></p>
            </form>
            <H1  align="center">お知らせ</H1>
			<table class="table table-bordered">
           		<tr>
           			<th>
            			<%=newsBean.getUpdatedAt() %>
           			</th>
            	</tr>
            	<tr>
            		<td>
            			<%=newsBean.getSubject() %>
            		</td>
            	</tr>
            	<tr>
            		<td>
            			<%=newsBean.getContent() %>
            		</td>
            	</tr>
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
