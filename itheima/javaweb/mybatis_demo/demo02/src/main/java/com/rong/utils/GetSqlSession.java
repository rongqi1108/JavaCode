package com.rong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {
    public static SqlSession sqlSession;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory f = new SqlSessionFactoryBuilder().build(is);
            sqlSession = f.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession get(){
        return sqlSession;
    }
}
