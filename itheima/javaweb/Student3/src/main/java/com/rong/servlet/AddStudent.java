package com.rong.servlet;

import com.rong.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        int score = Integer.parseInt(req.getParameter("score"));
        ArrayList<Student> students = new ArrayList<Student>();
        Student student = new Student(name, age, score);
        students.add(student);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("stuInfo.txt", true), "UTF-8"));
        bw.write(student.getName() + "," + student.getAge() + "," + student.getScore());
        bw.newLine();
        bw.close();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("添加成功！2秒后返回添加页面");
        resp.setHeader("Refresh", "2;url=/stu/add.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
