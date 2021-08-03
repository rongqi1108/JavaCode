package com.rong.bean;

import lombok.Data;

@Data
public class News {
    private Integer id;//主键id
    private String title;//新闻标题

    public News() {
    }

    public News(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
