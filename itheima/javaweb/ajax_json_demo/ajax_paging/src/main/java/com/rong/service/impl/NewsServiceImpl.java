package com.rong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rong.bean.News;
import com.rong.mapper.NewsMapper;
import com.rong.service.NewsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public Page pageQuery(Integer start, Integer pageSize) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Page page = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession(true);
            NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);

            //5.封装Page对象   start:当前页码   pageSize：每页显示的条数
            page = PageHelper.startPage(start,pageSize);

            //6.调用实现类对象的查询全部方法，此时底层执行的就是MySQL的limit分页查询语句
            mapper.selectAll();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.close();
        }
        return page;
    }
}
