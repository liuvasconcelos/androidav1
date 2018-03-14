package com.liuvasconcelos.ponline.model;

public class Product {
    private int image;
    private String name;
    private String description;

    public Product (int image, String name, String description) {
        this.image       = image;
        this.name        = name;
        this.description = description;
    }

    public int getImage () {
        return this.image;
    }

    public void setImage (int image) {
        this.image = image;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getDescription () {
        return this.description;
    }

    public void setDescription (String description) {
        this.description = description;
    }
}
