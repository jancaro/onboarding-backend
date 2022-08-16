package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.*;
import com.pichincha.mvc.domain.dto.CreditRequestDto;
import com.pichincha.mvc.domain.enums.CreditStatus;
import com.pichincha.mvc.domain.mapper.CreditRequestMapper;
import com.pichincha.mvc.exceptions.TransactionNotFoundException;
import com.pichincha.mvc.repository.*;
import com.pichincha.mvc.service.AssignClientToCarYardService;
import com.pichincha.mvc.service.CreditRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CreditRequestServiceImpl implements CreditRequestService {

    private final CreditRequestRepository creditRequestRepository;
    private final SalesExecutiveRepository salesExecutiveRepository;
    private final AssignClientToCarYardService assignService;
    private final CreditRequestMapper creditRequestMapper;

    @Autowired
    public CreditRequestServiceImpl(CreditRequestRepository creditRequestRepository,
                                    SalesExecutiveRepository salesExecutiveRepository,
                                    AssignClientToCarYardService assignService,
                                    CreditRequestMapper creditRequestMapper) {
        this.creditRequestRepository = creditRequestRepository;
        this.salesExecutiveRepository = salesExecutiveRepository;
        this.assignService = assignService;
        this.creditRequestMapper = creditRequestMapper;
    }

    @Override
    public CreditRequestDto saveCredit(CreditRequestDto creditRequestDto) {
        Optional<CreditRequest> creditRequestsSaved = this.creditRequestRepository.getCreditByClientAndDate(creditRequestDto.getClientId(), creditRequestDto.getCreationDocumentDate());
        if(creditRequestsSaved.isEmpty()) {
            Client client = new Client(creditRequestDto.getClientId());
            CarYard carYard = new CarYard(creditRequestDto.getCarYardId());
            Vehicle vehicle = new Vehicle(creditRequestDto.getVehicleId());
            SalesExecutive salesExecutive = new SalesExecutive(creditRequestDto.getSalesExecutiveId());
            CreditRequest creditRequest = this.creditRequestMapper.toCreditRequest(creditRequestDto);
            if(validateExecutiveCardYard(carYard,salesExecutive)) {
                if(!validateStatusVehicle(vehicle.getId(), creditRequestDto.getCreationDocumentDate(), CreditStatus.REGISTRADA)) {
                    this.assignService.saveAssign(client, carYard);
                    this.setObjects(creditRequest, client, carYard, vehicle, salesExecutive);
                    CreditRequestDto creditRequestDtoNew = this.creditRequestMapper.toCreditRequestDto(this.creditRequestRepository.save(creditRequest));
                    this.setObjectsDto(creditRequestDtoNew, client, carYard, vehicle, salesExecutive);
                    creditRequestDtoNew.setSalesExecutiveId(salesExecutive.getId());
                    return creditRequestDtoNew;
                } else {
                    throw new TransactionNotFoundException("El vehículo ya está ingresado en otra solicitud");
                }
            } else {
                throw new TransactionNotFoundException("El ejecutivo de ventas no pertence al patio seleccionado");
            }
        } else
            throw new TransactionNotFoundException("No se puede crear porque ya existe una solicitud para el cliente con id "+creditRequestDto.getClientId()+" en la fecha "+creditRequestDto.getCreationDocumentDate());
    }

    @Override
    public CreditRequestDto getCredit(Long id) {
        Optional<CreditRequest> creditRequest = this.creditRequestRepository.findById(id);
        if(creditRequest.isPresent()) {
            CreditRequestDto creditRequestDto = this.creditRequestMapper.toCreditRequestDto(creditRequest.get());
            creditRequestDto.setClientId(creditRequest.get().getClient().getId());
            creditRequestDto.setCarYardId(creditRequest.get().getCarYard().getId());
            creditRequestDto.setVehicleId(creditRequest.get().getVehicle().getId());
            creditRequestDto.setSalesExecutiveId(creditRequest.get().getSalesExecutive().getId());
            return creditRequestDto;
        } else
            throw new TransactionNotFoundException("No se encontró solicitud con ese id");
    }

    @Override
    public CreditRequestDto updateCredit(Long id, CreditStatus status) {
        Optional<CreditRequest> creditRequest = this.creditRequestRepository.findById(id);
        if(creditRequest.isPresent()) {
            CreditRequest updated = creditRequest.get();
            updated.setCreditStatus(status);
            CreditRequest saved = this.creditRequestRepository.save(updated);
            CreditRequestDto creditRequestDto = this.creditRequestMapper.toCreditRequestDto(saved);
            creditRequestDto.setClientId(creditRequest.get().getClient().getId());
            creditRequestDto.setCarYardId(creditRequest.get().getCarYard().getId());
            creditRequestDto.setVehicleId(creditRequest.get().getVehicle().getId());
            creditRequestDto.setSalesExecutiveId(creditRequest.get().getSalesExecutive().getId());
            return creditRequestDto;
        } else
            throw new TransactionNotFoundException("No se encontró solicitud con ese id");
    }

    private void setObjects(CreditRequest creditRequest, Client client, CarYard carYard, Vehicle vehicle, SalesExecutive salesExecutive) {
        creditRequest.setClient(client);
        creditRequest.setCarYard(carYard);
        creditRequest.setVehicle(vehicle);
        creditRequest.setSalesExecutive(salesExecutive);
    }

    private void setObjectsDto(CreditRequestDto creditRequestDto, Client client, CarYard carYard, Vehicle vehicle, SalesExecutive salesExecutive) {
        creditRequestDto.setClientId(client.getId());
        creditRequestDto.setCarYardId(carYard.getId());
        creditRequestDto.setVehicleId(vehicle.getId());
        creditRequestDto.setSalesExecutiveId(salesExecutive.getId());
    }

    private boolean validateExecutiveCardYard(CarYard carYard, SalesExecutive salesExecutive) {
        Optional<SalesExecutive> saved = this.salesExecutiveRepository.findById(salesExecutive.getId());
        return saved.filter(executive -> executive.getCarYard().getId().compareTo(carYard.getId()) == 0).isPresent();
    }

    private boolean validateStatusVehicle(Long vehicleId, Date creationCredit, CreditStatus status) {
        return this.creditRequestRepository.getCreditByVehicle(vehicleId, creationCredit, status).isPresent();
    }
}
