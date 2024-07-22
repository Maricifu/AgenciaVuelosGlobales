package com.vuelos;

import com.vuelos.User.application.UserService;
import com.vuelos.User.infrastructure.out.UserRepository;
import config.SecurityManager;
import com.vuelos.User.domain.entity.User;
import java.util.Optional;

public class TestApplication {
    public static void main(String[] args) {
        // Configurar el repositorio y servicio
        UserRepository userRepository = new UserRepository();
        UserService userService = userRepository;

        // Configurar el SecurityManager
        SecurityManager.setUserService(userService);

        // Probar la autenticación
        Optional<User> authenticatedUser = SecurityManager.authenticate("test_user", "password123");
        if (authenticatedUser.isPresent()) {
            System.out.println("Authentication successful for user: " + authenticatedUser.get().getName());
        } else {
            System.out.println("Authentication failed.");
        }

        // Probar la autorización
        if (authenticatedUser.isPresent()) {
            User user = authenticatedUser.get();
            boolean hasPermission = SecurityManager.authorize(user, "create_user");
            System.out.println("User " + user.getName() + " has create_user permission: " + hasPermission);
        }
    }
}

