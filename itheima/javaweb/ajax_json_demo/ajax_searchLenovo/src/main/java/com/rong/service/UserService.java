package com.rong.service;

import com.rong.bean.User;

import java.util.List;

public interface UserService {
    List<User> selectLike(String username);
}
