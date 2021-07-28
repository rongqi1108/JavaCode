package com.rong.mapper;

import com.rong.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
//    查询
    List<Student> selectAll();

//    增
    void insertStudent(Student stu);

//    删
    void deleteStudent(int sid);

//    改
    void updateStudent(Student stu);

//   通过sid和name检索一个人
    Student getOne(@Param("id") int sid, @Param("na")String name);

    Student getOne2(HashMap<String,Object> map);

//   条件查询
    List<Student> selectCondition(Student stu);

//
    List<Student> selectByIds(List<Integer> list);



}
