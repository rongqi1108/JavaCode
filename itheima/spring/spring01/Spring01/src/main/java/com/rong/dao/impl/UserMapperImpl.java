package com.rong.dao.impl;

import com.rong.dao.UserMapper;

public class UserMapperImpl implements UserMapper {

    private int num;
    private String version;

    public UserMapperImpl() {
    }

    public UserMapperImpl(int num, String version) {
        this.num = num;
        this.version = version;
    }

    //注入步骤1.对需要进行注入的变量进行set方法


    public void save() {
        System.out.println("userMapper is running..."+version+num);
    }
}
