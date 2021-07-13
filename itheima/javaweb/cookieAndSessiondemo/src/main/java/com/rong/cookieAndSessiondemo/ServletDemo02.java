package com.rong.cookieAndSessiondemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* cookie的路径限制
* 取自第一次访问的资源路径前缀
* 只要以这个前缀为开头（包括子级路径）。就能获取到，反之，获取不到。
* */
@WebServlet("/servletDemo01/servletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //创建cookie并添加
        Cookie cookie = new Cookie("username", "RongQi");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
