package com.rong.service.impl;

import com.rong.bean.User;
import com.rong.mapper.UserMapper;
import com.rong.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> selectLike(String username) {
        List<User> users = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession =factory.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            users = mapper.selectLike(username);

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
        return users;
    }
}
