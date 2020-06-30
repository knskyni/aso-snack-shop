<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>お知らせ登録</h2>
            <p>サイト内のお知らせを登録します。</p>
            <hr>
            <form action="" method="POST">
              <div class="form-group">
                <label for="subject">件名</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="タイトル" required>
                <small class="form-text text-muted">必須、32文字以内</small>
              </div>
              <div class="form-group">
                <label for="content">内容</label>
                <textarea class="form-control" id="content" name="content" rows="7" required></textarea>
              </div>
              <button type="submit" class="btn btn-primary float-right">確認</button>
            </form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
