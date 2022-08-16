package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.Client;
import com.pichincha.mvc.domain.dto.ClientDto;
import com.pichincha.mvc.domain.enums.CreditStatus;
import com.pichincha.mvc.domain.mapper.ClientMapper;
import com.pichincha.mvc.exceptions.TransactionNotFoundException;
import com.pichincha.mvc.repository.ClientRepository;
import com.pichincha.mvc.repository.CreditRequestRepository;
import com.pichincha.mvc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final CreditRequestRepository creditRequestRepository;

    private final ClientMapper clientMapper;

    @Autowired
    ClientServiceImpl(ClientRepository clientRepository, CreditRequestRepository creditRequestRepository, ClientMapper clientMapper) {
        //qualifiedByName para especificar que implementación del servicio se desea usar
        this.clientRepository = clientRepository;
        this.creditRequestRepository = creditRequestRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> getAll() {
        return clientMapper.toClientDtoList(this.clientRepository.findAll());
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) throws ConstraintViolationException {
        Optional<Client> clientReview = clientRepository.findByIdentification(clientDto.getIdentification());
        if(clientReview.isEmpty()) {
            Client client = clientRepository.save(clientMapper.toClient(clientDto));
            return clientMapper.toClientDto(client);
        } else {
            throw new TransactionNotFoundException("No se puede crear porque ya existe una persona con identificación "+clientDto.getIdentification());
        }
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Optional<Client> clientReview = clientRepository.findByIdAndIdentification(clientDto.getId(), clientDto.getIdentification());
        if(clientReview.isPresent()) {
            Client client = clientRepository.save(clientMapper.toClient(clientDto));
            return clientMapper.toClientDto(client);
        } else {
            throw new TransactionNotFoundException("No se puede actualizar porque no existe una persona con identificación "+clientDto.getIdentification()+" y id "+clientDto.getId());
        }
    }

    @Override
    public ClientDto getClient(Long clientId) {
        Optional<Client> clientReview = clientRepository.findById(clientId);
        if(clientReview.isPresent()) {
            return clientMapper.toClientDto(clientReview.get());
        } else {
            throw new TransactionNotFoundException("No se encontró una persona con identificación "+clientId);
        }
    }

    @Override
    public Map<String, Object> deleteClient(Long clientId) {
        Optional<Client> clientReview = clientRepository.findById(clientId);
        if(clientReview.isPresent()) {
            boolean isEmptyInCredit = this.creditRequestRepository.getCreditByClientAndStatus(clientId, CreditStatus.REGISTRADA).isEmpty();
            if (isEmptyInCredit) {
                clientRepository.delete(clientReview.get());
                Map<String, Object> response = new HashMap<>();
                response.put("result", "Eliminado correctamente");
                return response;
            } else
                throw new TransactionNotFoundException("No se puede eliminar porque existe un credito registrado asociado");
        } else {
            throw new TransactionNotFoundException("No se encontró una persona con id "+clientId);
        }
    }
}
