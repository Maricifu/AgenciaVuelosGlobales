package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.services.PlaneService;

public class UpdatePlaneUseCase {
    private final PlaneService planeService;

    public UpdatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Plane plane) {
        planeService.updatePlane(plane);
    }
}
