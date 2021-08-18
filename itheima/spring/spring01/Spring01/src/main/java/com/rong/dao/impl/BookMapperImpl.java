package com.rong.dao.impl;

import com.rong.dao.BookMapper;

import java.util.*;

public class BookMapperImpl implements BookMapper {

    private List al;
    private Properties properties;
    private int[] arr;
    private Set hs;
    private Map hm;

    public void setAl(List al) {
        this.al = al;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setHs(Set hs) {
        this.hs = hs;
    }

    public void setHm(Map hm) {
        this.hm = hm;
    }

    public void save() {
        System.out.println("BookMapper is running!"+al);
    }
}
