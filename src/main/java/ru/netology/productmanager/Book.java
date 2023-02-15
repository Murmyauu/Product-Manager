package ru.netology.productmanager;

public class Book extends Product{
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String productName, int price, String name, String author) {
        super(id, productName, price,name);
        this.author = author;
    }
}
