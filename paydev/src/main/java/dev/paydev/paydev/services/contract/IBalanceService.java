package dev.paydev.paydev.services.contract;

import java.util.Map;

import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.UserRepository;

public interface IBalanceService {
    public Map<String, Object> GetUserBalance(Long id);
    public User updateUserBalance(Long userId, double ammount);
}
