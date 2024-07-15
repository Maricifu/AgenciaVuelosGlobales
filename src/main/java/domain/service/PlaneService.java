package domain.service;

import java.util.List;

import domain.entity.Plane;

public interface PlaneService {
    void createPlane(Plane plane);
    Plane findPlaneById(Long id);
    void updatePlane(Plane plane);
    void deletePlane(Long id);
    List<Plane> findAllPlanes();
}