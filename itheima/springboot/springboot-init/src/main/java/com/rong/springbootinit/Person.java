package com.rong.springbootinit;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "person")
@Data
public class Person {
    private String name;
    private int age;
}
