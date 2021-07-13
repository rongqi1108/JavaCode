package com.rong.servlet;

import com.rong.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listStudent")
public class ListStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("stuInfo.txt"));
        ArrayList<Student> students = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null){
            String[] str = line.split(",");
            String name =str[0];
            int age = Integer.parseInt(str[1]);
            int score = Integer.parseInt(str[2]);
            Student student = new Student(name,age,score);
            students.add(student);
        }
        req.getSession().setAttribute("students",students);
        resp.sendRedirect("/stu/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
