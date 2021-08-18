package com.rong.proxy.jdk;

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
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        advice.after();
                        return invoke;
                    }
                }
        );
        //4. 调用代理对象的方法
        proxy.save();
    }
}
