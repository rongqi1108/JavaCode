package com.rong.java8.npnr;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ryan
 * @time 2023/2/7 8:39 下午
 */
@Slf4j
public class NoParamNoReturnTest {

    public static void startDo(NoParamNoReturn noParamNoReturn) {
        noParamNoReturn.doSomeThing();
    }

    public static void main(String[] args) {
        // 匿名内部类方式去写
        startDo(new NoParamNoReturn() {
            @Override
            public void doSomeThing() {
                log.info("匿名内部类方式去写");
            }
        });
        startDo(()-> System.out.println("lambda表达式去写"));
    }
}
