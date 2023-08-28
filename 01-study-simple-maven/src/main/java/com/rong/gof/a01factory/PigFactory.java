package com.rong.gof.a01factory;

import com.rong.gof.a00simplefactory.interfacemethod.Animal;
import com.rong.pojo.Pig;

/**
 * @Author: RQ
 * @Date: 2023-02-25 17:13:26
 */
public class PigFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Pig();
    }
}
