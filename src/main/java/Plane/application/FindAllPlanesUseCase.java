package Plane.application;

import Plane.domain.entity.Plane;
import Plane.domain.services.PlaneService;

import java.util.List;

public class FindAllPlanesUseCase {
    private final PlaneService planeService;

    public FindAllPlanesUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public List<Plane> execute() {
        return planeService.findAllPlanes();
    }
}

