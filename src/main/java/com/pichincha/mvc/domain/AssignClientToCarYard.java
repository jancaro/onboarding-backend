package com.pichincha.mvc.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "assign_client_card")
public class AssignClientToCarYard {

    @EmbeddedId
    ClientCarYardKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    @NotNull(message = "El campo cliente es obligatorio")
    Client client;

    @ManyToOne
    @MapsId("cardYardId")
    @JoinColumn(name = "card_yard_id")
    @NotNull(message = "El campo patio es obligatorio")
    CarYard carYard;

    @Column(name = "assign_date")
    @NotNull(message = "El campo fecha de asignación es obligatorio")
    Date assignDate;

    public AssignClientToCarYard() {
    }

    public AssignClientToCarYard(ClientCarYardKey id, Client client, CarYard carYard, Date assignDate) {
        this.id = id;
        this.client = client;
        this.carYard = carYard;
        this.assignDate = assignDate;
    }

    public ClientCarYardKey getId() {
        return id;
    }

    public void setId(ClientCarYardKey id) {
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

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
}
