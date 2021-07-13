<%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/13
  Time: 11:56 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>jsp指令</title>
</head>
<body>
    <%=s%>
    <% response.getWriter().write("aa");
    %>
</body>
</html>
