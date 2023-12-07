package com.itaubackend.repositories;

import com.itaubackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordRepositories extends JpaRepository<User, Long> {
    Optional<User> findUserbyId(Long id);
}
