package com.pichincha.mvc.domain;

import java.util.List;

public class SalesExecutiveBuilder {
    private Long id;
    private String identification;
    private String names;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private int age;
    private String homePhone;
    private CarYard carYard;
    private List<CreditRequest> creditRequests;

    public SalesExecutiveBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SalesExecutiveBuilder setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public SalesExecutiveBuilder setNames(String names) {
        this.names = names;
        return this;
    }

    public SalesExecutiveBuilder setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public SalesExecutiveBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public SalesExecutiveBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SalesExecutiveBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public SalesExecutiveBuilder setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public SalesExecutiveBuilder setCarYard(CarYard carYard) {
        this.carYard = carYard;
        return this;
    }

    public SalesExecutiveBuilder setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
        return this;
    }

    public SalesExecutive createSalesExecutive() {
        return new SalesExecutive(id, identification, names, lastNames, direction, phoneNumber, age, homePhone, carYard, creditRequests);
    }
}