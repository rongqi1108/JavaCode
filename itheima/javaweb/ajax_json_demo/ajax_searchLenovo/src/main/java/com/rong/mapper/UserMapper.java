package com.rong.mapper;

import com.rong.bean.User;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 模糊查询
    * */
    @Select("select * from user where name like concat('%',#{username},'%') order by search_count desc limit 0,4")
    List<User> selectLike(String username);

    @Select("select * from user")
    List<User> selectAll();
}
