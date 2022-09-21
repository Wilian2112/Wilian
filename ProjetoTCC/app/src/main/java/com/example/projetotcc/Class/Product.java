package com.example.projetotcc.Class;

public class Product {

    private String id;
    private Object photo;
    private String name;
    private int amount;
    private float price;
    private String stockID;

    public Product(String id, Object photo, String name, int amount, float price, String stockID) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.stockID = stockID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStockID() {
        return stockID;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }
}
