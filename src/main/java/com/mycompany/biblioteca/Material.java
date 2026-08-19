package com.mycompany.biblioteca;

public class Material {

    private String code;
    private String title;
    private String year;

    public Material(String code, String title, String year) {
        this.code = code;
        this.title = title;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
