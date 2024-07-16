package com.vuelos;

import java.util.Scanner;

import com.vuelos.Plane.application.CreatePlaneUseCase;
import Plane.application.FindPlaneByIdUseCase;
import Plane.application.UpdatePlaneUseCase;
import Plane.application.DeletePlaneUseCase;
import Plane.application.FindAllPlanesUseCase;
import com.vuelos.Plane.domain.services.PlaneService;
import com.vuelos.Plane.infrastructure.in.PlaneController;
import com.vuelos.Plane.infrastructure.out.PlaneRepository;
import com.vuelos.User.application.CreateUserUseCase;
import com.vuelos.User.domain.service.UserService;
import com.vuelos.User.infrastructure.in.UserController;
import com.vuelos.User.infrastructure.out.UserRepository;

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
