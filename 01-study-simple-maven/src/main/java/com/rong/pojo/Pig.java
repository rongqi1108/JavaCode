package com.rong.pojo;

import com.rong.gof.a00simplefactory.interfacemethod.Animal;

/**
 * @Author: RQ
 * @Date: 2023-02-25 17:14:51
 */
public class Pig implements Animal {
    @Override
    public void call() {
        System.out.println("哼哼哼~");
    }
}
