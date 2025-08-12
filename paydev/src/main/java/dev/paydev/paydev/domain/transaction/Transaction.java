package dev.paydev.paydev.domain.transaction;

import java.time.LocalDateTime;

import dev.paydev.paydev.utils.exception.TransactionExceptionHandler;
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

    public void setAmmount(double ammount) {
        if(ammount <= 0) {
            throw new TransactionExceptionHandler("Hey, that value is invalid to realize that transaction!");
        }

        this.ammount = ammount;
    }
}