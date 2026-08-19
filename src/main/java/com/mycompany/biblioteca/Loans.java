package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loans {

        private String loanId;
        private Client client;
        private Book book;
        private LocalDate date;
        private String status;

        public Loans(String loanId, Client client, Book book) {
            this.loanId = loanId;
            this.client = client;
            this.book = book;
            this.date = LocalDate.now();
            this.status = "PRESTADO";
        }

        public String getLoanId() {
            return loanId;
        }

        public void setLoanId(String loanId) {
            this.loanId = loanId;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Loan ID: " + loanId +
                    " | Client: " + client.getName() +
                    " | Book: '" + book.getTitle() + "'" +
                    " | Date: " + date +
                    " | Status: " + status;
        }
    }

