package com.anhvu.travelapp.model;

import java.io.Serializable;

public class Domains implements Serializable {

    private int id;
    private int id_category;
    private String title;
    private String location;
    private int bed;
    private String description;
    private double score;
    private String wifi;
    private String guide;
    private String pic;
    private double price;

    public Domains(String title, String location,String description, int bed, double score, String wifi, String guide, String pic, double price) {
        this.title = title;
        this.location = location;
        this.bed = bed;
        this.score = score;
        this.description=description;
        this.wifi = wifi;
        this.guide = guide;
        this.pic = pic;
        this.price = price;
    }

    public Domains(int id, int id_category, String title, String location, String description, int bed
            , double score, String wifi, String guide, String pic, double price) {
        this.id = id;
        this.id_category = id_category;
        this.title = title;
        this.location = location;
        this.bed = bed;
        this.description = description;
        this.score = score;
        this.wifi = wifi;
        this.guide = guide;
        this.pic = pic;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String isWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String isGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
