package com.pichincha.mvc.domain;

import com.pichincha.mvc.domain.enums.MaritalStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Client extends Person {

    @Column(name = "birthday")
    @NotNull(message = "El campo fecha de nacimiento es obligatorio")
    private Date birthday;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El campo estado civil es obligatorio")
    private MaritalStatus maritalStatus;

    @Column(name = "spouse_names")
    private String spouseNames;

    @Column(name = "spouse_lastnames")
    private String spouseLastnames;

    @Column(name = "credit_status")
    @NotNull(message = "El campo sujeto a crédito es obligatorio")
    private Boolean creditStatus;

    @OneToMany(mappedBy = "client")
    private List<AssignClientToCarYard> assignments;

    @OneToMany(mappedBy = "client")
    private List<CreditRequest> creditRequests;

    public Client() {
        super();
    }

    public Client(Long id) {
        super(id);
    }

    public Client(Long id, String identification, String names, String lastNames, String direction, String phoneNumber, int age, Date birthday, MaritalStatus maritalStatus, String spouseNames, String spouseLastnames, Boolean creditStatus, List<AssignClientToCarYard> assignments, List<CreditRequest> creditRequests) {
        super(id, identification, names, lastNames, direction, phoneNumber, age);
        this.birthday = birthday;
        this.maritalStatus = maritalStatus;
        this.spouseNames = spouseNames;
        this.spouseLastnames = spouseLastnames;
        this.creditStatus = creditStatus;
        this.assignments = assignments;
        this.creditRequests = creditRequests;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public List<AssignClientToCarYard> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignClientToCarYard> assignments) {
        this.assignments = assignments;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }
}
