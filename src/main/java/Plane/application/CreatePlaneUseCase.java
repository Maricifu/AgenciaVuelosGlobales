package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.services.PlaneService;

public class CreatePlaneUseCase {
    private final PlaneService planeService;

    public CreatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Plane plane) {
        planeService.createPlane(plane);
    }
}