<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="snack.helper.WebHelper" %>
<%
    String rootURL = WebHelper.getRootURL(request);
%>

<script src="<%= rootURL %>/js/jquery-3.5.1.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
<script src="<%= rootURL %>/js/bootstrap.min.js"></script>
<script src="<%= rootURL %>/js/sweeter.js"></script>