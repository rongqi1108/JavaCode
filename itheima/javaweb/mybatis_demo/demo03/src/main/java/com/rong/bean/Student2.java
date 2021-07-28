package com.rong.bean;

import lombok.Data;

import java.util.List;

@Data
public class Student2 {
    private int id;
    private String name;
    private int age;
    private int cid;
    private List<Course> courses;
}
