package com.vuelos.User.application;

import com.vuelos.User.domain.entity.User;

public class CreateUserUseCase {
    private final UserService userService;

    public CreateUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(User user) {
        // Aquí puedo agregar lógica adicional, como validaciones o asignaciones de roles
        userService.createUser(user);
    }
}
