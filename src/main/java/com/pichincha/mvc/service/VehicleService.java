package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.dto.VehicleDto;

import java.util.List;
import java.util.Map;

public interface VehicleService {

    VehicleDto saveVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    VehicleDto getVehicleById(Long id);

    Map<String, Object> deleteVehicleById(Long id);

    List<VehicleDto> getAllVehicles();
}
