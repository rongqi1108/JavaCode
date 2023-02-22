package com.rong.io.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: RQ
 * @Date: 2023-01-21 23:14:11
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream inputStream = PropertiesTest.class.getClassLoader().getResourceAsStream("test.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("password"));
    }
}
