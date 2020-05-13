package com.example.myapplication;

import java.io.Serializable;

public class CPU implements Serializable,Idetificate {
    private int id;
    private String name;
    private String processor_socket;
    private String cpu_speed;
    private String cores_threads;
    private String ddr;
    private String price;
    private String dns;

    public CPU(int id, String name, String processor_socket, String cpu_speed, String cores_thread, String ddr, String price, String dns) {
        this.id = id;
        this.name = name;
        this.processor_socket = processor_socket;
        this.cpu_speed = cpu_speed;
        this.cores_threads = cores_thread;
        this.ddr = ddr;
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
        return processor_socket + ", " + cores_threads + ", " + cpu_speed + ", " + ddr + ", " ;
    }

    public String getProcessor_socket() {
        return processor_socket;
    }

    public void setProcessor_socket(String processor_socket) {
        this.processor_socket = processor_socket;
    }

    public String getCpu_speed() {
        return cpu_speed;
    }

    public void setCpu_speed(String cpu_speed) {
        this.cpu_speed = cpu_speed;
    }

    public String getCores_thread() {
        return cores_threads;
    }

    public void setCores_thread(String cores_thread) {
        this.cores_threads = cores_thread;
    }

    public String getDdr() {
        return ddr;
    }

    public void setDdr(String ddr) {
        this.ddr = ddr;
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
