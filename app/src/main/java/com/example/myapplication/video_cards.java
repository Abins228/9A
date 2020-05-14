package com.example.myapplication;

import java.io.Serializable;

public class video_cards implements Idetificate, Serializable {
    private int id;
    private String name;
    private String capacity;
    private String typeCapasity;
    private String frequency;
    private String price;
    private String dns;

    public video_cards(int id, String name, String capacity, String typeCapasity, String frequency, String price, String dns) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.typeCapasity = typeCapasity;
        this.frequency = frequency;
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
        return capacity+", "+typeCapasity+","+frequency;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getTypeCapasity() {
        return typeCapasity;
    }

    public void setTypeCapasity(String typeCapasity) {
        this.typeCapasity = typeCapasity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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
}
