<%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/13
  Time: 4:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post" autocomplete="off">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        <button type="submit">登录</button>
    </form>
</body>
</html>
