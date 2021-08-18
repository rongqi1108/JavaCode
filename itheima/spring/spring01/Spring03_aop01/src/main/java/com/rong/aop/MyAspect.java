package com.rong.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void before(){
        System.out.println("前置增强。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。");
    }


    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强。。。");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强。。。");
    }

    public void throwing(){
        System.out.println("异常抛出通知");
    }

    public void after(){
        System.out.println("最终增强！");
    }
}
