<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.NewsBean" %>
<%@ page import="snack.bean.UserBean" %>
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
     section{
    margin-bottom: 10%;
    margin-top: 10%;
    }
    </style>
</head>
<body>
    <jsp:include page="../header.jsp" />
	<%
	NewsBean newsBean = (NewsBean)request.getAttribute("newsBean");
	UserBean userInfo = (UserBean)session.getAttribute("userInfo");
	%>
    <section>
        <div class="container">
            <H1  align="center">お知らせ</H1>
            <form action="home"  method="GET">
            	<p><input type="submit" value="HOME" class="btn btn-primary"></p>
            </form>
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
           	<div class="row">
	           	<div class="col-8">
	           		<form action="list"  method="GET">
            			<input type="submit" value="戻る" class="btn btn-light">
            		</form>
	           	</div>
	           	<%if(userInfo == null){}else if(userInfo.getType() == "admin"){ %>
	           	<div class="col-2">
	           		<form action="update/input"  method="GET">
		            	<input type="hidden" name="id" value="<%=newsBean.getId()%>">
		            	<p align="right"><input type="submit" value="更新" class="btn btn-primary"></p>
		            </form>
	           	</div>
	           	<div class="col-2">
		           	<form action="delete/confirm"  method="GET">
		            	<input type="hidden" name="id" value="<%=newsBean.getId()%>">
		            	<p align="right"><input type="submit" value="削除" class="btn btn-primary" name="id"></p>
		            </form>
	           	</div>
	           	<%} %>
           	</div>
	    </div>
    </section>
    <jsp:include page="../footer.jsp" />
    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
