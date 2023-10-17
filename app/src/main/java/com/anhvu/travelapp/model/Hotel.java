package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Hotel implements Serializable {

    private int id;
    private int id_service;
    private String name;
    private String picture;
    private String location;
    private double point;
    private double price;
    private String pool;
    private String food;
    private String wifi;

    public Hotel(int id, int id_service, String name, String picture, String location, double point, double price,
                 String pool,String food,String wifi) {
        this.id = id;
        this.id_service = id_service;
        this.name = name;
        this.picture = picture;
        this.location = location;
        this.point = point;
        this.price = price;
        this.pool = pool;
        this.food = food;
        this.wifi=wifi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
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

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
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
        return "Service{" +
                "id=" + id +
                ", id_service=" + id_service +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                ", point=" + point +
                ", price=" + price +
                '}';
    }
}
