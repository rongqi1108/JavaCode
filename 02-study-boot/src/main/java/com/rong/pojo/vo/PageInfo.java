package com.rong.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ryan
 * @time 2023/2/16 11:45 下午
 */
@Data
public class PageInfo<T> implements Serializable {
    private List<T> records;//集合
    private long total;//总数量
    private long pageCurrent;//当前页
    private long pageSize;//页面大小

    public static <T> PageInfo<T> onlyList(List<T> records) {
        return new PageInfo<>(records, records.size(), 0,0);
    }
    public PageInfo() {
    }

    public PageInfo(List<T> records, long total, long pageCurrent, long pageSize) {
        this.records = records;
        this.total = total;
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
    }
}
