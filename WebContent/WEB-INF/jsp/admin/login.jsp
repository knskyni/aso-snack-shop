<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>管理者ログイン</title>

    <!-- CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <style type="text/css">
     section{
    margin-bottom: 10%;
    margin-top: 10%;
    }
    </style>
</head>
<body>
	<%
		String errMsg1 = (String)request.getAttribute("msg1");
		String errMsg2 = (String)request.getAttribute("msg2");
	%>
    <section>
        <div class="container">
			<form method="POST" id="check">


						<p>メールアドレス</p>


						<div  class="form-group">
							<p><input type="text" name="email" placeholder="メールアドレス" class="form-control"></p>
						</div>



						<p class="text-danger" id="msg1">
							<%if(errMsg1 != null){ %>
								<%=errMsg1 %>
							<%} %>
						</p>

						<p>パスワード</p>

						<div class="form-group">
							<p><input type="password" name="password" placeholder="パスワード" class="form-control"></p>
						</div>

						<p class="text-danger" id="msg2">
							<%if(errMsg2 != null){ %>
								<%=errMsg2 %>
							<%} %>
						</p>

						<p align="center"><input type="submit" value="ログイン" name="btn" class="btn btn-primary" style="width: 300px;"></p>
						</form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script>
		document.getElementById('check').btn.onclick = function(){
			var email = document.getElementById('check').email.value;
	   		var password = document.getElementById('check').password.value;
	   		if(email === ''){
	     		document.getElementById('msg1');
	    		document.getElementById('msg1').textContent = '*メールアドレスを入力してください';
	   		}
	   		if(password === ''){
	     		document.getElementById('msg2');
	    		document.getElementById('msg2').textContent = '*パスワードを入力してください';
	   		}
	   		if(email === '' || password === ''){
	   			return false;
	   		}
		}
	</script>
</body>
</html>
