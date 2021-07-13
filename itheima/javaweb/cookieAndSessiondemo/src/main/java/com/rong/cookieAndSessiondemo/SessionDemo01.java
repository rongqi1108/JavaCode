package com.rong.cookieAndSessiondemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo01")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的用户名
        String username = req.getParameter("username");

        //2.获取HttpSession的对象
        HttpSession session = req.getSession();
        System.out.println(session);
        System.out.println(session.getId());

        //3.将用户信息添加到共享数据中
        session.setAttribute("username",username);

        //实现url重写，相当于在地址栏后拼接了一个jsessionid
        resp.setContentType("text/html");
        resp.getWriter().write("<a href='"+resp.encodeURL("http://localhost:8080/csDemo/sessionDemo03")+
                "'>go sessionDemo03</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
