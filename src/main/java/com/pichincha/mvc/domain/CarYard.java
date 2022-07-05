package com.pichincha.mvc.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "car_yard")
public class CarYard {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "El campo nombre es obligatorio")
    private String name;

    @Column(name = "direction")
    @NotNull(message = "El campo dirección es obligatorio")
    private String direction;

    @Column(name = "phone_number")
    @NotNull(message = "El campo teléfono es obligatorio")
    private String phoneNumber;

    @Column(name = "point_sale_number")
    @NotNull(message = "El campo punto de venta es obligatorio")
    private Integer pointSaleNumber;

    @OneToMany(mappedBy = "carYard")
    private List<AssignClientToCarYard> assignments;

    @OneToMany(mappedBy = "carYard")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "carYard")
    private List<SalesExecutive> salesExecutives;

    @OneToMany(mappedBy = "carYard")
    private List<CreditRequest> creditRequests;

    public CarYard() {
    }

    public CarYard(Long id) {
        this.id = id;
    }

    public CarYard(Long id, String name, String direction, String phoneNumber, Integer pointSaleNumber, List<AssignClientToCarYard> assignments, List<Vehicle> vehicles, List<SalesExecutive> salesExecutives, List<CreditRequest> creditRequests) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.pointSaleNumber = pointSaleNumber;
        this.assignments = assignments;
        this.vehicles = vehicles;
        this.salesExecutives = salesExecutives;
        this.creditRequests = creditRequests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPointSaleNumber() {
        return pointSaleNumber;
    }

    public void setPointSaleNumber(Integer pointSaleNumber) {
        this.pointSaleNumber = pointSaleNumber;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<AssignClientToCarYard> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignClientToCarYard> assignments) {
        this.assignments = assignments;
    }

    public List<SalesExecutive> getSalesExecutives() {
        return salesExecutives;
    }

    public void setSalesExecutives(List<SalesExecutive> salesExecutives) {
        this.salesExecutives = salesExecutives;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }
}
