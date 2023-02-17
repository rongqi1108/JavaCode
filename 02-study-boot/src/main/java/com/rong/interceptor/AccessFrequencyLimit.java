package com.rong.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: RQ
 * @Date: 2023-02-17 15:05:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessFrequencyLimit {
    int seconds();
    int maxCount();
    boolean needLogin() default true;
}
