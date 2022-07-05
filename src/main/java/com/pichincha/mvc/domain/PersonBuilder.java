package com.pichincha.mvc.domain;

public class PersonBuilder {
    private Long id;
    private String identification;
    private String names;
    private String lastNames;
    private String direction;
    private String phoneNumber;
    private int age;

    public PersonBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonBuilder setIdentification(String identification) {
        this.identification = identification;
        return this;
    }

    public PersonBuilder setNames(String names) {
        this.names = names;
        return this;
    }

    public PersonBuilder setLastNames(String lastNames) {
        this.lastNames = lastNames;
        return this;
    }

    public PersonBuilder setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public PersonBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Person createPerson() {
        return new Person(id, identification, names, lastNames, direction, phoneNumber, age);
    }
}