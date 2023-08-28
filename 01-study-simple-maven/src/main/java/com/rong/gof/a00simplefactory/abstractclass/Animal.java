package com.rong.gof.a00simplefactory.abstractclass;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:27:51
 */
public abstract class Animal {
    private String name;
    //所有动物的共用方法
    public void methodSame(){
        System.out.println("这是一个动物");
    }

    //抽象各自方法
    public  abstract void call();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
