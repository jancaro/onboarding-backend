package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.AssignClientToCarYard;
import com.pichincha.mvc.domain.CarYard;
import com.pichincha.mvc.domain.Client;
import com.pichincha.mvc.domain.ClientCarYardKey;
import com.pichincha.mvc.domain.dto.AssignClientToCarYardDto;
import com.pichincha.mvc.domain.mapper.AssignClientToCarYardMapper;
import com.pichincha.mvc.exceptions.TransactionNotFoundException;
import com.pichincha.mvc.repository.AssignClientToCarYardRepository;
import com.pichincha.mvc.repository.CarYardRepository;
import com.pichincha.mvc.repository.ClientRepository;
import com.pichincha.mvc.service.AssignClientToCarYardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssignClientToCarYardServiceImpl implements AssignClientToCarYardService {
    private final AssignClientToCarYardRepository repository;

    private final ClientRepository clientRepository;
    private final CarYardRepository carYardRepository;

    private final AssignClientToCarYardMapper mapper;

    @Autowired
    public AssignClientToCarYardServiceImpl(AssignClientToCarYardRepository repository, ClientRepository clientRepository, CarYardRepository carYardRepository, AssignClientToCarYardMapper mapper) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.carYardRepository = carYardRepository;
        this.mapper = mapper;
    }

    @Override
    public AssignClientToCarYardDto saveAssignDto(AssignClientToCarYardDto assignClientToCarYardDto) {
        Optional<AssignClientToCarYard> assignation = this.repository.findByClientIdAndCarYardId(assignClientToCarYardDto.getClientId(), assignClientToCarYardDto.getCarYardId());
        if(assignation.isEmpty()) {
            Client client = new Client(assignClientToCarYardDto.getClientId());
            CarYard carYard = new CarYard(assignClientToCarYardDto.getCarYardId());
            ClientCarYardKey key = new ClientCarYardKey(assignClientToCarYardDto.getClientId(), assignClientToCarYardDto.getCarYardId());
            AssignClientToCarYard assignationNew = new AssignClientToCarYard();
            assignationNew.setId(key);
            assignationNew.setAssignDate(assignClientToCarYardDto.getAssignDate());
            assignationNew.setClient(client);
            assignationNew.setCarYard(carYard);
            AssignClientToCarYard assignationSaved = this.repository.save(assignationNew);
            AssignClientToCarYardDto assignationDto = this.mapper.assignClientToCarYardDto(assignationSaved);
            assignationDto.setCarYardId(carYard.getId());
            assignationDto.setClientId(client.getId());
            return assignationDto;
        } else {
            throw new TransactionNotFoundException("");
        }
    }

    @Override
    public void saveAssign(Client client, CarYard carYard) {
        AssignClientToCarYard assignation = new AssignClientToCarYard();
        ClientCarYardKey key = new ClientCarYardKey(client.getId(), carYard.getId());
        assignation.setClient(client);
        assignation.setCarYard(carYard);
        assignation.setAssignDate(new Date());
        assignation.setId(key);
        repository.save(assignation);
    }

    @Override
    public AssignClientToCarYardDto updateAssign(AssignClientToCarYardDto assignClientToCarYardDto) {
        Optional<AssignClientToCarYard> assignation = this.repository.findByClientIdAndCarYardId(assignClientToCarYardDto.getClientId(), assignClientToCarYardDto.getCarYardId());
        if(assignation.isPresent()) {
            assignation.get().setAssignDate(assignClientToCarYardDto.getAssignDate());
            AssignClientToCarYard assignationSaved = this.repository.save(assignation.get());
            AssignClientToCarYardDto assignationDto = this.mapper.assignClientToCarYardDto(assignationSaved);
            assignationDto.setCarYardId(assignationSaved.getCarYard().getId());
            assignationDto.setClientId(assignationSaved.getClient().getId());
            return assignationDto;
        } else {
            throw new TransactionNotFoundException("No se ha podido obtener una asignación con ese id de cliente e id de patio");
        }
    }

    @Override
    public AssignClientToCarYardDto getAssign(Long clientId, Long cardYardId) {
        Optional<AssignClientToCarYard> assignation = this.repository.findByClientIdAndCarYardId(clientId, cardYardId);
        if(assignation.isPresent()) {
            AssignClientToCarYardDto assignationDto = this.mapper.assignClientToCarYardDto(assignation.get());
            assignationDto.setCarYardId(assignation.get().getCarYard().getId());
            assignationDto.setClientId(assignation.get().getClient().getId());
            return assignationDto;
        } else {
            throw new TransactionNotFoundException("No se ha podido obtener una asignación con ese id de cliente e id de patio");
        }
    }

    @Override
    public Map<String, Object> deleteAssign(Long clientId, Long cardYardId) {
        Optional<AssignClientToCarYard> assignation = this.repository.findByClientIdAndCarYardId(clientId, cardYardId);
        if(assignation.isPresent()) {
            this.repository.delete(assignation.get());
            Map<String, Object> response = new HashMap<>();
            response.put("result", "Eliminado correctamente");
            return response;
        } else {
            throw new TransactionNotFoundException("No se ha podido obtener una asignación con ese id de cliente e id de patio");
        }
    }
}
