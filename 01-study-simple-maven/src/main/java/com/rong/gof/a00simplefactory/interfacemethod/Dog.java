package com.rong.gof.a00simplefactory.interfacemethod;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:55:34
 */
public class Dog implements Animal{
    @Override
    public void call() {
        System.out.println("汪汪汪~");
    }
}
