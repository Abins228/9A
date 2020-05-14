package com.example.myapplication;

import java.io.Serializable;

public class HDD implements Idetificate, Serializable {
    private int id;
    private String name;
    private String capacity;
    private String maxrw;
    private String price;
    private String dns;

    public HDD(int id, String name, String capacity, String maxrw, String price, String dns) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.maxrw = maxrw;
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
        return capacity+ ", "+maxrw;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getMaxrw() {
        return maxrw;
    }

    public void setMaxrw(String maxrw) {
        this.maxrw = maxrw;
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
