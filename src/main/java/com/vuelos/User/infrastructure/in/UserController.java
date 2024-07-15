package com.vuelos.User.infrastructure.in;

import java.util.Scanner;

import com.vuelos.User.application.CreateUserUseCase;
import com.vuelos.User.domain.entity.User;

public class UserController {
    private  CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter user name: ");
            String name = scanner.nextLine();

            System.out.println("Enter user email: ");
            String email = scanner.nextLine();

            User user = new User();
            user.setName(name);
            user.setEmail(email);

            createUserUseCase.execute(user);
        }

        System.out.println("User created successfully!");
    }
}

