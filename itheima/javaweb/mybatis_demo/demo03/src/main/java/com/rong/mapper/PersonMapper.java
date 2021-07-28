package com.rong.mapper;

import com.rong.bean.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {
    //根据id查询
    @Select("select * from person where id=#{id}")
    Person selectPersonById(Integer id);
}
