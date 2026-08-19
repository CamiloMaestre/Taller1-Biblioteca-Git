package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

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

    public static Client findClientById(String id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;

    }

    public static void Update(String id) {
        Client client = findClientById(id);
        if (client != null) {
            System.out.println("Ingrese el nuevo nombre del cliente:");
            String name = sc.nextLine();
            System.out.println("Ingrese el nuevo celular del cliente:");
            String cellphone = sc.nextLine();
            System.out.println("Ingrese el nuevo correo electrónico del cliente:");
            String email = sc.nextLine();

            client.setName(name);
            client.setCellphone(cellphone);
            client.setEmail(email);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void Delete(String id) {
        Client client = findClientById(id);
        if (client != null) {
            clients.remove(client);
            System.out.println("Cliente eliminado");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    //Crud de libros

    static void createBook() {
        System.out.println("Ingrese el código del libro:");
        String code = sc.nextLine();
        System.out.println("Ingrese el título del libro:");
        String title = sc.nextLine();
        System.out.println("Ingrese el año del libro:");
        String year = sc.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String author = sc.nextLine();
        System.out.println("Ingrese si el libro está disponible (true/false):");
        boolean isAvailable = Boolean.parseBoolean(sc.nextLine());

        Book book = new Book(code, title, year, author, isAvailable);
        books.add(book);
    }

    static void listBooks() {
        System.out.println("Lista de libros");
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados");
        } else {
            for (Book book : books) {
                System.out.println("Código: " + book.getCode() +
                                   ", Título: " + book.getTitle() +
                                   ", Año: " + book.getYear() +
                                   ", Autor: " + book.getAuthor() +
                                   ", Disponible: " + book.isAvailable());
            }
        }
    }

    public static Book findBook(String id) {
        for (Book book : books) {
            if (book.getCode().equals(id)) {
                return book;
            }
        }
        return null;
    }



    public static void main(String[] args) {

    }
}