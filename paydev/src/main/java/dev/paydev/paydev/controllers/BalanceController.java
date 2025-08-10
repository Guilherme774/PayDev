package dev.paydev.paydev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paydev.paydev.domain.ViewModels.UserBalanceViewModel;
import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.services.BalanceService;

@RestController
@RequestMapping("/api/v1/balance")
public class BalanceController {
    private final BalanceService _balanceService;

    public BalanceController(BalanceService balanceService) {
        this._balanceService = balanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserBalance(@PathVariable Long id) {
        Object userBalance = _balanceService.GetUserBalance(id);
        return ResponseEntity.ok(userBalance);
    }

    @PutMapping()
    public ResponseEntity<User> addUserBalance(@RequestBody UserBalanceViewModel userBalance) {
        User userUpdated = _balanceService.updateUserBalance(userBalance.getUserId(), userBalance.getAmmount());
        return ResponseEntity.ok(userUpdated);
    }
}