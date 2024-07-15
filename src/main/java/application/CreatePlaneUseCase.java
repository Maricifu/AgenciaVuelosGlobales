package application;

import domain.entity.Plane;
import domain.service.PlaneService;

public class CreatePlaneUseCase {
    private final PlaneService planeService;

    public CreatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Plane plane) {
        planeService.createPlane(plane);
    }
}