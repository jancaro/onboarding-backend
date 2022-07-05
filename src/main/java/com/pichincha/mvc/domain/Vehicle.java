package com.pichincha.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "car_plate")
    @NotNull(message = "El campo placa es obligatorio")
    private String carPlate;

    @Column(name = "model")
    @NotNull(message = "El campo modelo es obligatorio")
    private String model;

    @Column(name = "chassis_number")
    @NotNull(message = "El campo chasis es obligatorio")
    private String chassisNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "cylinder_capacity")
    @NotNull(message = "El campo cilindraje es obligatorio")
    private Integer cylinderCapacity;

    @Column(name = "appraise")
    @NotNull(message = "El campo avalúo es obligatorio")
    private Double appraise;

    @Column(name = "sold")
    @NotNull(message = "El campo vendido es obligatorio")
    private boolean isSold;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandCar brandCar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_yard_id", referencedColumnName = "id")
    private CarYard carYard;

    @OneToMany(mappedBy = "vehicle")
    private List<CreditRequest> creditRequests;

    public Vehicle() {
    }

    public Vehicle(Long id) {
        this.id = id;
    }

    public Vehicle(Long id, String carPlate, String model, String chassisNumber, String type, Integer cylinderCapacity, Double appraise, boolean isSold, BrandCar brandCar, CarYard carYard, List<CreditRequest> creditRequests) {
        this.id = id;
        this.carPlate = carPlate;
        this.model = model;
        this.chassisNumber = chassisNumber;
        this.type = type;
        this.cylinderCapacity = cylinderCapacity;
        this.appraise = appraise;
        this.isSold = isSold;
        this.brandCar = brandCar;
        this.carYard = carYard;
        this.creditRequests = creditRequests;
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

    public boolean getSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public BrandCar getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(BrandCar brandCar) {
        this.brandCar = brandCar;
    }

    public CarYard getCarYard() {
        return carYard;
    }

    public void setCarYard(CarYard carYard) {
        this.carYard = carYard;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }
}
