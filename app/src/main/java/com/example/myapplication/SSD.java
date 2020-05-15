package com.example.myapplication;

import java.io.Serializable;

public class SSD implements Serializable,Idetificate {
    private int id;
    private String name;
    private String capacity;
    private String writing_speed;
    private String reading_speed;
    private String price;
    private String dns;
    private byte[] image;

    public SSD(int id, String name, String capacity, String writing_speed, String reading_speed, String price, String dns, byte[] image) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.writing_speed = writing_speed;
        this.reading_speed = reading_speed;
        this.price = price;
        this.dns = dns;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return capacity + ", " + reading_speed + ", " + writing_speed;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getWriting_speed() {
        return writing_speed;
    }

    public void setWriting_speed(String writing_speed) {
        this.writing_speed = writing_speed;
    }

    public String getReading_speed() {
        return reading_speed;
    }

    public void setReading_speed(String reading_speed) {
        this.reading_speed = reading_speed;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public void setPrice(String price) {
        this.price = price;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    @Override
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
