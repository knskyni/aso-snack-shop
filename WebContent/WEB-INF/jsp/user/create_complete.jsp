<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>新規会員登録 - 完了 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <div class="text-center">
                <h2 class="text-center">登録完了しました。</h2>
                <hr>
                <p>
                    会員情報を登録しました。<br>
                    以下のボタンからログインしてください。
                </p>
                <hr>
                <a href="../login" class="btn btn-primary">ログイン</a>
            </div>
        </div>
    </section>

    <jsp:include page="../footer.jsp" />

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>