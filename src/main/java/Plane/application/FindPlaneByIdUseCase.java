package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.services.PlaneService;

public class FindPlaneByIdUseCase {
    private final PlaneService planeService;

    public FindPlaneByIdUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Plane execute(Long id) {
        Plane plane = planeService.findPlaneById(id);
        return plane; // Devuelve el objeto Plane encontrado, o null si no se encuentra
    }
}