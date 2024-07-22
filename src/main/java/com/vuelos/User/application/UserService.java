package com.vuelos.User.application;

import java.util.Optional;

import com.vuelos.User.domain.entity.User;

public interface UserService {
    void createUser(User user);
    User findUserById(Long id);
    Optional<User> findByUsername(String username);
}
