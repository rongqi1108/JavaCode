package com.rong.java8.hphr;

import com.rong.java8.pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ryan
 * @time 2023/2/7 9:12 下午
 */
public class HaveParamHaveReturnTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("周杰伦", 33, 175));
        list.add(new Person("刘德华", 43, 185));
        list.add(new Person("周星驰", 38, 177));
        list.add(new Person("郭富城", 23, 170));
        // 前后比大升小降
        list.sort(Comparator.comparingInt(Person::getAge));
        list.forEach(System.out::println);

    }
}
