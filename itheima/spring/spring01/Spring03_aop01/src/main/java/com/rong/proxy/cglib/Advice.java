package com.rong.proxy.cglib;

public class Advice {
    public void before(){
        System.out.println("加载前增强！");
    }
    public void after(){
        System.out.println("加载后增强！");
    }

}
