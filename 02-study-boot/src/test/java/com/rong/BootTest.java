package com.rong;

import com.rong.mapper.PersonMapper;
import com.rong.pojo.po.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ryan
 * @time 2023/2/14 10:38 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class BootTest {
    @Resource
    PersonMapper personMapper;
    @Test
    public void test1(){
        List<Person> all = personMapper.getAll();
        System.out.println(all);
    }
}
