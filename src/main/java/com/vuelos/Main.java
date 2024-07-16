package com.vuelos;

import java.util.Scanner;

import Plane.application.CreatePlaneUseCase;
import Plane.application.FindPlaneByIdUseCase;
import Plane.application.UpdatePlaneUseCase;
import Plane.application.DeletePlaneUseCase;
import Plane.application.FindAllPlanesUseCase;
import Plane.domain.services.PlaneService;
import Plane.infrastructure.in.PlaneController;
import Plane.infrastructure.out.PlaneRepository;
import User.application.CreateUserUseCase;
import User.domain.service.UserService;
import User.infrastructure.in.UserController;
import User.infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        // Servicios y casos de uso para User
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UserController userController = new UserController(createUserUseCase);

        // Servicios y casos de uso para Plane
        PlaneRepository planeRepository = new PlaneRepository();
        PlaneService planeService = planeRepository;
        CreatePlaneUseCase createPlaneUseCase = new CreatePlaneUseCase(planeService);
        FindPlaneByIdUseCase findPlaneByIdUseCase = new FindPlaneByIdUseCase(planeService);
        UpdatePlaneUseCase updatePlaneUseCase = new UpdatePlaneUseCase(planeService);
        DeletePlaneUseCase deletePlaneUseCase = new DeletePlaneUseCase(planeService);
        FindAllPlanesUseCase findAllPlanesUseCase = new FindAllPlanesUseCase(planeService);
        PlaneController planeController = new PlaneController(createPlaneUseCase, findPlaneByIdUseCase, updatePlaneUseCase, deletePlaneUseCase, findAllPlanesUseCase);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Gestionar Avión");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    userController.start();
                    break;
                case 2:
                    planeController.start();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
