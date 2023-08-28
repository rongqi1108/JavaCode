package com.rong.gof.a01factory;

import com.rong.gof.a00simplefactory.interfacemethod.Animal;

/**
 * 工厂模式 将工厂抽象化 一个具体实例一个工厂
 * @Author: RQ
 * @Date: 2023-02-25 14:45:09
 */
public interface AnimalFactory {
    Animal getAnimal();
}
