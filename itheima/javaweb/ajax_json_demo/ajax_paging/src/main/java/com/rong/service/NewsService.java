package com.rong.service;

import com.github.pagehelper.Page;
import com.rong.bean.News;

import java.util.List;

public interface NewsService {
    Page pageQuery(Integer start,Integer pageSize);
}
