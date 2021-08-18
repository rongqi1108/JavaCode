package com.rong.anno;

import org.springframework.stereotype.Component;

@Component("target2")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("保存中......");
    }
//    int i = 1/0;
}
