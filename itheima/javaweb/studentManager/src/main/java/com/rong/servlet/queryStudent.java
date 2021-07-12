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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/queryStudent")
public class queryStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/rong/IdeaProjects/itheima/javaweb/studentManager/stuInfo.txt"));
        String line;
        ArrayList<Student> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            Student student = new Student();
            String[] arr = line.split(",");
            student.setName(arr[0]);
            System.out.println(arr[0]);
            student.setAge(Integer.parseInt(arr[1]));
            student.setScore(Integer.parseInt(arr[2]));
            list.add(student);
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        for (Student stu : list) {
            writer.write(stu.getName() + "," + stu.getAge() + "," + stu.getScore());
            writer.write("<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
