package com.rong.gof.simplefactory.interfacemethod;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:54:21
 */
public interface Animal {
    default void methodSame(){
        System.out.println("这是一个动物");
    }
    void call();
}
