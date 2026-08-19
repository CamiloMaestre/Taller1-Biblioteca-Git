package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loans> loans = new ArrayList<>();

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

    public static void Update() {
        System.out.println("Ingrese el ID del cliente a actualizar:");
        String id = sc.nextLine();
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

    public static void Delete() {
        System.out.println("Ingrese el ID del cliente a eliminar:");
        String id = sc.nextLine();
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

    public static void updateBook() {
        System.out.println("Ingrese el código del libro a actualizar:");
        String id = sc.nextLine();
        Book book = findBook(id);
        if (book != null) {
            System.out.println("Ingrese el nuevo título del libro:");
            String title = sc.nextLine();
            System.out.println("Ingrese el nuevo año del libro:");
            String year = sc.nextLine();
            System.out.println("Ingrese el nuevo autor del libro:");
            String author = sc.nextLine();
            System.out.println("Ingrese si el libro está disponible (true/false):");
            boolean isAvailable = Boolean.parseBoolean(sc.nextLine());

            book.setTitle(title);
            book.setYear(year);
            book.setAuthor(author);
            book.setAvailable(isAvailable);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void deleteBook() {
        System.out.println("Ingrese el código del libro a eliminar:");
        String id = sc.nextLine();
        Book book = findBook(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Libro eliminado");
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    // Crud de préstamos

    static void createLoan() {
        System.out.println("Ingrese el ID del préstamo:");
        String loanId = sc.nextLine();
        System.out.println("Ingrese el ID del cliente:");
        String clientId = sc.nextLine();
        Client client = findClientById(clientId);
        if (client == null) {
            System.out.println("Cliente no encontrado");
            return;
        }
        System.out.println("Ingrese el código del libro:");
        String bookCode = sc.nextLine();
        Book book = findBook(bookCode);
        if (book == null) {
            System.out.println("Libro no encontrado");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("El libro no está disponible");
            return;
        }
        Loans loan = new Loans(loanId, client, book);
        loans.add(loan);
        book.setAvailable(false);
    }

    public static void returnBook() {
        System.out.println("Ingrese el ID del préstamo a devolver:");
        String loanId = sc.nextLine();
        for (Loans loan : loans) {
            if (loan.getLoanId().equals(loanId)) {
                loan.setStatus("DEVUELTO");
                loan.getBook().setAvailable(true);
                System.out.println("Libro devuelto");
                return;
            }
        }
        System.out.println("Préstamo no encontrado");
    }
    static void listLoans() {
        System.out.println("Lista de préstamos");
        if (loans.isEmpty()) {
            System.out.println("No hay préstamos registrados");
        } else {
            for (Loans loan : loans) {
                System.out.println("ID del préstamo: " + loan.getLoanId() +
                        ", Cliente: " + loan.getClient().getName() +
                        ", Libro: " + loan.getBook().getTitle() +
                        ", Fecha: " + loan.getDate() +
                        ", Estado: " + loan.getStatus());
            }
        }
    }

    public static void main(String[] args) {

        // Aquí puedes agregar un menú para interactuar con el sistema de biblioteca
        int option = 0;

        do {
            System.out.println("\n=================================");
            System.out.println("   SISTEMA DE GESTIÓN BIBLIOTECA ");
            System.out.println("=================================");
            System.out.println("1.  Agregar Cliente");
            System.out.println("2.  Listar Clientes");
            System.out.println("3.  Actualizar Cliente");
            System.out.println("4.  Eliminar Cliente");
            System.out.println("---------------------------------");
            System.out.println("5.  Agregar Libro");
            System.out.println("6.  Listar Libros");
            System.out.println("7.  Actualizar Libro");
            System.out.println("8.  Eliminar Libro");
            System.out.println("---------------------------------");
            System.out.println("9.  Registrar Préstamo");
            System.out.println("10. Listar Préstamos");
            System.out.println("11. Devolver Libro");
            System.out.println("---------------------------------");
            System.out.println("12. Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opción: ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                option = -1;
            }

            switch (option) {
                case 1: addClient(); break;
                case 2: ListClients(); break;
                case 3: Update(); break;
                case 4: Delete(); break;
                case 5: createBook(); break;
                case 6: listBooks(); break;
                case 7: updateBook(); break;
                case 8: deleteBook(); break;
                case 9: createLoan(); break;
                case 10: listLoans(); break;
                case 11: returnBook(); break;
                case 12:
                    System.out.println("\n¡Saliendo del sistema... Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 12);
    }
}

