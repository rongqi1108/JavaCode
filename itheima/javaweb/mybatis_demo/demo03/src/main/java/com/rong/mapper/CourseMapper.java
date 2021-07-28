package com.rong.mapper;

import com.rong.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select c.id,c.NAME from stu_cr sc,course c where sc.cid=c.id and sc.sid=#{id};")
    List<Course> selectCourseById(Integer id);
}
