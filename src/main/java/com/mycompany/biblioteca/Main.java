package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addClient() {
        System.out.println("Ingrese el ID del cliente:");
        String id = sc.nextLine();
        System.out.println("Ingrese el nombre del cliente:");
        String name = sc.nextLine();
        System.out.println("Ingrese el celular del cliente:");
        String cellphone = sc.nextLine();
        System.out.println("Ingrese el correo electrónico del cliente:");
        String email = sc.nextLine();

        Client client = new Client(id, name, cellphone, email);
        clients.add(client);
    }

    public static void main(String[] args) {

    }
}