<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/14
  Time: 4:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>循环</title>
</head>
<body>
<%--向域对象中添加集合--%>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    list.add("dd");
    pageContext.setAttribute("list",list);
%>

<%--遍历集合--%>
<c:forEach items="${list}" var="str">
    ${str} <br>
</c:forEach>
</body>
</html>
