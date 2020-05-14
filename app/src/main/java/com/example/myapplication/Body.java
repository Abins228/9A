package com.example.myapplication;

import java.io.Serializable;

public class Body implements Serializable,Idetificate {
    private int id;
    private String name;
    private String form;
    private String form_factors;
    private String price;
    private String dns;

    public Body(int id, String name, String form, String form_factors, String price, String dns) {
        this.id = id;
        this.name = name;
        this.form = form;
        this.form_factors = form_factors;
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
        return form_factors + ", " + form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getForm_factors() {
        return form_factors;
    }

    public void setForm_factors(String form_factors) {
        this.form_factors = form_factors;
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
