package com.rong.io.yml;

/**
 * @Author: RQ
 * @Date: 2023-02-08 14:06:19
 */
public class Test {
    public static void main(String[] args) {
        Object name = YamlReader.getValueByKey("test.yml", "name.a.b.c");
        System.out.println(name);
        String b = "";
        Integer a = 100;
        int i = Integer.parseInt(b);
        System.out.println(i);
        System.out.println(a.equals(i));
    }
}
