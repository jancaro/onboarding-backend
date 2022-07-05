package com.pichincha.mvc.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "brand_car")
public class BrandCar {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @OneToMany(mappedBy = "brandCar", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    public BrandCar() {
    }

    public BrandCar(Long id, String brand, List<Vehicle> vehicles) {
        this.id = id;
        this.brand = brand;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
