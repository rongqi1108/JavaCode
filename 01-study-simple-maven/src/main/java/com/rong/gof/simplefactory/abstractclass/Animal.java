package com.rong.gof.simplefactory.abstractclass;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:27:51
 */
abstract class Animal {
    //所有动物的共用方法
    public void methodSame(){
        System.out.println("这是一个动物");
    }

    //抽象各自方法
    public  abstract void call();
}
