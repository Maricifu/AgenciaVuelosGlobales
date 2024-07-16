package com.vuelos.Plane.infrastructure.in;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.vuelos.Plane.application.CreatePlaneUseCase;
import com.vuelos.Plane.application.FindPlaneByIdUseCase;
import com.vuelos.Plane.application.UpdatePlaneUseCase;
import com.vuelos.Plane.application.DeletePlaneUseCase;
import com.vuelos.Plane.application.FindAllPlanesUseCase;
import com.vuelos.Plane.domain.entity.Plane;

public class PlaneController {
    private final CreatePlaneUseCase createPlaneUseCase;
    private final FindPlaneByIdUseCase findPlaneByIdUseCase;
    private final UpdatePlaneUseCase updatePlaneUseCase;
    private final DeletePlaneUseCase deletePlaneUseCase;
    private final FindAllPlanesUseCase findAllPlanesUseCase;

    public PlaneController(CreatePlaneUseCase createPlaneUseCase,
                           FindPlaneByIdUseCase findPlaneByIdUseCase,
                           UpdatePlaneUseCase updatePlaneUseCase,
                           DeletePlaneUseCase deletePlaneUseCase,
                           FindAllPlanesUseCase findAllPlanesUseCase) {
        this.createPlaneUseCase = createPlaneUseCase;
        this.findPlaneByIdUseCase = findPlaneByIdUseCase;
        this.updatePlaneUseCase = updatePlaneUseCase;
        this.deletePlaneUseCase = deletePlaneUseCase;
        this.findAllPlanesUseCase = findAllPlanesUseCase;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Avión");
            System.out.println("2. Ver Avión por ID");
            System.out.println("3. Actualizar Avión");
            System.out.println("4. Eliminar Avión");
            System.out.println("5. Ver Todos los Aviones");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createPlane(scanner);
                    break;
                case 2:
                    viewPlaneById(scanner);
                    break;
                case 3:
                    updatePlane(scanner);
                    break;
                case 4:
                    deletePlane(scanner);
                    break;
                case 5:
                    viewAllPlanes();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void createPlane(Scanner scanner) {
        System.out.println("Enter plane plates: ");
        String plates = scanner.nextLine();

        System.out.println("Enter plane capacity: ");
        Integer capacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter fabrication date (yyyy-mm-dd): ");
        LocalDate fabricationDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter status ID: ");
        Integer statusId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter model ID: ");
        Integer modelId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter airline ID: ");
        Integer airlineId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Plane plane = new Plane(null, plates, capacity, fabricationDate, statusId, modelId, airlineId);
        createPlaneUseCase.execute(plane);
        System.out.println("Avión registrado con éxito.");
    }

    private void viewPlaneById(Scanner scanner) {
        System.out.println("Enter plane ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Plane plane = findPlaneByIdUseCase.execute(id);
        if (plane != null) {
            System.out.println("Avión encontrado: " + plane);
        } else {
            System.out.println("Avión no encontrado.");
        }
    }

    private void updatePlane(Scanner scanner) {
        System.out.println("Enter plane ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Plane plane = findPlaneByIdUseCase.execute(id);
        if (plane == null) {
            System.out.println("Avión no encontrado.");
            return;
        }

        System.out.println("Enter new plates (current: " + plane.getPlates() + "): ");
        String plates = scanner.nextLine();

        System.out.println("Enter new capacity (current: " + plane.getCapacity() + "): ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter new fabrication date (yyyy-mm-dd) (current: " + plane.getFabricationDate() + "): ");
        LocalDate fabricationDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter new status ID (current: " + plane.getStatusId() + "): ");
        int statusId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter new model ID (current: " + plane.getModelId() + "): ");
        int modelId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.println("Enter new airline ID (current: " + plane.getAirlineId() + "): ");
        int airlineId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        plane.setPlates(plates);
        plane.setCapacity(capacity);
        plane.setFabricationDate(fabricationDate);
        plane.setStatusId(statusId);
        plane.setModelId(modelId);
        plane.setAirlineId(airlineId);

        updatePlaneUseCase.execute(plane);
        System.out.println("Avión actualizado con éxito.");
    }

    private void deletePlane(Scanner scanner) {
        System.out.println("Enter plane ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        deletePlaneUseCase.execute(id);
        System.out.println("Avión eliminado con éxito.");
    }

    private void viewAllPlanes() {
        List<Plane> planes = findAllPlanesUseCase.execute();
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
}
