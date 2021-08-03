package com.rong.bean;

import lombok.Data;

@Data
public class User {
    private Integer id;//主键id
    private String name;//姓名
    private Integer age;//年龄
    private Integer search_count;//搜索数量

    public User() {
    }

    public User(Integer id, String name, Integer age, Integer search_count) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.search_count = search_count;
    }
}
