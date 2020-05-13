package com.example.myapplication;

import java.io.Serializable;

public class Motherboards implements Serializable,Idetificate {
    private int id;
    private String name;
    private String soket;
    private String chip;
    private String typeram;
    private String formf;
    private String price;
    private String dns;

    public Motherboards(int id, String name, String socket, String chip, String typeram, String formf, String price, String dns) {
        this.id = id;
        this.name = name;
        this.soket = socket;
        this.chip = chip;
        this.typeram = typeram;
        this.formf = formf;
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
        return soket + ", " + chip + ", " + typeram + ", " + formf + ", " ;
    }

    public String getSoket() {
        return soket;
    }

    public void setSoket(String soket) {
        this.soket = soket;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getTyperam() {
        return typeram;
    }

    public void setTyperam(String typeram) {
        this.typeram = typeram;
    }

    public String getFormf() {
        return formf;
    }

    public void setFormf(String formf) {
        this.formf = formf;
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
