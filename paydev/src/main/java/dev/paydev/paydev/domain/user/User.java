package dev.paydev.paydev.domain.user;

import dev.paydev.paydev.utils.exception.TransactionExceptionHandler;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private double balance;

    public User() { }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.balance = 0.0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void creditToUserBalance(double ammount) {
        if(ammount <= 0) {
            throw new TransactionExceptionHandler("Hey, that value is invalid to realize that transaction!");
        }

        this.balance += ammount;
    }

    public void debitToUserBalance(double ammount) {
        if(this.balance < ammount) {
            throw new TransactionExceptionHandler("Oh no, You don't have enough funds to complete this transaction");
        }
        if(ammount <= 0) {
            throw new TransactionExceptionHandler("Hey, that value is invalid to realize that transaction!");
        }

        this.balance -= ammount;
    }
}
