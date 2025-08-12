package dev.paydev.paydev.services.contract;

import java.util.List;
import java.util.Map;

import dev.paydev.paydev.domain.ViewModels.TransactionViewModel;
import dev.paydev.paydev.domain.transaction.Transaction;

public interface ITransactionService {
    public List<Transaction> getUserTransactions(Long id);
    public Map<String, Object> userTransaction(TransactionViewModel transaction);
}
