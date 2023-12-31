package com.anhvu.travelapp.model;

import java.io.Serializable;

public class CategoryFood implements Serializable {
    private int id;
    private String name;
    private String picture;

    public CategoryFood(int id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "CategoryFood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
