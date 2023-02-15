package ru.netology.productmanager;

public class Product {
    protected int id;
    protected String productName;
    protected  int price;
    protected String name;

    public Product(int id, String productName, int price, String name) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
