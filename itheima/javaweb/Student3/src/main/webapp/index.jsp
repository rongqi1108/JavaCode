<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>学生管理系统</title>
</head>
<body>
<%--
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
--%>
<c:if test="${sessionScope.username eq null}">
    <a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
</c:if>
<c:if test="${sessionScope.username ne null}">
    <a href="${pageContext.request.contextPath}/add.jsp">添加学生</a>
    <a href="${pageContext.request.contextPath}/listStudent">查看学生</a>
</c:if>


</body>
</html>