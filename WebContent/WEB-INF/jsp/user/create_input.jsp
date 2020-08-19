<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.HashMap" %>
	<%@ page import="snack.helper.ErrorHelper" %>
	<%@ page import="snack.helper.StringHelper" %>
	<%@ page import="snack.bean.UserBean" %>
	<%@ page import="org.apache.commons.text.StringEscapeUtils" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%
    HashMap<String, ArrayList<String>> errors = (HashMap<String, ArrayList<String>>)request.getAttribute("errors");
    UserBean user = (UserBean)session.getAttribute("user");
    if(user == null) user = new UserBean();
%>
    <title>新規会員登録 - 入力 | Sweeter</title>

    <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <h2>会員登録</h2>
            <hr>
            <form action="input" method="POST">
              <div class="row">
  				<div class="form-group col-sm-6">
    				<label for="text4c">名前</label>
    				<input type="text" name="Kmei" class="form-control" id="text4c" placeholder="姓"value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getLastName())) %>">
    				<small class="form-text text-muted">必須、16文字以内</small>
    				<% if(ErrorHelper.exist(errors, "Ksei")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "Ksei")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
  				</div>
  				<div class="form-group col-sm-6">
    				<label for="text4d">　</label>
    				<input type="text" name="Ksei" class="form-control" id="text4d" placeholder="名"value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getFirstName())) %>">
    				<small class="form-text text-muted">必須、16文字以内</small>
    				<% if(ErrorHelper.exist(errors, "Kmei")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "Kmei")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
  				</div>
  			</div>
  			<div class="row">
  				<div class="form-group col-sm-6">

    				<input type="text" name="Hmei" class="form-control" id="text4c" placeholder="せい"value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getLastNameFurigana())) %>">
    				<small class="form-text text-muted">必須、32文字以内</small>
    				<% if(ErrorHelper.exist(errors, "Hsei")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "Hsei")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
  				</div>
  				<div class="form-group col-sm-6">
    				<input type="text" name="Hsei" class="form-control" id="text4d" placeholder="めい"value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getFirstNameFurigana())) %>">
    				<small class="form-text text-muted">必須、32文字以内</small>
    				<% if(ErrorHelper.exist(errors, "Hmei")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "Hmei")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
  				</div>
  				</div>
  					<div class="form-group">
                <label for="subject">メールアドレス</label>
                <input type="text" name="mail" class="form-control" id="subject" placeholder="メールアドレス" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getEmail())) %>">
                <small class="form-text text-muted">正しいメールアドレスを入力してください</small>
                <% if(ErrorHelper.exist(errors, "mail")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "mail")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="form-group">
                <label for="subject">パスワード</label>
                <input type="password" name="pass" class="form-control" id="subject" placeholder="パスワード">
                <small class="form-text text-muted">英数字・記号のみ使用可能　大文字・小文字は区別します</small>
                <small class="form-text text-muted">８文字以上１２８文字以内のパスワードを入力してください。</small>
                <% if(ErrorHelper.exist(errors, "pass")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "pass")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>

              </div>
              <div class="form-group">
                <label for="subject">パスワード(確認用)</label>
                <input type="password" name="Kpass" class="form-control" id="subject" placeholder="パスワード">
                <small class="form-text text-muted">上のパスワードと同じパスワードを入力してください</small>
              </div>

				<div class="row">
              <div class="form-group col-sm-4">
                <label for="subject">郵便番号</label>
                <input type="text" name="post" class="form-control" id="subject" placeholder="例:812-0016" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getPostalCode())) %>">
                <small class="form-text text-muted">ハイフンを使って入力してください</small>
                <% if(ErrorHelper.exist(errors, "post")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "post")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              </div>
				<div class="form-group">
                <label for="subject">住所</label>
                <input type="text" name="address" class="form-control" id="subject" placeholder="例:福岡市博多区博多駅南2-12-32" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getAddress())) %>">
                <% if(ErrorHelper.exist(errors, "address")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "address")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              <div class="row">
              <div class="form-group col-sm-4">
                <label for="subject">電話番号</label>
                <input type="text" name="number" class="form-control" id="subject" placeholder="例:012-3456-7890" value="<%= StringEscapeUtils.escapeHtml4(StringHelper.nullToBlank(user.getPhoneNumber())) %>">
                <small class="form-text text-muted">ハイフンを使って電話番号を入力してください</small>
                <% if(ErrorHelper.exist(errors, "number")) { %>
                <div class="invalid-feedback d-block">
                    <ul>
                    <% for(String message : ErrorHelper.get(errors, "number")) { %>
                        <li><%= message %></li>
                    <% } %>
                    </ul>
                </div>
                <% } %>
              </div>
              </div>
               <div class="row">
                <div class="col-sm-6"><button type="button" onclick="location.href='show'" class="btn btn-light" >戻る</button></div>
                <div class="col-sm-6"><button type="submit" class="btn btn-primary">確認</button></div>
            </div>
            </form>
        </div>
    </section>

    <jsp:include page="../common/javascript.jsp" />
</body>
</html>
