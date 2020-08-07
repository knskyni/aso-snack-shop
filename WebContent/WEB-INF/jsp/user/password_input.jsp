<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>パスワード変更</title>
<!-- CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

</head>
<body>
<jsp:include page="../header.jsp" />
    <div class="container">
        <p>パスワード変更画面</p>
<form action="/account/change-password/input" method="POST">

<br>新規パスワード<br>
    <input type="text" class="form-control" name="pass" placeholder="新しいパスワードを入力してください">
<br>

<div class="row">
    <div class="col-sm-6"><button type="button" onclick="location.href='show'" class="btn btn-light" >戻る</button></div>
    <div class="col-sm-6"><button type="submit" class="btn btn-primary">変更</button></div>
</div>

</form>
</div>
    <!-- JavaScript -->
    <script src="./js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="./js/bootstrap.min.js"></script>

</body>
</html>