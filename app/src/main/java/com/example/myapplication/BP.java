package com.example.myapplication;

import java.io.Serializable;

public class BP implements Serializable,Idetificate {
    private int id;
    private String name;
    private String type;
    private String power;
    private String price;
    private String dns;
    private byte[] image;

    public BP(int id, String name, String type, String power, String price, String dns,byte[] image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.power = power;
        this.price = price;
        this.dns = dns;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {

        return type +", "+power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPrice() {
        return price;
    }

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
