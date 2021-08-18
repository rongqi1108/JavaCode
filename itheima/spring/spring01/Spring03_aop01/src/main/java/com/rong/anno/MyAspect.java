package com.rong.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect2")
@Aspect//声明为切面
public class MyAspect {
    //定义切点表达式
    @Pointcut("execution(* com.rong.anno.*.*(..))")
    public void pointcut(){}

    //配置前置通知
    @Before("execution(* com.rong.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强。。。");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强。。。");
    }

    @Around("MyAspect.pointcut()")
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
