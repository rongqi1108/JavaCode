package com.rong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ryan
 * @time 2023/2/14 10:29 下午
 */
@MapperScan("com.rong.mapper")
@SpringBootApplication
public class SpringBoot2023Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2023Application.class);
    }
}
