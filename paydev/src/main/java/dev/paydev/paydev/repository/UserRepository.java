package dev.paydev.paydev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paydev.paydev.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
