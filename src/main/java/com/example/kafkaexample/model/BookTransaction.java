package com.example.kafkaexample.model;

public class BookTransaction {
    private String isbn;
    private TransactionType transactionType;
    private int amount;

    public BookTransaction() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BookTransaction{" +
                "isbn='" + isbn + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                '}';
    }
}
