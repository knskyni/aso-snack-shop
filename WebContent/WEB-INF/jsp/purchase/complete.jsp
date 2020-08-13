<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <jsp:include page="../common/head.jsp" />
</head>
<%
String date = (String)session.getAttribute("date");
%>
<body>
    <jsp:include page="../header.jsp" />
    <div class="container">
        <h1>ありがとうございます。注文が確定されました。</h1>
        <label>確認のEメールを送信しました。</label><br>
        <label>発送元 : XXXX.japan</label><br>
        <label>お届け予定日：</label><label><%=date %></label><br>
        <Button type="button" class="btn btn-warning"  onclick="location.href='home'">ショッピングを続ける</Button>
    </div>
    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
 </body>
</html>