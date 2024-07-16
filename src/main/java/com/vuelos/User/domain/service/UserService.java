package com.vuelos.User.domain.service;

import com.vuelos.User.domain.entity.User;

public interface UserService {
    void createUser(User user);
    User findUserById(Long id);
}
