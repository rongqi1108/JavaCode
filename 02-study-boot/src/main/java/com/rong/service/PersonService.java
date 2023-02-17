package com.rong.service;

import com.rong.pojo.po.Person;

import java.util.List;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:21:20
 */

public interface PersonService {
    List<Person> getAll();
    String get();

    void findA();

    void findB();

    void findC();

    int save(Person person);
}
