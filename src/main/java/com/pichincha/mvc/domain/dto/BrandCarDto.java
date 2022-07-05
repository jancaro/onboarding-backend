package com.pichincha.mvc.domain.dto;

public class BrandCarDto {
    private Long id;
    private String brand;

    public BrandCarDto() {
    }

    public BrandCarDto(Long id, String brand) {
        this.id = id;
        this.brand = brand;
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
}
