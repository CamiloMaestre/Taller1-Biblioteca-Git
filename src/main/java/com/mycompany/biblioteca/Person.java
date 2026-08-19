package com.mycompany.biblioteca;

public class Person {

    private String id;
    private String name;
    private String Cellphone;

    public Person(String id, String name, String cellphone) {
        this.id = id;
        this.name = name;
        Cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public void setCellphone(String cellphone) {
        Cellphone = cellphone;
    }
}


