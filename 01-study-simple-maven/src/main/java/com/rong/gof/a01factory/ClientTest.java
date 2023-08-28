package com.rong.gof.a01factory;

import com.rong.gof.a00simplefactory.interfacemethod.Animal;

/**
 * @Author: RQ
 * @Date: 2023-02-25 17:19:56
 */
public class ClientTest {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new DuckFactory();//工厂模式
        Animal animal = animalFactory.getAnimal();
        animal.call();


    }
}
