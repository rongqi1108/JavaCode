package com.rong.java8.function;

import com.rong.java8.pojo.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Ryan
 * @time 2023/2/7 9:37 下午
 */
@Slf4j
public class FunctionTest {
    public static void getSomeOne(Supplier<Person> supplier){
        Person person = supplier.get();
        log.info("{}", person);
    }
    public static void getSomeOne(Person person, Consumer<Person> consumer){
        consumer.accept(person);
        log.info("{}", person);
    }


    public static void main(String[] args) {
        Person person = new Person("张叶祺", 23, 166);
        getSomeOne(() -> person);
        getSomeOne(person, System.out::println);
        getSomeOne(person, x -> log.info("xi"));


    }
}
