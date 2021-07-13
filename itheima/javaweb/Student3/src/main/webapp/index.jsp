<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
<%
    Object username = session.getAttribute("username");
    if(username == null){
        %>
    <a href="/stu/login.jsp">请登录</a>
    <%}else{%>
    <a href="/stu/add.jsp">添加学生</a>
    <a href="/stu/listStudent">查看学生</a>
    <%}
%>
</body>
</html>