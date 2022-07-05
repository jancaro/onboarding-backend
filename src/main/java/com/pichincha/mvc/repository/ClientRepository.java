package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByIdAndIdentification(Long id, String identification);

    Optional<Client> findByIdentification(String identification);
}
