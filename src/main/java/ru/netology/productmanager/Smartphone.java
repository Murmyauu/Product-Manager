package ru.netology.productmanager;

public class Smartphone extends Product {
    private String producer;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Smartphone(int id, String productName, int price, String name, String producer) {
        super(id, productName, price, name);
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (getProducer().matches(search)) {
            return true;
        } else {
            return false;
        }
    }
}
