package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.AssignClientToCarYard;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EmbeddedId;
import java.util.Optional;

public interface AssignClientToCarYardRepository extends JpaRepository<AssignClientToCarYard, EmbeddedId> {

    Optional<AssignClientToCarYard> findByClientIdAndCarYardId(Long clientId, Long carYardId);
}
