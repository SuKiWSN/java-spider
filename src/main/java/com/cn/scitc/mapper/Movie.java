package com.cn.scitc.mapper;
import com.cn.scitc.mapper.spider.*;

public class Movie {
    private int id;
    private String name;
    private String img;
    private String time;
    private String comment;

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getImg() {
        return this.img;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return this.time;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getComment() {
        return this.comment;
    }
}
