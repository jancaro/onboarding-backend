package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.BrandCar;
import com.pichincha.mvc.domain.dto.BrandCarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class BrandCarMapper {

    public abstract BrandCar toBrandCar(BrandCarDto brandCarDto);

    public abstract BrandCarDto toBrandCarDto(BrandCar brandCar);
}
