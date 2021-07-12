package com.rong.servlet;

import com.rong.bean.Student;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/student-servlet")
public class StudentServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Student student = new Student();
        String name = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setScore(Integer.parseInt(score));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/rong/IdeaProjects/itheima/javaweb/studentManager/stuInfo.txt",true));
        bw.write(student.getName()+ "," + student.getAge() + "," + student.getScore());
        bw.newLine();
        bw.close();

        //定时刷新给浏览器
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("success!2秒后将跳回添加页面！");
        resp.setHeader("Refresh","2;url=/studentManager/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}