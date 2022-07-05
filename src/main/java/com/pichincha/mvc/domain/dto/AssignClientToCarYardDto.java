package com.pichincha.mvc.domain.dto;

import java.util.Date;

public class AssignClientToCarYardDto {

    Long clientId;
    Long carYardId;
    Date assignDate;

    public AssignClientToCarYardDto() {
    }

    public AssignClientToCarYardDto(Long clientId, Long carYardId, Date assignDate) {
        this.clientId = clientId;
        this.carYardId = carYardId;
        this.assignDate = assignDate;
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

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
}
