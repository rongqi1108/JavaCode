package com.rong.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 测方法所耗时长
 *
 * @Author: RQ
 * @Date: 2023-02-17 13:28:49
 */
@Aspect//通知类
@Slf4j
@Component
public class ElapsedTimeAdvice {

    @Pointcut("execution(*  com.rong.service.PersonService.find*(..))")//切入点
    public void pt() {
    }

    @Around("pt()")//环绕方法
    public Object runtimeMonitor(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature(); //获取执行签名信息
        String targetClass = signature.getDeclaringTypeName();//通过签名获取执行类型（接口名）
        String targetMethod = signature.getName();//通过签名获取执行操作名称（方法名）
        long startMillis = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long endMillis = System.currentTimeMillis();
        log.info("{}#{}所耗时长：{}ms", targetClass, targetMethod, endMillis - startMillis);
        return proceed;
    }
}
