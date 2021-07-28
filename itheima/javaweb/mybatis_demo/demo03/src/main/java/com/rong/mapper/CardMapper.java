package com.rong.mapper;

import com.rong.bean.Card;
import com.rong.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardMapper {

    @Select("select * from card")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(
                    property = "p",//被包含对象的变量名
                    javaType = Person.class, //被包含对象的实际数据类型
                    column = "pid",//根据查询出的card表中的pid字段来查询person表
/*
            one @One 一对一的固定写法
            select 属性：指定调用哪个接口中的哪个方法
 */
                    one = @One(select="com.rong.mapper.PersonMapper.selectPersonById")
            )
    })
    List<Card> selectAllCard();
}
