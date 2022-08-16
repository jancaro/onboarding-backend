package com.pichincha.mvc.domain.dto;

import com.pichincha.mvc.domain.enums.CreditStatus;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreditRequestDto {
    private Long id;
    @NotNull(message = "El campo fecha de creación es obligatorio")
    private Date creationDocumentDate;
    @NotNull(message = "El campo meses plazo es obligatorio")
    private int monthsTerm;
    @NotNull(message = "El campo cuotas es obligatorio")
    private int dues;
    @NotNull(message = "El campo entrada es obligatorio")
    private double entry;
    @NotNull(message = "El campo estado de crédito es obligatorio")
    private CreditStatus creditStatus;
    private String observation;
    private Long clientId;
    private Long carYardId;
    private Long vehicleId;
    private Long salesExecutiveId;

    public CreditRequestDto() {
    }

    public CreditRequestDto(Long id, Date creationDocumentDate, int monthsTerm, int dues, double entry, String observation, CreditStatus creditStatus, Long clientId, Long carYardId, Long vehicleId, Long salesExecutiveId) {
        this.id = id;
        this.creationDocumentDate = creationDocumentDate;
        this.monthsTerm = monthsTerm;
        this.dues = dues;
        this.entry = entry;
        this.observation = observation;
        this.creditStatus = creditStatus;
        this.clientId = clientId;
        this.carYardId = carYardId;
        this.vehicleId = vehicleId;
        this.salesExecutiveId = salesExecutiveId;
    }

    public Date getCreationDocumentDate() {
        return creationDocumentDate;
    }

    public CreditStatus getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCarYardId() {
        return carYardId;
    }

    public void setCarYardId(Long carYardId) {
        this.carYardId = carYardId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getSalesExecutiveId() {
        return salesExecutiveId;
    }

    public void setSalesExecutiveId(Long salesExecutiveId) {
        this.salesExecutiveId = salesExecutiveId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
