package com.rong.sql;

import org.apache.ibatis.jdbc.SQL;

public class Sql {
    public String getSelectAll(){
        return new SQL(){
            {
                SELECT("*");
                FROM("USER");
            }
        }.toString();
    }

    public String getInsert(){
        return new SQL(){{
            INSERT_INTO("USER");
            VALUES("","#{uid},#{ucode},#{loginname},#{PASSWORD},#{username},#{gender},#{birthday},#{dutydate}");
        }}.toString();
    }

    public String getDelete(){
        return new SQL(){{
            DELETE_FROM("USER");
            WHERE("uid=#{uid}");
        }}.toString();
    }

    public String getUpdate(){
        return new SQL(){{
            UPDATE("USER");
            SET("ucode=#{ucode},loginname=#{loginname},PASSWORD=#{PASSWORD},username=#{username},gender=#{gender},birthday=#{birthday},dutydate=#{dutydate}");
            WHERE("uid=#{uid}");
        }}.toString();
    }


}
