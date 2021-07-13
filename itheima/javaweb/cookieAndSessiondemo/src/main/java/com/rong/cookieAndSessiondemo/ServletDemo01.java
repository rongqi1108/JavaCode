package com.rong.cookieAndSessiondemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过响应对象写出提示信息
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("欢迎访问本网站，您最后访问的时间是：<br>");

        //2.创建一个cookie对象，用于存放最后一次访问时间
        Cookie cookie = new Cookie("time",System.currentTimeMillis()+"");

        //3.设置最大存活时间
        cookie.setMaxAge(3600);//3600秒

        //4.将cookie对象添加到客户端
        resp.addCookie(cookie);

        //5.获取cookie
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
            if("time".equals(c.getName())){
                //6.获取cookie对象中的value值，进行写出
                String value = c.getValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = simpleDateFormat.format(new Date(Long.parseLong(value)));
                pw.write(format);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
