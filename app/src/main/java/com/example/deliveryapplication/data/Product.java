package com.example.deliveryapplication.data;

public class Product {
    private String name, description;
    private double price;
    private int count =0;
    public int iconResourceId;
    private double total;
    public Product(String name, String description, double price,int iconResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.iconResourceId = iconResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void incrementCount(){
        this.count+=1;
    }
    public void decrementCount(){
        this.count-=1;
    }

    public int getCount() {
        return count;
    }
    public void calculateTotal(){
        this.total = price *count;
    }

    public double getTotal() {
        return total;
    }
}
