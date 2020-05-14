package com.example.myapplication;

import java.io.Serializable;

public class Coolers implements Serializable, Idetificate {

    private int id;
    private String name;
    private String fan_size;
    private String max_vol;
    private String price;
    private String dns;

    public Coolers(int id, String name, String fan_size, String max_vol, String price, String dns) {
        this.id = id;
        this.name = name;
        this.fan_size = fan_size;
        this.max_vol = max_vol;
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
        return fan_size + ", " + max_vol;
    }

    public String getFan_size() {
        return fan_size;
    }

    public void setFan_size(String fan_size) {
        this.fan_size = fan_size;
    }

    public String getMax_vol() {
        return max_vol;
    }

    public void setMax_vol(String max_vol) {
        this.max_vol = max_vol;
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
