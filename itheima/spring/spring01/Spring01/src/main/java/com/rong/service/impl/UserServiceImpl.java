package com.rong.service.impl;

import com.rong.dao.BookMapper;
import com.rong.dao.UserMapper;
import com.rong.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;
    private BookMapper bookMapper;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserMapper userMapper, BookMapper bookMapper) {
        this.userMapper = userMapper;
        this.bookMapper = bookMapper;
    }

    public void save() {
        System.out.println("userService is running！");
        userMapper.save();
        bookMapper.save();
    }

//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
}
