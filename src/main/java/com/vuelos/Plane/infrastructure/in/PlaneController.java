package com.vuelos.Plane.infrastructure.in;

import java.time.LocalDate;
import java.util.Scanner;

import com.vuelos.Plane.application.CreatePlaneUseCase;
import com.vuelos.Plane.domain.entity.Plane;

public class PlaneController {
    private final CreatePlaneUseCase createPlaneUseCase;

    public PlaneController(CreatePlaneUseCase createPlaneUseCase) {
        this.createPlaneUseCase = createPlaneUseCase;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter plane plates: ");
            String plates = scanner.nextLine();

            System.out.println("Enter plane capacity: ");
            Integer capacity = scanner.nextInt();

            System.out.println("Enter fabrication date (yyyy-mm-dd): ");
            LocalDate fabricationDate = LocalDate.parse(scanner.next());

            System.out.println("Enter status ID: ");
            Integer statusId = scanner.nextInt();

            System.out.println("Enter model ID: ");
            Integer modelId = scanner.nextInt();

            System.out.println("Enter airline ID: ");
            Integer airlineId = scanner.nextInt();

            Plane plane = new Plane();
            plane.setPlates(plates);
            plane.setCapacity(capacity);
            plane.setFabricationDate(fabricationDate);
            plane.setStatusId(statusId);
            plane.setModelId(modelId);
            plane.setAirlineId(airlineId);

            createPlaneUseCase.execute(plane);
        }

        System.out.println("Plane created successfully!");
    }
}
