package com.cn.scitc.mapper;

import java.util.List;

public interface MovieMapper {
    void insert(Movie movie);
    List<Movie> findAll();
}
