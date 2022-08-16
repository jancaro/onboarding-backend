package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.CreditRequest;
import com.pichincha.mvc.domain.enums.CreditStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface CreditRequestRepository extends JpaRepository<CreditRequest, Long> {

    @Query("SELECT c FROM CreditRequest c WHERE c.client.id = ?1 and c.creationDocumentDate = ?2")
    Optional<CreditRequest> getCreditByClientAndDate(Long id, Date date);

    @Query("SELECT c FROM CreditRequest c WHERE c.vehicle.id = ?1 and c.creationDocumentDate = ?2 and c.creditStatus = ?3")
    Optional<CreditRequest> getCreditByVehicle(Long id, Date date, CreditStatus status);

    @Query("SELECT c FROM CreditRequest c WHERE c.client.id = ?1 and c.carYard.id = ?2")
    Optional<CreditRequest> getCreditByClientAndVehicle(Long clientId, Long carYardId);

    @Query("SELECT c FROM CreditRequest c WHERE c.vehicle.id = ?1 and c.creditStatus = ?2")
    Optional<CreditRequest> getCreditByVehicleAndStatus(Long id, CreditStatus status);

    @Query("SELECT c FROM CreditRequest c WHERE c.client.id = ?1 and c.creditStatus = ?2")
    Optional<CreditRequest> getCreditByClientAndStatus(Long id, CreditStatus status);

    @Query("SELECT c FROM CreditRequest c WHERE c.carYard.id = ?1 and c.creditStatus = ?2")
    Optional<CreditRequest> getCreditByCarYardAndStatus(Long id, CreditStatus status);
}
