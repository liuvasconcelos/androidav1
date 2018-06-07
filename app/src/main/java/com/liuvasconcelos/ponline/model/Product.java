package com.liuvasconcelos.ponline.model;

public class Product {
    private String name;
    private String description;
    private String id;
    private String price;
    private String deliveryTime;

    public Product (String id, String name, String description, String price, String deliveryTime) {
        this.id           = id;
        this.name         = name;
        this.description  = description;
        this.price        = price;
        this.deliveryTime = deliveryTime;
    }

    public Product() {

    }

    public String getId () {
        return this.id;
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

    public String getDeliveryTime () {
        return this.deliveryTime;
    }

    public String getPrice () {
        return this.price;
    }
}
