package com.pichincha.mvc.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class SalesExecutive extends Person {

    @Column(name = "home_phone")
    private String homePhone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_yard_id", referencedColumnName = "id")
    private CarYard carYard;

    @OneToMany(mappedBy = "salesExecutive")
    private List<CreditRequest> creditRequests;

    public SalesExecutive() {
        super();
    }

    public SalesExecutive(Long id) {
        super(id);
    }

    public SalesExecutive(Long id, String identification, String names, String lastNames, String direction, String phoneNumber, int age, String homePhone, CarYard carYard, List<CreditRequest> creditRequests) {
        super(id, identification, names, lastNames, direction, phoneNumber, age);
        this.homePhone = homePhone;
        this.carYard = carYard;
        this.creditRequests = creditRequests;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public CarYard getCarYard() {
        return carYard;
    }

    public void setCarYard(CarYard carYard) {
        this.carYard = carYard;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }
}
