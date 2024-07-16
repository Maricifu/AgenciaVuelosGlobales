package Plane.application;

import Plane.domain.services.PlaneService;

public class DeletePlaneUseCase {
    private final PlaneService planeService;

    public DeletePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Long id) {
        planeService.deletePlane(id);
    }
}