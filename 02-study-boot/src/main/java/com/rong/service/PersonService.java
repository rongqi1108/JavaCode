package com.rong.service;

import com.rong.pojo.po.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:21:20
 */

public interface PersonService {
    List<Person> getAll();
}