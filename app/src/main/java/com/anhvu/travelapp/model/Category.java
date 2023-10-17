package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int id;
    private String title;
    private String picPath;

    public Category(int id,String title, String picPath) {
        this.id=id;
        this.title = title;
        this.picPath = picPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
