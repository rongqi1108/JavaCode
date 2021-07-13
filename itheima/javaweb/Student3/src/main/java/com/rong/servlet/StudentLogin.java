package com.rong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class StudentLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.判断用户名
        if(username == null || "".equals(username)){
            resp.getWriter().write("用户名输入错误！2秒后请重新登录……");
            resp.setHeader("Refresh","2;url=/stu/login.jsp");
            return;
        }
        //3.用户名不为空，将用户名存入会话域
        req.getSession().setAttribute("username",username);
        //4.重定向到首页
        resp.sendRedirect("/stu/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
