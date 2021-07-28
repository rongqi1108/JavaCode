package com.rong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
解决全局乱码问题
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
//        System.out.println(req.getContextPath());//显示：/stu
//        System.out.println(req.getServletPath());//显示：/index.jsp
//        System.out.println(req.getRequestURI());//显示：/stu/
//        System.out.println(req.getRequestURL());//显示：http://localhost:8080/stu/
//        System.out.println(req.getRealPath("/"));//显示：/Users/rong/IdeaProjects/itheima/javaweb/Student3/target/Student3-1.0-SNAPSHOT/
//        System.getProperty("user.dir");/Users/rong/CodeEnviroment/apache-tomcat-9.0.29
        filterChain.doFilter(req,resp);
    }
}
