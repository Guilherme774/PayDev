package dev.paydev.paydev.services.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.paydev.paydev.domain.ViewModels.TransactionViewModel;
import dev.paydev.paydev.domain.transaction.Transaction;
import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.TransactionRepository;
import dev.paydev.paydev.repository.UserRepository;
import dev.paydev.paydev.services.contract.ITransactionService;
import dev.paydev.paydev.utils.exception.ResourceNotFoundException;
import dev.paydev.paydev.utils.exception.TransactionExceptionHandler;

@Service
public class TransactionService implements ITransactionService {
    private final UserRepository _userRepository;
    private final TransactionRepository _transactionRepository;

    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository) {
        this._userRepository = userRepository;
        this._transactionRepository = transactionRepository;
    }

    public List<Transaction> getUserTransactions(Long id) {
        if(!_userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Oh no, that User haven't been found!");
        }

        return _transactionRepository.findAll().stream()
                .filter(t -> t.getUserSenderId().equals(id) ||
                             t.getUserReceiverId().equals(id)).toList();
        
    }

    public Map<String, Object> userTransaction(TransactionViewModel transaction) {
        if(transaction.getUserSenderId() == transaction.getUserReceiverId()) {
            throw new TransactionExceptionHandler("No no no, The User can't send funds to itself!");
        }

        User userSender = _userRepository.findById(transaction.getUserSenderId())
                            .orElseThrow(() -> new ResourceNotFoundException("Oh no, User sender not found!"));

        User userReceiver = _userRepository.findById(transaction.getUserReceiverId())
                                .orElseThrow(() -> new ResourceNotFoundException("Oh no, User receiver not found!"));

        userSender.debitToUserBalance(transaction.getAmmount());
        userReceiver.creditToUserBalance(transaction.getAmmount());

        _userRepository.save(userSender);
        _userRepository.save(userReceiver);
        addNewTransaction(transaction);

        Map<String, Object> transactionMessage = new LinkedHashMap<>();
        transactionMessage.put("message", "Transaction successfully completed!");

        return transactionMessage;
    }

    private void addNewTransaction(TransactionViewModel transaction) {
        Transaction transactionHistory = new Transaction(
            transaction.getUserSenderId(), transaction.getUserReceiverId(), transaction.getAmmount());

        _transactionRepository.save(transactionHistory);
    }
}
