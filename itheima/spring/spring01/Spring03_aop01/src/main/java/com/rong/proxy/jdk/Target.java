package com.rong.proxy.jdk;

public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("保存中......");
    }
}
