package com.rong;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: RQ
 * @Date: 2023-02-24 17:00:53
 */
public class CommonTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream().collect(Collectors.toSet());
    }
}
