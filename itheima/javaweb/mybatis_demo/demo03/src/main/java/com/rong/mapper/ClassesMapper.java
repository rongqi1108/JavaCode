package com.rong.mapper;

import com.rong.bean.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassesMapper {

    @Select("select * from classes")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(
                    property = "students",//被包含对象的变量名
                    javaType = List.class,//被包含对象的实际数据类型
                    /*
                    many @Many 一对多的固定写法
                    select属性：指定调用哪个接口中的哪个查询方法
                     */
                    column = "id",//根据查询出来的classes表中的id字段来查询student2表
                    many=@Many(select = "com.rong.mapper.Student2Mapper.selectStudent2")
            )
    })
    List<Classes> selectAll();
}
