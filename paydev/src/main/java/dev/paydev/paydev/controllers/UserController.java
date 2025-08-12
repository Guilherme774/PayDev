package dev.paydev.paydev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.services.contract.IUserService;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService _userService;

    public UserController(IUserService userService) {
        this._userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = _userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = _userService.createUser(user);
        return ResponseEntity.ok(userCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        _userService.DeleteUserAccount(id);
        return ResponseEntity.ok("User account deleted!");
    }
}