package com.pichincha.mvc.domain.dto;

public class SalesExecutiveDto {
    private Long id;
    private String identification;
    private String names;
    private Integer age;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private String homePhone;

    public SalesExecutiveDto(Long id, String identification, String names, Integer age, String lastNames, String direction, String phoneNumber, String homePhone) {
        this.id = id;
        this.identification = identification;
        this.names = names;
        this.age = age;
        this.lastNames = lastNames;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.homePhone = homePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
}
