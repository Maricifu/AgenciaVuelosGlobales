package Plane.domain.services;

import java.util.List;

import Plane.domain.entity.Plane;

public interface PlaneService {
    void createPlane(Plane plane);
    Plane findPlaneById(Long id);
    void updatePlane(Plane plane);
    void deletePlane(Long id);
    List<Plane> findAllPlanes();
}