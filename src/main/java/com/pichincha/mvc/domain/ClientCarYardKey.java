package com.pichincha.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ClientCarYardKey implements Serializable {

    @Column(name = "client_id")
    Long clientId;

    @Column(name = "card_yard_id")
    Long cardYardId;

    public ClientCarYardKey() {
    }

    public ClientCarYardKey(Long clientId, Long cardYardId) {
        this.clientId = clientId;
        this.cardYardId = cardYardId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCardYardId() {
        return cardYardId;
    }

    public void setCardYardId(Long cardYardId) {
        this.cardYardId = cardYardId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
