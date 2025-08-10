package dev.paydev.paydev.repository.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.paydev.paydev.domain.ViewModels.TransactionViewModel;
import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.contract.UserRepository;
import dev.paydev.paydev.utils.exception.ResourceNotFoundException;
import dev.paydev.paydev.utils.exception.TransactionExceptionHandler;

@Service
public class TransactionService {
    private final UserRepository _userRepository;

    public TransactionService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public Map<String, Object> userTransaction(TransactionViewModel transaction) {
        if(transaction.getUserSenderId() == transaction.getUserReceiverId()) {
            throw new TransactionExceptionHandler("No no no, The User can't send funds to itself!");
        }

        User userSender = _userRepository.findById(transaction.getUserSenderId())
                            .orElseThrow(() -> new ResourceNotFoundException("Oh no, User sender not found!"));

        User userReceiver = _userRepository.findById(transaction.getUserReceiverId())
                                .orElseThrow(() -> new ResourceNotFoundException("Oh no, User receiver not found!"));

        if(transaction.getAmmount() > userSender.getBalance()) {
            throw new TransactionExceptionHandler("Oh no, You don't have enough funds to complete this transaction");
        }

        userSender.setBalance(userSender.getBalance() - transaction.getAmmount());
        userReceiver.setBalance(userReceiver.getBalance() + transaction.getAmmount());

        _userRepository.save(userSender);
        _userRepository.save(userReceiver);

        Map<String, Object> transactionMessage = new LinkedHashMap<>();
        transactionMessage.put("Message", "Transaction successfully completed!");

        return transactionMessage;
    }
}
