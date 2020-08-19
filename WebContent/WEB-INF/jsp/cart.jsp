<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="snack.helper.WebHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="snack.bean.ItemBean"%>

<%
    String rootURL = WebHelper.getRootURL(request);
    List<ItemBean> items = (List<ItemBean>)request.getAttribute("items");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>カート一覧 | Sweeter</title>

<jsp:include page="./common/head.jsp" />
</head>
<body>
    <jsp:include page="./header.jsp" />
    <section>
        <div class="container">
            <h2>カート一覧</h2>
            <hr>

        <% if(!items.isEmpty()) { %>
            <% int totalPrice = 0; %>
            <% for(ItemBean item : items) { %>
            <% totalPrice += item.getPrice() * item.getCount(); %>
            <div class="row" data-id="<%= item.getId() %>">
                <div class="col-md-2">
                    <img class="img-fluid" style="max-height: 200px;" src="<%= rootURL + "/file/view?name=images/items/" + item.getImagePath() %>">
                </div>
                <div class="col-md-6">
                    <h4 class="product-name">
                        <strong><%= item.getName() %></strong>
                    </h4>
                    <h4>
                        <small><%= item.getDescription() %></small>
                    </h4>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-sm-6 text-right">
                            <h6>
                                <strong><%= String.format("%,d", item.getPrice()) %> <span class="text-muted">円</span></strong>
                            </h6>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control input-sm" value="<%= item.getCount() %>">
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-link btn-sm">
                                <span class="fas fa-trash-alt"></span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <% } %>
            <div class="row">
                <div class="col-sm-9">
                    <span class="float-right">合計 <strong class="h4"><%= String.format("%,d", totalPrice) %>円</strong></span>
                </div>
                <div class="col-sm-3">
                    <a href="./purchase/auth" class="btn btn-success btn-block">購入手続きへ</a>
                </div>
            </div>
        <% } else { %>
            <p>カートには何も追加されていません。</p>
        <% } %>
        </div>
    </section>
    <jsp:include page="./footer.jsp" />

    <jsp:include page="./common/javascript.jsp" />
    <script>
    $(function(){
        $('button').on('click', function(){
        	let itemRow = $(this).parents('.row').parents('.row');
            let id = itemRow.data('id');
            updateCart(id, 0);
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
