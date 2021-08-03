package com.rong.mapper;

import com.rong.bean.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    @Select("select * from news;")
    List<News> selectAll();
}
