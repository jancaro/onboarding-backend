package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.dto.ClientDto;

import java.util.List;
import java.util.Map;

public interface ClientService {

    ClientDto saveClient(ClientDto clientDto);

    ClientDto updateClient(ClientDto clientDto);

    ClientDto getClient(Long clientId);

    Map<String, Object> deleteClient(Long clientId);

    List<ClientDto> getAll();
}
