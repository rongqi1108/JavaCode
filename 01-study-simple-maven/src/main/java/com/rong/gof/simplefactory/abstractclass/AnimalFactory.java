package com.rong.gof.simplefactory.abstractclass;

/**
 * @Author: RQ
 * @Date: 2023-02-08 10:31:58
 */
public class AnimalFactory {
    public static Animal getAnimal(String animalName) {
        if (animalName.equals("dog")) {
            return new Dog();
        }
        if (animalName.equals("cat")) {
            return new Cat();
        }
        return null;
    }
}
