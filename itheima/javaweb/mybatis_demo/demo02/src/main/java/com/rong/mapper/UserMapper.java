package com.rong.mapper;
import com.rong.bean.User;
import com.rong.sql.Sql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

//    @Select("select * from USER")
    @SelectProvider(type = Sql.class,method = "getSelectAll")
    List<User> getUsers();

//    @Insert("insert into user values(#{uid},#{ucode},#{loginname},#{PASSWORD},#{username},#{gender},#{birthday},#{dutydate})")
    @InsertProvider(type = Sql.class,method = "getInsert")
    void insertUser(User user);

//    @Delete("delete from USER where uid=#{uid}")
    @DeleteProvider(type = Sql.class,method = "getDelete")
    void deleteUser(String uid);

//    @Update("update user set ucode=#{ucode},loginname=#{loginname},PASSWORD=#{PASSWORD},username=#{username},gender=#{gender},birthday=#{birthday},dutydate=#{dutydate} where uid=#{uid}")
    @UpdateProvider(type = Sql.class,method = "getUpdate")
    void updateUser(User user);

}
