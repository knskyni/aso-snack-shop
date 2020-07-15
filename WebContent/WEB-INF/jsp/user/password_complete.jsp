<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String errMsg = (String)request.getAttribute("errMsg");
%>
<%if( errMsg != null){%>
     <%=errMsg %>
     <%} %>
<p>修正完了</p>
<form action="top" method="Get">
<table>
<tr>
<td><input type="submit" value="TOPページ"></td>
</tr>
</table>
</form>
</body>
</html>