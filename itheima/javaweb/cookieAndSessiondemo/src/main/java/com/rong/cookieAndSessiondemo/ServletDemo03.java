package com.rong.cookieAndSessiondemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * cookie的路径限制
 * */
@WebServlet("/servletDemo01/servletDemo02/servletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cookie
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            resp.getWriter().write(c.getName() + "," + c.getValue()+"<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
