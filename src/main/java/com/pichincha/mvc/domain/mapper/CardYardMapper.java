package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.CarYard;
import com.pichincha.mvc.domain.dto.CarYardDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CardYardMapper {

    public abstract CarYard toCardYard(CarYardDto carYardDto);

    public abstract List<CarYardDto> toCarYardDtoList(List<CarYard> carYards);

    public abstract CarYardDto toCarYardDto(CarYard carYard);
}
