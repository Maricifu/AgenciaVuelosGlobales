package domain.entity;

import java.time.LocalDate;

public class Plane {
    private Integer id;
    private String plates;
    private Integer capacity;
    private LocalDate fabricationDate;
    private Integer statusId;
    private Integer modelId;
    private Integer airlineId;
    public Plane() {
    }
    
    public Plane(Integer id, String plates, Integer capacity, LocalDate fabricationDate, Integer statusId,
            Integer modelId, Integer airlineId) {
        this.id = id;
        this.plates = plates;
        this.capacity = capacity;
        this.fabricationDate = fabricationDate;
        this.statusId = statusId;
        this.modelId = modelId;
        this.airlineId = airlineId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public LocalDate getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(LocalDate fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }
    



}
