<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.bean.ItemBean" %>
<%@ page import="snack.bean.UserBean" %>
<%@ page import="snack.helper.WebHelper" %>
<%@ page import="org.apache.commons.text.StringEscapeUtils" %>

<%
    String rootURL = WebHelper.getRootURL(request);
    UserBean userInfo = (UserBean)session.getAttribute("userInfo");
    ItemBean item = (ItemBean)request.getAttribute("itemview");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= StringEscapeUtils.escapeHtml4(item.getName()) %> | Sweeter</title>
 <jsp:include page="../common/head.jsp" />
</head>
<body>
    <jsp:include page="../header.jsp" />
    <section>
        <div class="container">
            <div class="card mt-4">
                <div class="text-center d-flex align-items-center justify-content-center" style="height: 300px;">
                    <img style="max-height: 300px; max-width: 100%;" src="<%= rootURL + "/file/view?name=images/items/" + item.getImagePath() %>">
                </div>
                <div class="card-body">
                    <h3 class="card-title"><%= StringEscapeUtils.escapeHtml4(item.getName()) %></h3>
                    <h4><%= String.format("%,d", item.getPrice()) %>円</h4>
                    <p class="card-text"><%= StringEscapeUtils.escapeHtml4(item.getDescription()) %></p>
                    評価: <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
                <% if(userInfo != null) { %>
                    <div class="mt-2">
                        <button id="favorite" class="btn btn-primary float-left">お気に入りに追加</button>
                        <button id="cart" class="btn btn-primary float-right">カートに入れる</button>
                        <button id="purchase_auth" class="btn btn-primary float-right mr-3">今すぐ購入する</button>
                    </div>
                <% } %>
                </div>
            </div>
            <!--
            <div class="card card-outline-secondary my-4">
                <div class="card-header">レビュー</div>
                <div class="card-body">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <a href="#" class="btn btn-success">Leave a Review</a>
                </div>
            </div>
            -->
        </div>
    </section>

    <jsp:include page="../common/javascript.jsp" />
    <script type="text/javascript">
    $(function(){
    	$('#favorite').on('click', function(){
        	updateFavorite(<%=(item.getId())%>);
        });

        $('#cart').on('click', function(){
        	updateCart(<%=(item.getId())%>, 1);
        });

        $('#purchase_auth').on('click', function(){
        	location.href="../purchase/auth"
        });

        $('input').change(function() {
        	let id = $(this).parents('.row').parents('.row').data('id');
            let count = $(this).val();
            updateCart(id, count);
          });
    });
    </script>
</body>
</html>
