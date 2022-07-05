package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.CreditRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface CreditRequestRepository extends JpaRepository<CreditRequest, Long> {

    @Query("SELECT c FROM CreditRequest c WHERE c.client.id = ?1 and c.creationDocumentDate = ?2")
    Optional<CreditRequest> getCreditByClientAndDate(Long id, Date date);
}
