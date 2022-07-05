package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.CarYard;
import com.pichincha.mvc.domain.dto.CarYardDto;
import com.pichincha.mvc.domain.mapper.CardYardMapper;
import com.pichincha.mvc.exceptions.TransactionNotFoundException;
import com.pichincha.mvc.repository.CarYardRepository;
import com.pichincha.mvc.service.CarYardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarYardServiceImpl implements CarYardService {

    private final CarYardRepository carYardRepository;

    private final CardYardMapper cardYardMapper;

    @Autowired
    public CarYardServiceImpl(CarYardRepository carYardRepository, CardYardMapper cardYardMapper) {
        this.carYardRepository = carYardRepository;
        this.cardYardMapper = cardYardMapper;
    }

    @Override
    public CarYardDto saveCarYard(CarYardDto carYardDto) {
        Optional<CarYard> carYardSaved = null;
        if(carYardDto.getId() != null) {
            carYardSaved = this.carYardRepository.findById(carYardDto.getId());
        }

        if(carYardSaved == null) {
            CarYard carYardNew = this.carYardRepository.save(cardYardMapper.toCardYard(carYardDto));
            return cardYardMapper.toCarYardDto(carYardNew);
        } else {
            throw new TransactionNotFoundException("No se puede crear porque ya existe un patio con ese id "+carYardDto.getId());
        }
    }

    @Override
    public CarYardDto updateCarYard(CarYardDto carYardDto) {
        Optional<CarYard> carYardSaved = this.carYardRepository.findById(carYardDto.getId());
        if(carYardSaved.isPresent()) {
            CarYard updatedCarYard = this.carYardRepository.save(cardYardMapper.toCardYard(carYardDto));
            return cardYardMapper.toCarYardDto(updatedCarYard);
        } else {
            throw new TransactionNotFoundException("No se puede actualizar porque no existe un patio con id "+carYardDto.getId());
        }
    }

    @Override
    public CarYardDto getCarYardById(Long carYardId) {
        Optional<CarYard> carYardSaved = this.carYardRepository.findById(carYardId);
        if(carYardSaved.isPresent()) {
            return cardYardMapper.toCarYardDto(carYardSaved.get());
        } else {
            throw new TransactionNotFoundException("No se encontró un patio con id "+carYardId);
        }
    }

    @Override
    public Map<String, Object> deleteCarYard(Long carYardId) {
        Optional<CarYard> carYardSaved = this.carYardRepository.findById(carYardId);
        if(carYardSaved.isPresent()) {
            /*if(carYardSaved.get().getClients() == null && carYardSaved.get().getVehicles() == null) {
                this.carYardRepository.deleteById(carYardId);*/
                Map<String, Object> response = new HashMap<>();
                response.put("result", "Eliminado correctamente");
                return response;
           /*} else {
                throw new TransactionNotFoundException("No se puede eliminar porque el patio tiene referencias");
            }*/
        } else {
            throw new TransactionNotFoundException("No se pudo eliminar porque no se encontró un patio con id "+carYardId);
        }
    }

    @Override
    public List<CarYardDto> getAllCarYard() {
        return cardYardMapper.toCarYardDtoList((List<CarYard>) this.carYardRepository.findAll());
    }
}
