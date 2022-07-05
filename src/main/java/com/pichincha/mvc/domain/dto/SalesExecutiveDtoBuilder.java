package com.pichincha.mvc.domain.dto;

public class SalesExecutiveDtoBuilder {
    private Long id;
    private String identification;
    private String names;
    private Integer age;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private String homePhone;

    public SalesExecutiveDtoBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SalesExecutiveDtoBuilder setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public SalesExecutiveDtoBuilder setNames(String names) {
        this.names = names;
        return this;
    }

    public SalesExecutiveDtoBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public SalesExecutiveDtoBuilder setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public SalesExecutiveDtoBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public SalesExecutiveDtoBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SalesExecutiveDtoBuilder setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public SalesExecutiveDto createSalesExecutiveDto() {
        return new SalesExecutiveDto(id, identification, names, age, lastNames, direction, phoneNumber, homePhone);
    }
}