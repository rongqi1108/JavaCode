package com.rong.controller;

import com.rong.constants.StatusCodeEnum;
import com.rong.exception.ServiceException;
import com.rong.pojo.po.Person;
import com.rong.pojo.vo.CommonResult;
import com.rong.pojo.vo.PageInfo;
import com.rong.pojo.vo.Void;
import com.rong.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:20:53
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;



    @GetMapping("/get/person/1")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @GetMapping("/get/person/2")
    public CommonResult<PageInfo<Person>> getAll() {
        List<Person> all = personService.getAll();
        return CommonResult.success(PageInfo.onlyList(all));
    }

    @GetMapping("exception/1")
    public CommonResult<Void> testException() {
        throw new ServiceException(null);
    }

    @PostMapping("exception/2")
    public CommonResult<Void> testException2() {
        throw new NullPointerException();
    }

    @PostMapping("exception/3")
    public CommonResult<Void> testException3() {
        throw new ServiceException(StatusCodeEnum.MISSING_REQUEST_PARAM_ERROR);
    }

    @PostMapping("exception/4")
    public CommonResult<String> testException4() {
        String msg = personService.get();
        return CommonResult.success(msg);
    }

    @GetMapping("aop/1")
    public CommonResult<Void> aop(){
        personService.findA();
        personService.findB();
        personService.findC();
        return CommonResult.success();
    }

}
