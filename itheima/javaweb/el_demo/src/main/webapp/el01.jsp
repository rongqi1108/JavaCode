<%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/14
  Time: 3:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式快速入门</title>
</head>
<body>
    <%-- 1.向域对象中添加数据 --%>
    <%request.setAttribute("username","rongqi");%>
    <%-- 2.三种获取数据方式 --%>
    java代码块：<% out.print(request.getAttribute("username"));%><br>
    jsp表达式：<%=request.getAttribute("username")%><br>
    el表达式：${username}
</body>
</html>
