package dev.paydev.paydev.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paydev.paydev.domain.ViewModels.TransactionViewModel;
import dev.paydev.paydev.domain.transaction.Transaction;
import dev.paydev.paydev.repository.services.TransactionService;


@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    private final TransactionService _transactionService;

    public TransactionController(TransactionService transactionService) {
        this._transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> getUserTransactionHistory(@PathVariable Long id) {
        List<Transaction> userTransactions = _transactionService.getUserTransactions(id);
        return ResponseEntity.ok(userTransactions);
    }
    
    @PostMapping()
    public ResponseEntity<Object> userTransaction (@RequestBody TransactionViewModel transaction) {
        Object transactionReq = _transactionService.userTransaction(transaction);
        return ResponseEntity.ok(transactionReq);
    }
    
}
