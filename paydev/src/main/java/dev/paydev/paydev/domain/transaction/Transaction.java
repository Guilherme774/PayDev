package dev.paydev.paydev.domain.transaction;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long userSenderId;
    private Long userReceiverId;
    private double ammount; 
    private LocalDateTime transactionDateTime = LocalDateTime.now();

    public Transaction() { }

    public Transaction(Long userSenderId, Long userReceiverId, double ammount) {
        this.userSenderId = userSenderId;
        this.userReceiverId = userReceiverId;
        this.ammount = ammount;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getUserSenderId() {
        return userSenderId;
    }

    public Long getUserReceiverId() {
        return userReceiverId;
    }

    public double getAmmount() {
        return ammount;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setUserSenderId(Long userSenderId) {
        this.userSenderId = userSenderId;
    }

    public void setUserReceiverId(Long userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
}