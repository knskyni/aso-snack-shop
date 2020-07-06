<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>ログイン画面</title>

    <!-- CSS -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<%String msg  = (String)request.getAttribute("msg"); %>
<body class="text-center">


	<style>
	<!--
       html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: -webkit-box;
  display: flex;
  -ms-flex-align: center;
  -ms-flex-pack: center;
  -webkit-box-align: center;
  align-items: center;
  -webkit-box-pack: center;
  justify-content: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
#new{
margin-top: 15px;
}
 -->
	</style>

    <section>
        <div class="container">

            <form class="form-signin" action="login" method="POST">

      			<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">

      				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

                    <p><%if(msg != null){%>

                    <%=msg %></p>

                    <%} %>

      					<label for="inputEmail" class="sr-only">Email address</label>

     			 			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>

      					<label for="inputPassword" class="sr-only">Password</label
      					>
      						<input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>


      					<button class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>

      					<a href="location.href='/input'" id="new">新規登録はこちら</a>

      					<p class="mt-5 mb-3 text-muted">&copy; 2019 - 2020</p>
             </form>
        </div>
    </section>

    <!-- JavaScript -->
    <script src="./js/jquery-3.5.1.min.js"></script>
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>