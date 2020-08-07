<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);

    List<ItemBean> item = (List<ItemBean>)request.getAttribute("itemBean");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>トップページ</title>
    <!-- CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
    <section>
        <div class="container">
            <!-- ここにHTMLを書き始める -->
            <div class="col-sm-10">
      <form action="/search-result/">
  <input id="search-input" type="text" name="search-key">
  <input id="search-buttom" class="btn btn-default" type="submit" value="search" method="get">

</form>
</div>
</div>
    </section>
<table class = "table" border="0">
    <tbody>
    		<% int count = 0;%>
  			<%for(ItemBean itemBean : item){ %>
  				<% if(count ==0) {%>
  				<tr>
  				<%} %>
  				<td>
	            <p><a href = "show?id=<%=itemBean.getId() %>"><img src="<%=itemBean.getImagePath() %>"></a></p>
	            <p><a href="show?id=<%=itemBean.getId() %>"><%=itemBean.getName() %></a>
	            <p><a href="show?id=<%=itemBean.getId() %>"><%=itemBean.getDescription() %></a>
	            		</td>
	            		<% count ++;%>
	            		<% if(count ==4 ){%>
            		</tr>
            		<% count=0;%>
            	<%} %>
	        <%} %>
	            </tbody>
            </table>
    <!-- JavaScript -->
    <script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="<%= rootURL %>/js/bootstrap.min.js"></script>
</body>
</html>
