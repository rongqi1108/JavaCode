package com.rong.gof.a00simplefactory.interfacemethod;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:56:26
 */
public class AnimalFactory {
    public static Animal getAnimal(String animalName){
        if (animalName.equals("dog")) {
            return new Dog();
        }
        if (animalName.equals("cat")) {
            return new Cat();
        }
        return null;
    }
}
