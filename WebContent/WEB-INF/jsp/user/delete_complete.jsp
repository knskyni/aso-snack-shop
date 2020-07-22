<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>退会完了</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <style type="text/css">
     section{
    margin-bottom: 10%;
    margin-top: 10%;
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
            <H1>退会しました</H1>
            <form action="login" method="GET">
            	<input type="submit" value="ログインに戻る" class="btn btn-primary" style="width: 150px;">
            </form>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />
    <!-- JavaScript -->
    <script src="../../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>
