package com.example.myapplication;

import java.io.Serializable;

public class Coolers_CPU implements Idetificate, Serializable {
    private int id;
    private String name;
    private String power;
    private String noise_level;
    private String price;
    private String dns;

    public Coolers_CPU(int id, String name, String power, String noise_level, String price, String dns) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.noise_level = noise_level;
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
        return power + ", " + noise_level ;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getNoise_level() {
        return noise_level;
    }

    public void setNoise_level(String noise_level) {
        this.noise_level = noise_level;
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
