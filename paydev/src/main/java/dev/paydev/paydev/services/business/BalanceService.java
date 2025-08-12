package dev.paydev.paydev.services.business;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.UserRepository;
import dev.paydev.paydev.services.contract.IBalanceService;
import dev.paydev.paydev.utils.exception.ResourceNotFoundException;

@Service
public class BalanceService implements IBalanceService {
    private final UserRepository _userRepository;

    public BalanceService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public Map<String, Object> GetUserBalance(Long id) {
        User user = _userRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Oh no, that User haven't been found"));

        Map<String, Object> userBalance = new LinkedHashMap<>();
        userBalance.put("balance", user.getBalance());

        return userBalance;
    }

    public User updateUserBalance(Long userId, double ammount) {
        User user = _userRepository.findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("Oh no, that User haven't been found!"));

        double userNewBalanceValue = user.getBalance() + ammount;

        user.setBalance(userNewBalanceValue);
        _userRepository.save(user);

        return user;
    }
}
