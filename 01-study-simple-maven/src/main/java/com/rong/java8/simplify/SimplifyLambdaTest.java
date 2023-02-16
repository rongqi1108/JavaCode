package com.rong.java8.simplify;

import com.rong.java8.hphr.HavParHavRet1;
import com.rong.java8.hphr.HavParHavRet2;

/**
 * @author Ryan
 * @time 2023/2/7 9:26 下午
 */
public class SimplifyLambdaTest {
    public static void do1(HavParHavRet1 havParHavRet1) {
        havParHavRet1.run("bsjs");
    }
    public static void do2(HavParHavRet2 havParHavRet2) {
        havParHavRet2.run("bsjs",23);
    }
    public static void main(String[] args) {
        do1(x -> 666);
        do2((name, age) -> 666);
    }
}
