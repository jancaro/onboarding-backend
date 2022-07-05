package com.pichincha.mvc.domain;

import com.pichincha.mvc.domain.enums.MaritalStatus;

import java.util.Date;
import java.util.List;

public class ClientBuilder {
    private Long id;
    private String identification;
    private String names;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private int age;
    private Date birthday;
    private MaritalStatus maritalStatus;
    private String spouseNames;
    private String spouseLastnames;
    private Boolean creditStatus;
    private List<AssignClientToCarYard> assignments;
    private List<CreditRequest> creditRequests;

    public ClientBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public ClientBuilder setNames(String names) {
        this.names = names;
        return this;
    }

    public ClientBuilder setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public ClientBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public ClientBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ClientBuilder setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public ClientBuilder setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public ClientBuilder setSpouseNames(String spouseNames) {
        this.spouseNames = spouseNames;
        return this;
    }

    public ClientBuilder setSpouseLastnames(String spouseLastnames) {
        this.spouseLastnames = spouseLastnames;
        return this;
    }

    public ClientBuilder setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
        return this;
    }

    public ClientBuilder setAssignments(List<AssignClientToCarYard> assignments) {
        this.assignments = assignments;
        return this;
    }

    public ClientBuilder setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
        return this;
    }

    public Client createClient() {
        return new Client(id, identification, names, lastNames, direction, phoneNumber, age, birthday, maritalStatus, spouseNames, spouseLastnames, creditStatus, assignments, creditRequests);
    }
}