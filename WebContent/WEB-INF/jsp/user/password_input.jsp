<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>パスワード変更</title>
<!-- CSS -->
<link rel="stylesheet" href="./css/bootstrap.min.css">

</head>
<body class="text-center">

<form action="/account/change-password/input" method="POST">

<h1 class="h3 mb-3 font-weight-normal">NewPassword</h1>
<label for="inputPassword" class="sr-only">Password</label>
<input type="password" id="inputPassword" class="form-control" name="newpass" placeholder="Password" required>

<button class="btn btn-lg btn-primary btn-block" type="submit">修正する</button>
<button class="btn btn-lg btn-primary btn-block" onclick="history.back()">戻る</button>
</form>

    <!-- JavaScript -->
    <script src="./js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="./js/bootstrap.min.js"></script>

</body>
</html>