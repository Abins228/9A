package com.example.myapplication;

import java.io.Serializable;

public class RAM implements Serializable, Idetificate {
    private int id;
    private String name;
    private String capacity;
    private String ram_speed;
    private String number_of_modules;
    private String price;
    private String dns;
    private String ram_type;
    private byte[] image;

    public RAM(int id, String name, String capacity, String ram_speed, String number_of_modules, String price, String dns, String ram_type, byte[] image) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.ram_speed = ram_speed;
        this.number_of_modules = number_of_modules;
        this.price = price;
        this.dns = dns;
        this.ram_type = ram_type;
        this.image = image;
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
        return capacity + ", " + ram_speed + ", " + ram_type + ", " + number_of_modules;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRam_speed() {
        return ram_speed;
    }

    public void setRam_speed(String ram_speed) {
        this.ram_speed = ram_speed;
    }

    public String getNumber_of_modules() {
        return number_of_modules;
    }

    public void setNumber_of_modules(String number_of_modules) {
        this.number_of_modules = number_of_modules;
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

    public String getRam_type() {
        return ram_type;
    }

    public void setRam_type(String ram_type) {
        this.ram_type = ram_type;
    }

    @Override
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
