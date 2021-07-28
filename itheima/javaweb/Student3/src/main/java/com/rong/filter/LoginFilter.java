package com.rong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = {"/add.jsp","/listStudent"})
public class LoginFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.将请求和响应对象转换为何HTTP协议相关
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //2.获取会话域对象中数据
        Object username = req.getSession().getAttribute("username");
        System.out.println(req.getContextPath());
        //3.判断用户名
        if (username == null || "".equals(username)) {
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            return;
        }
        //4.放行
        filterChain.doFilter(req,resp);
    }
}
