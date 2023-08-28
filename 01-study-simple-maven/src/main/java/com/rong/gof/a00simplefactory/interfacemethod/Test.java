package com.rong.gof.a00simplefactory.interfacemethod;

/**
 * @Author: RQ
 * @Date: 2023-02-08 11:03:50
 */
public class Test {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("dog");
        Animal cat = AnimalFactory.getAnimal("cat");
        dog.call();
        dog.methodSame();
        cat.call();
        cat.methodSame();
        /*结果
        汪汪汪~
        这是一个动物
        喵喵喵~
        这是一个动物
        */
    }
}
