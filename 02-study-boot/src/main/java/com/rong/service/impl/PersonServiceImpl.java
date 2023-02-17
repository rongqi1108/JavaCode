package com.rong.service.impl;

import com.rong.constants.StatusCodeEnum;
import com.rong.exception.ServiceException;
import com.rong.mapper.PersonMapper;
import com.rong.pojo.po.Person;
import com.rong.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:22:13
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public List<Person> getAll() {
        return personMapper.getAll();
    }

    @Override
    public String get() {
        if (true) {
            throw new ServiceException(StatusCodeEnum.MISSING_REQUEST_PARAM_ERROR);
        }
        return "helloWorld";
    }
}
