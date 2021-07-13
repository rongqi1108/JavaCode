<%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/13
  Time: 12:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp语法</title>
</head>
<body>
  <%
    System.out.println("Hello JSP");
    response.getWriter().write("Hello JSP<br>");
    String str = "hello<br>";
    response.getWriter().write(str);
  %>
  <%="Hello<br>"%>
<%--相当于response。getWriter().write(str)--%>

<%--jsp中的声明
    加！ 代表声明成员变量
    不加！代表声明局部变量
--%>
<%! String s = "abc";%>
<% String s = "def";%>
<%=s%>
<%! public void getSum(){}%>


</body>
</html>
