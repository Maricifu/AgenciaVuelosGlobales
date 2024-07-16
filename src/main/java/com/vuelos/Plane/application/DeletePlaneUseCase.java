package com.vuelos.Plane.application;

import com.vuelos.Plane.domain.services.PlaneService;

public class DeletePlaneUseCase {
    private final PlaneService planeService;

    public DeletePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Long id) {
        planeService.deletePlane(id);
    }
}