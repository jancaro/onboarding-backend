package com.pichincha.mvc.domain;

import com.pichincha.mvc.domain.enums.CreditStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "credit_request")
public class CreditRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "creation_document_date")
    @NotNull(message = "El campo fecha de creación es obligatorio")
    private Date creationDocumentDate;

    @Column(name = "months_term")
    @NotNull(message = "El campo meses plazo es obligatorio")
    private int monthsTerm;

    @Column(name = "dues")
    @NotNull(message = "El campo cuotas es obligatorio")
    private int dues;

    @Column(name = "entry")
    @NotNull(message = "El campo entrada es obligatorio")
    private double entry;

    @Column(name = "observation")
    private String observation;

    @Column(name = "credit_status")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El campo estado de crédito es obligatorio")
    private CreditStatus creditStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_yard_id")
    private CarYard carYard;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "sales_executive_id")
    private SalesExecutive salesExecutive;

    public CreditRequest() {
    }

    public CreditRequest(Long id, Date creationDocumentDate, int monthsTerm, int dues, double entry, String observation, CreditStatus creditStatus, Client client, CarYard carYard, Vehicle vehicle, SalesExecutive salesExecutive) {
        this.id = id;
        this.creationDocumentDate = creationDocumentDate;
        this.monthsTerm = monthsTerm;
        this.dues = dues;
        this.entry = entry;
        this.observation = observation;
        this.creditStatus = creditStatus;
        this.client = client;
        this.carYard = carYard;
        this.vehicle = vehicle;
        this.salesExecutive = salesExecutive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CarYard getCarYard() {
        return carYard;
    }

    public void setCarYard(CarYard carYard) {
        this.carYard = carYard;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SalesExecutive getSalesExecutive() {
        return salesExecutive;
    }

    public void setSalesExecutive(SalesExecutive salesExecutive) {
        this.salesExecutive = salesExecutive;
    }

    public Date getCreationDocumentDate() {
        return creationDocumentDate;
    }

    public void setCreationDocumentDate(Date creationDocumentDate) {
        this.creationDocumentDate = creationDocumentDate;
    }

    public int getMonthsTerm() {
        return monthsTerm;
    }

    public void setMonthsTerm(int monthsTerm) {
        this.monthsTerm = monthsTerm;
    }

    public int getDues() {
        return dues;
    }

    public void setDues(int dues) {
        this.dues = dues;
    }

    public double getEntry() {
        return entry;
    }

    public void setEntry(double entry) {
        this.entry = entry;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public CreditStatus getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus) {
        this.creditStatus = creditStatus;
    }
}
