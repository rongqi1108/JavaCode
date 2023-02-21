package com.rong.gof.simplefactory.interfacemethod;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:55:58
 */
public class Cat implements Animal{
    @Override
    public void call() {
        System.out.println("喵喵喵~");
    }
}
