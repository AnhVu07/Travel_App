package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Cruise implements Serializable {
    private int id;
    private int idCategoryCruise;
    private String name;
    private String picture;
    private String location;
    private double score;
    private double price;
    private String detail;
    private String bed;
    private String food;
    private String wifi;

    public Cruise(int id, int idCategoryCruise, String name, String picture, String location,
                  double score, double price, String detail, String bed, String food, String wifi) {
        this.id = id;
        this.idCategoryCruise = idCategoryCruise;
        this.name = name;
        this.picture = picture;
        this.location = location;
        this.score = score;
        this.price = price;
        this.detail = detail;
        this.bed = bed;
        this.food = food;
        this.wifi = wifi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoryCruise() {
        return idCategoryCruise;
    }

    public void setIdCategoryCruise(int idCategoryCruise) {
        this.idCategoryCruise = idCategoryCruise;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", idCategoryCruise=" + idCategoryCruise +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                ", score=" + score +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", bed='" + bed + '\'' +
                ", food='" + food + '\'' +
                ", wifi='" + wifi + '\'' +
                '}';
    }
}
