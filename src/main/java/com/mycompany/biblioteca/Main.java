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

    static void ListClients(){
        System.out.println("Lista de clientes");
        if(clients.isEmpty()){
            System.out.println("No hay clientes registrados");
        }
        else{
            for(Client client : clients){
                System.out.println("ID: " + client.getId() +
                                   ", Nombre: " + client.getName() +
                                   ", Celular: " + client.getCellphone() +
                                   ", Correo: " + client.getEmail());
            }
        }
    }

    static void Client findClientById(String id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;

    }
    



    public static void main(String[] args) {

    }
}