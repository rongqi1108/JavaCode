package com.rong.controller;

import com.rong.pojo.po.Person;
import com.rong.pojo.vo.CommonResult;
import com.rong.pojo.vo.PageInfo;
import com.rong.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: RQ
 * @Date: 2023-02-17 09:20:53
 */
@RestController
public class PersonController {
    @Resource
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
}
