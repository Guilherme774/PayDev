package dev.paydev.paydev.services.contract;

import dev.paydev.paydev.domain.user.User;

public interface IUserService {
    public User getUser(Long id);
    public User createUser(User user);
    public void DeleteUserAccount(Long id);
}
