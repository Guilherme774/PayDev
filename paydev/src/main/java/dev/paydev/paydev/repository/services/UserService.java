package dev.paydev.paydev.repository.services;

import org.springframework.stereotype.Service;

import dev.paydev.paydev.domain.user.User;
import dev.paydev.paydev.repository.contract.UserRepository;
import dev.paydev.paydev.utils.exception.ResourceNotFoundException;
import dev.paydev.paydev.utils.exception.UserRegisterExceptionHandler;

@Service
public class UserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public User getUser(Long id) {
        return _userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Oh no, that User haven't been found!"));
    }

    public User createUser(User user) {
        if(user.getEmail() == null || user.getName() == null) {
            throw new UserRegisterExceptionHandler("Wait a minute, all the fields are required!");
        }

        return _userRepository.save(user);
    }

    public void DeleteUserAccount(Long id) {
        if(!_userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Oh no, that User haven't been found!");
        }

        _userRepository.deleteById(id);
    }
}
