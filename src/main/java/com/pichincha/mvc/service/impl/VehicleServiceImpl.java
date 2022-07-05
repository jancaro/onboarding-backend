package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.BrandCar;
import com.pichincha.mvc.domain.CarYard;
import com.pichincha.mvc.domain.Vehicle;
import com.pichincha.mvc.domain.dto.VehicleDto;
import com.pichincha.mvc.domain.mapper.VehicleMapper;
import com.pichincha.mvc.exceptions.TransactionNotFoundException;
import com.pichincha.mvc.repository.BrandCarRepository;
import com.pichincha.mvc.repository.CarYardRepository;
import com.pichincha.mvc.repository.VehicleRepository;
import com.pichincha.mvc.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    private final BrandCarRepository brandCarRepository;

    private final CarYardRepository carYardRepository;

    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, BrandCarRepository brandCarRepository, CarYardRepository carYardRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.brandCarRepository = brandCarRepository;
        this.carYardRepository = carYardRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleSaved = this.vehicleRepository.getCarByCarPlate(vehicleDto.getCarPlate());
        Optional<BrandCar> brandCar = this.brandCarRepository.findById(vehicleDto.getBrandCarId());
        Optional<CarYard> carYard = this.carYardRepository.findById(vehicleDto.getCarYardId());
        if(vehicleSaved.isEmpty()) {
            if(brandCar.isPresent() && carYard.isPresent()) {
                Vehicle vehicleGenerated = vehicleMapper.toVehicle(vehicleDto);
                vehicleGenerated.setBrandCar(brandCar.get());
                vehicleGenerated.setCarYard(carYard.get());
                Vehicle vehicle = this.vehicleRepository.save(vehicleGenerated);
                VehicleDto vehicleDtoNew = vehicleMapper.toVehicleDto(vehicle);
                vehicleDtoNew.setCarYardId(vehicle.getCarYard().getId());
                vehicleDtoNew.setBrandCarId(vehicle.getBrandCar().getId());
                return vehicleDtoNew;
            } else {
                throw new TransactionNotFoundException("No existe la marca con id "+vehicleDto.getBrandCarId()+" o el patio con id "+vehicleDto.getBrandCarId());
            }
        } else {
            throw new TransactionNotFoundException("No se puede crear porque ya existe un vehículo con placa "+vehicleDto.getCarPlate());
        }
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleSaved = this.vehicleRepository.findByIdAndCarPlate(vehicleDto.getId(), vehicleDto.getCarPlate());
        Optional<BrandCar> brandCar = this.brandCarRepository.findById(vehicleDto.getBrandCarId());
        Optional<CarYard> carYard = this.carYardRepository.findById(vehicleDto.getCarYardId());
        if(vehicleSaved.isPresent()) {
            if(brandCar.isPresent() && carYard.isPresent()) {
                Vehicle vehicleGenerated = vehicleMapper.toVehicle(vehicleDto);
                vehicleGenerated.setBrandCar(brandCar.get());
                vehicleGenerated.setCarYard(carYard.get());
                VehicleDto vehicleDtoUpdated = vehicleMapper.toVehicleDto(this.vehicleRepository.save(vehicleGenerated));
                vehicleDtoUpdated.setCarYardId(carYard.get().getId());
                vehicleDtoUpdated.setBrandCarId(brandCar.get().getId());
                return vehicleDtoUpdated;
            } else {
                throw new TransactionNotFoundException("No existe la marca de vehículo con id "+vehicleDto.getBrandCarId());
            }
        } else {
            throw new TransactionNotFoundException("No se puede actualizar porque no existe un vehículo con placa "+vehicleDto.getCarPlate()+" e id "+vehicleDto.getId());
        }
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        Optional<Vehicle> vehicleSaved = this.vehicleRepository.findById(id);
        if(vehicleSaved.isPresent()) {
            BrandCar brandCar = vehicleSaved.get().getBrandCar();
            CarYard carYard = vehicleSaved.get().getCarYard();
            VehicleDto vehicleDto = vehicleMapper.toVehicleDto(vehicleSaved.get());
            vehicleDto.setBrandCarId(brandCar.getId());
            vehicleDto.setCarYardId(carYard.getId());
            return vehicleDto;
        } else {
            throw new TransactionNotFoundException("No se encontró vehículo con id "+id);
        }
    }

    @Override
    public Map<String, Object> deleteVehicleById(Long id) {
        Optional<Vehicle> vehicleSaved = this.vehicleRepository.findById(id);
        if(vehicleSaved.isPresent()) {
            CarYard carYard = vehicleSaved.get().getCarYard();
            if(carYard == null) {
                this.vehicleRepository.deleteById(id);
                Map<String, Object> response = new HashMap<>();
                response.put("result", "Eliminado correctamente");
                return response;
            } else {
                throw new TransactionNotFoundException("No se encontró eliminar vehículo por tiene informacón asociada");
            }
        } else {
            throw new TransactionNotFoundException("No se encontró vehículo con id "+id);
        }
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return this.vehicleMapper.toVehicleDtoList(this.vehicleRepository.findAll());
    }
}
