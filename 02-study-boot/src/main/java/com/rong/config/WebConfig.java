package com.rong.config;

import com.rong.interceptor.AccessFrequencyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: RQ
 * @Date: 2023-02-17 15:24:30
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Resource
    private AccessFrequencyInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
