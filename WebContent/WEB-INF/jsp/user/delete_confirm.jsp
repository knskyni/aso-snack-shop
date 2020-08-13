<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>退会確認</title>

    <jsp:include page="../common/head.jsp" />
    <style type="text/css">
    section{
    margin-bottom: 10%;
    margin-top: 10%;
    }
    form{
    display: inline-block;
    margin-right: 10px;
    }
    div{
    text-align: center;
    }
    </style>
</head>
<body>
    <jsp:include page="../header.jsp" />

    <section>
        <div class="container">
            <!-- ここにHTMLを書き始める -->
            <h1 align="center">退会しますか？</h1>
            <div>
            	<a href="../detail" class="btn btn-outline-dark" style="width: 150px;">戻る</a>
            	<form method="POST">
            		<input type="submit" value="退会する" class="btn btn-primary" style="width: 150px;">
            	</form>
            </div>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
