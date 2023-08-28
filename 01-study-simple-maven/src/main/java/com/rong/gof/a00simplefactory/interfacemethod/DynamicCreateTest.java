package com.rong.gof.a00simplefactory.interfacemethod;

import com.rong.io.xml.DomReadXml;
import com.rong.io.yml.YamlReader;

/**
 *   <dependency>
 *      <groupId>org.yaml</groupId>
 *      <artifactId>snakeyaml</artifactId>
 *      <version>1.26</version>
 *  </dependency>
 * @Author: RQ
 * @Date: 2023-02-08 11:03:50
 */
public class DynamicCreateTest {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(DomReadXml.getOneFromXml("animal-config.xml", "animalName"));
        animal.methodSame();
        animal.call();
        Animal animal2 = AnimalFactory.getAnimal(YamlReader.getValueByKey("test.yml", "animal.name").toString());
        animal2.methodSame();
        animal2.call();
        /*
        这是一个动物
        汪汪汪~
        这是一个动物
        喵喵喵~
        */
    }
}
