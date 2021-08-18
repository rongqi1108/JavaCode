package com.rong.proxy.cglib;

import com.rong.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //1. 目标对象
        final Target target = new Target();
        //2. 增强对象
        final Advice advice = new Advice();
        //3. 代理对象
            //1)创建增强器
        Enhancer enhancer = new Enhancer();
            //2)设置父类（目标）
        enhancer.setSuperclass(Target.class);
            //3)设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return invoke;
            }
        });
            //4)创建代理对象
        Target proxy = (Target) enhancer.create();
        //4. 调用代理对象的方法
        proxy.save();
    }
}
