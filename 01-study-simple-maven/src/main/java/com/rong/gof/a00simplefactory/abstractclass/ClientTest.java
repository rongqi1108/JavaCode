package com.rong.gof.a00simplefactory.abstractclass;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:34:06
 */
public class ClientTest {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("dog");
        Animal cat = AnimalFactory.getAnimal("cat");
        dog.call();
        cat.call();
        dog.methodSame();
        cat.methodSame();
        /*结果
        汪汪汪~
        喵喵喵~
        这是一个动物
        这是一个动物
        */
    }
}
