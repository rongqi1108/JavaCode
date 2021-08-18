package com.rong.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name}")
    private String name;

    @Value("${person.age}")
    private int age;

    @Value("${address[0]}")
    private String address;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(name+","+age);
        System.out.println(address);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println(env.getProperty("name"));
        System.out.println(person.toString());
        return "hello!";
    }
}
