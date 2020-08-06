<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了画面</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
     <p><jsp:include page="../footer.jsp" /></p>
     </body>
</html>