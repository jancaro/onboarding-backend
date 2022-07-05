package com.pichincha.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "identification")
    @NotNull(message = "El campo identificación es obligatorio")
    private String identification;

    @Column(name = "names")
    @NotNull(message = "El campo nombres es obligatorio")
    private String names;

    @Column(name = "last_names")
    @NotNull(message = "El campo apellidos es obligatorio")
    private String lastNames;

    @Column(name = "direction")
    @NotNull(message = "El campo dirección es obligatorio")
    private String direction;

    @Column(name = "phone_number")
    @NotNull(message = "El campo celular es obligatorio")
    private String cellphoneNumber;

    @Column
    @NotNull(message = "El campo edad es obligatorio")
    //@Size(min = 18, max = 99, message = "La edad debe estar en un rango de 18 a 99")
    private int age;

    public Person(Long id, String identification, String names, String lastNames, String direction, String cellphoneNumber, int age) {
        this.id = id;
        this.identification = identification;
        this.names = names;
        this.lastNames = lastNames;
        this.direction = direction;
        this.cellphoneNumber = cellphoneNumber;
        this.age = age;
    }

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
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

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
