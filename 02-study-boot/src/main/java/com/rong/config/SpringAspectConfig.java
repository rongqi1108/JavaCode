package com.rong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: RQ
 * @Date: 2023-02-17 13:40:45
 */
@EnableAspectJAutoProxy
@ComponentScan("com.rong")
@Configuration
public class SpringAspectConfig {
}
