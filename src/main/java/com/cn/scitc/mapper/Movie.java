package com.cn.scitc.mapper;

public class Movie {
    private String id;
    private String director;
    private String title;
    private String cover;
    private String rate;
    private String castes;

    public void newMovie(String id, String director, String title, String cover, String rate, String castes) {
        this.id = id;
        this.director = director;
        this.title = title;
        this.cover = cover;
        this.rate = rate;
        this.castes = castes;
    }
}
