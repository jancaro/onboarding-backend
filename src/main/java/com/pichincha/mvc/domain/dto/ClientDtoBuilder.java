package com.pichincha.mvc.domain.dto;

import com.pichincha.mvc.domain.enums.MaritalStatus;

import java.util.Date;

public class ClientDtoBuilder {
    private Long id;
    private String identification;
    private String names;
    private Integer age;
    private Date birthday;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private MaritalStatus maritalStatus;
    private String spouseNames;
    private String spouseLastnames;
    private Boolean creditStatus;

    public ClientDtoBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientDtoBuilder setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public ClientDtoBuilder setNames(String names) {
        this.names = names;
        return this;
    }

    public ClientDtoBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public ClientDtoBuilder setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public ClientDtoBuilder setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public ClientDtoBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public ClientDtoBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientDtoBuilder setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public ClientDtoBuilder setSpouseNames(String spouseNames) {
        this.spouseNames = spouseNames;
        return this;
    }

    public ClientDtoBuilder setSpouseLastnames(String spouseLastnames) {
        this.spouseLastnames = spouseLastnames;
        return this;
    }

    public ClientDtoBuilder setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
        return this;
    }

    public ClientDto createClientDto() {
        return new ClientDto(id, identification, names, age, birthday, lastNames, direction, phoneNumber, maritalStatus, spouseNames, spouseLastnames, creditStatus);
    }
}