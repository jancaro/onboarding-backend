package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.Vehicle;
import com.pichincha.mvc.domain.dto.VehicleDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class VehicleMapper {

    public abstract Vehicle toVehicle(VehicleDto vehicleDto);

    public abstract VehicleDto toVehicleDto(Vehicle vehicle);

    public abstract List<VehicleDto> toVehicleDtoList(List<Vehicle> vehicles);
}
