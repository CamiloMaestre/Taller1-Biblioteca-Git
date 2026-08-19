package com.mycompany.biblioteca;

public class Client extends Person{

    private String Email;

    public Client(String id, String name, String cellphone, String email) {
        super(id, name, cellphone);
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
