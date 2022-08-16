package com.pichincha.mvc.domain.dto;

import javax.validation.constraints.NotNull;

public class CarYardDto {
    private Long id;
    @NotNull(message = "El campo nombre es obligatorio")
    private String name;
    @NotNull(message = "El campo dirección es obligatorio")
    private String direction;
    @NotNull(message = "El campo teléfono es obligatorio")
    private String phoneNumber;
    @NotNull(message = "El campo punto de venta es obligatorio")
    private Integer pointSaleNumber;

    public CarYardDto() {
    }

    public CarYardDto(Long id, String name, String direction, String phoneNumber, Integer pointSaleNumber) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.pointSaleNumber = pointSaleNumber;
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
}
