package com.example.myapplication;

public class Preview {
    int id;
    byte[] image;
    String Name;

    public Preview(int id, byte[] image, String Name) {
        this.id = id;
        this.image = image;
        this.Name = Name;
    }

    public Preview(byte[] image, String descripton) {
        this.image = image;
        this.Name = descripton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescripton() {
        return Name;
    }

    public void setDescripton(String descripton) {
        this.Name = descripton;
    }
}
