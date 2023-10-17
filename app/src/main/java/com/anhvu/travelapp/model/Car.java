package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private int idCategoryCar;
    private String name;
    private String picture;
    private String location;
    private double score;
    private double price;
    private String detail;
    private String seats;
    private String door;
    private String luggages;

    public Car(int id, int idCategoryCruise, String name, String picture, String location,
               double score, double price, String detail, String seats, String door, String luggages) {
        this.id = id;
        this.idCategoryCar = idCategoryCruise;
        this.name = name;
        this.picture = picture;
        this.location = location;
        this.score = score;
        this.price = price;
        this.detail = detail;
        this.seats = seats;
        this.door = door;
        this.luggages = luggages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoryCar() {
        return idCategoryCar;
    }

    public void setIdCategoryCar(int idCategoryCar) {
        this.idCategoryCar = idCategoryCar;
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

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getLuggages() {
        return luggages;
    }

    public void setLuggages(String luggages) {
        this.luggages = luggages;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "id=" + id +
                ", idCategoryCruise=" + idCategoryCar +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", location='" + location + '\'' +
                ", score=" + score +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", bed='" + seats + '\'' +
                ", food='" + door + '\'' +
                ", wifi='" + luggages + '\'' +
                '}';
    }
}
