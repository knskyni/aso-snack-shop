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
            <h2>会員登録</h2>
            <hr>
            <form action="" method="POST">
              <div class="row">
  				<div class="form-group col-sm-6">
    				<label for="text4c">名前</label>
    				<input type="text" class="form-control" id="text4c" placeholder="姓">
    				<small class="form-text text-muted">必須、16文字以内</small>
  				</div>
  				<div class="form-group col-sm-6">
    				<label for="text4d">　</label>
    				<input type="text" class="form-control" id="text4d" placeholder="名">
    				<small class="form-text text-muted">必須、16文字以内</small>
  				</div>
  			</div>
  			<div class="row">
  				<div class="form-group col-sm-6">

    				<input type="text" class="form-control" id="text4c" placeholder="せい">
    				<small class="form-text text-muted">必須、32文字以内</small>
  				</div>
  				<div class="form-group col-sm-6">
    				<input type="text" class="form-control" id="text4d" placeholder="めい">
    				<small class="form-text text-muted">必須、32文字以内</small>
  				</div>
  				</div>
  					<div class="form-group">
                <label for="subject">メールアドレス</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="メールアドレス" required>
                <small class="form-text text-muted">正しいメールアドレスを入力してください</small>
              </div>
              <div class="form-group">
                <label for="subject">パスワード</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="パスワード" required>
                <small class="form-text text-muted">英数字・記号のみ使用可能　大文字・小文字は区別します</small>
                <small class="form-text text-muted">８文字以上１２８文字以内のパスワードを入力してください。</small>

              </div>
              <div class="form-group">
                <label for="subject">パスワード(確認用)</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="パスワード" required>
                <small class="form-text text-muted">上のパスワードと同じパスワードを入力してください</small>
              </div>

				<div class="row">
              <div class="form-group col-sm-4">
                <label for="subject">郵便番号</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="例:812-0016" required>
                <small class="form-text text-muted">ハイフンを使って入力してください</small>
              </div>
              </div>
				<div class="form-group">
                <label for="subject">住所</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="例:福岡市博多区博多駅南2-12-32" required>
              </div>
              <div class="row">
              <div class="form-group col-sm-4">
                <label for="subject">電話番号</label>
                <input type="text" name="subject" class="form-control" id="subject" placeholder="例:096-123-456" required>
                <small class="form-text text-muted">ハイフンを使って電話番号を入力してください</small>
              </div>
              </div>
              <div class="row">
  				<div class="form-group col-sm-6">
    				<button type="submit" class="btn btn-light btn-outline-dark w-75">戻る</button>
  				</div>
  				<div class="form-group col-sm-6">
    				<button type="submit" class="btn btn-primary w-75 float-right">確認</button>
  				</div>
  			</div>


            </form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>
