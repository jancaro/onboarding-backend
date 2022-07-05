package com.pichincha.mvc.domain.dto;

import com.pichincha.mvc.domain.enums.MaritalStatus;
import com.sun.istack.NotNull;

import java.util.Date;

public class ClientDto {
    private Long id;
    private String identification;
    private String names;
    private Integer age;
    private Date birthday;
    private String lastNames;
    private String direction;
    private String cellphoneNumber;
    private MaritalStatus maritalStatus;
    private String spouseNames;
    private String spouseLastnames;
    @NotNull
    private Boolean creditStatus;

    public ClientDto(Long id, String identification, String names, Integer age, Date birthday, String lastNames, String direction, String cellphoneNumber, MaritalStatus maritalStatus, String spouseNames, String spouseLastnames, Boolean creditStatus) {
        this.id = id;
        this.identification = identification;
        this.names = names;
        this.age = age;
        this.birthday = birthday;
        this.lastNames = lastNames;
        this.direction = direction;
        this.cellphoneNumber = cellphoneNumber;
        this.maritalStatus = maritalStatus;
        this.spouseNames = spouseNames;
        this.spouseLastnames = spouseLastnames;
        this.creditStatus = creditStatus;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouseNames() {
        return spouseNames;
    }

    public void setSpouseNames(String spouseNames) {
        this.spouseNames = spouseNames;
    }

    public String getSpouseLastnames() {
        return spouseLastnames;
    }

    public void setSpouseLastnames(String spouseLastnames) {
        this.spouseLastnames = spouseLastnames;
    }

    public Boolean getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Boolean creditStatus) {
        this.creditStatus = creditStatus;
    }
}
