package com.rong.gof.a01factory;

import com.rong.gof.a00simplefactory.interfacemethod.Animal;
import com.rong.pojo.Duck;

/**
 * @Author: RQ
 * @Date: 2023-02-25 17:26:37
 */
public class DuckFactory implements AnimalFactory{
    @Override
    public Animal getAnimal() {
        return new Duck();
    }
}
