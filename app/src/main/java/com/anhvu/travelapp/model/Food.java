package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String name;
    private String picture;
    private String restaurant;
    private String detail;
    private int table;
    private double price;
    private double dot;
    private int idCategoryFood;

    public Food(int id, String name, String picture, String restaurant, String detail, int table, double price, double dot, int idCategoryFood) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.restaurant = restaurant;
        this.detail = detail;
        this.table = table;
        this.price = price;
        this.dot = dot;
        this.idCategoryFood = idCategoryFood;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDot() {
        return dot;
    }

    public void setDot(double dot) {
        this.dot = dot;
    }

    public int getIdCategoryFood() {
        return idCategoryFood;
    }

    public void setIdCategoryFood(int idCategoryFood) {
        this.idCategoryFood = idCategoryFood;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
