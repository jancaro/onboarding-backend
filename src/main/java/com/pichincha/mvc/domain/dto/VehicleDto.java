package com.pichincha.mvc.domain.dto;

public class VehicleDto {
    private Long id;
    private String carPlate;
    private String model;
    private String chassisNumber;
    private String type;
    private Integer cylinderCapacity;
    private Double appraise;
    private Long brandCarId;
    private Long carYardId;
    private boolean isSold;

    public VehicleDto() {
    }

    public VehicleDto(Long id, String carPlate, String model, String chassisNumber, String type, Integer cylinderCapacity, Double appraise, Long brandCarId, Long carYardId, boolean isSold) {
        this.id = id;
        this.carPlate = carPlate;
        this.model = model;
        this.chassisNumber = chassisNumber;
        this.type = type;
        this.cylinderCapacity = cylinderCapacity;
        this.appraise = appraise;
        this.brandCarId = brandCarId;
        this.carYardId = carYardId;
        this.isSold = isSold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Integer cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public Double getAppraise() {
        return appraise;
    }

    public void setAppraise(Double appraise) {
        this.appraise = appraise;
    }

    public Long getBrandCarId() {
        return brandCarId;
    }

    public void setBrandCarId(Long brandCarId) {
        this.brandCarId = brandCarId;
    }

    public Long getCarYardId() {
        return carYardId;
    }

    public void setCarYardId(Long carYardId) {
        this.carYardId = carYardId;
    }

    public boolean getSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
