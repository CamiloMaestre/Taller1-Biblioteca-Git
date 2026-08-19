package com.mycompany.biblioteca;

public class Book extends Material {

    private String author;
    private boolean isAvailable;

    public Book(String code, String title, String year, String author, boolean isAvailable) {
        super(code, title, year);
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
