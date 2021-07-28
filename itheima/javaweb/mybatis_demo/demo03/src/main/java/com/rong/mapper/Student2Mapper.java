package com.rong.mapper;
import com.rong.bean.Student2;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Student2Mapper {
    @Select("select * from student2 where cid=#{cid}")
    List<Student2> selectStudent2(Integer cid);

    @Select("select * from student2 s,stu_cr sc where sc.sid=s.id")
    @Results({
            @Result(column="id",property="id"),
            @Result(column="name",property = "name"),
            @Result(column="age",property="age"),
            @Result(
                    property = "courses",
                    javaType = List.class,
                    column = "id",//根据学生表查出来的id再去查中间表和课程表
                    many = @Many (select = "com.rong.mapper.CourseMapper.selectCourseById" )
            )
    })
    List<Student2> selectAll();
}
