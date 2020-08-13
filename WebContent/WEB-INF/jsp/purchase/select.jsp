<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>

    <jsp:include page="../common/head.jsp" />
</head>
<jsp:include page="../common/head.jsp" />
<%String msg  = (String)request.getAttribute("msg"); %>
<body>
    <jsp:include page="../header.jsp" />
    <form action="select" method="post">
        <div class="container">
            <table>
                <tr>
                    <th><input class="form-check-input" type="radio" name="selectRadios" id="exampleRadios1" value="card"></th>
                    <td><label class="form-check-label" for="exampleRadios1">カード</label><br><input type="text" name="cardNumber" placeholder="カード番号"></td>
                </tr>
                <tr>
                    <th><input class="form-check-input" type="radio" name="selectRadios" id="exampleRadios2" value="money"></th>
                    <td><label class="form-check-label" for="exampleRadios1">代金引換</label></td>
                </tr>
                <tr>
                    <th><input class="form-check-input" type="radio" name="selectRadios" id="exampleRadios3" value="ATM"></th>
                    <td><label class="form-check-label" for="exampleRadios1">ATM・コンビニ支払い</label></td>
                </tr>
            </table>
            <p>
                <font color="red">
                <%if(msg != null){%>
                    <%=msg %>
                <%} %>
                </font>
            </p>
            <input type="submit" class="btn btn-primary" value="注文確認へ">
        </div>
    </form>
    <jsp:include page="../footer.jsp" />
    <jsp:include page="../common/javascript.jsp" />
</body>
</html>