package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Tour implements Serializable {
    private int id;
    private int idCategoryTour;
    private String picture;
    private String name;
    private String location;
    private String detail;
    private double score;
    private double price;
    private String hour;
    private String food;
    private String bed;

    public Tour(int id, int idCategoryTour, String picture, String name, String location, String detail,
                double score, double price, String hour, String food, String bed) {
        this.id = id;
        this.idCategoryTour = idCategoryTour;
        this.picture = picture;
        this.name = name;
        this.location = location;
        this.detail = detail;
        this.score = score;
        this.price = price;
        this.hour = hour;
        this.food = food;
        this.bed = bed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoryTour() {
        return idCategoryTour;
    }

    public void setIdCategoryTour(int idCategoryTour) {
        this.idCategoryTour = idCategoryTour;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", idCategoryTour=" + idCategoryTour +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", score=" + score +
                ", price=" + price +
                ", hour='" + hour + '\'' +
                ", food='" + food + '\'' +
                ", bed='" + bed + '\'' +
                '}';
    }


}
