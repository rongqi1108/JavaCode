<%--
  Created by IntelliJ IDEA.
  User: rong
  Date: 2021/7/13
  Time: 5:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <form action="/stu/addStudent" method="post" autocomplete="off">
        学生姓名：<input type="text" name="name" autocomplete="off"><br>
        学生年龄：<input type="number" name="age" autocomplete="off"><br>
        学生成绩：<input type="number" name="score" autocomplete="off"><br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
