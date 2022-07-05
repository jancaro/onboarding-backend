package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.dto.CarYardDto;

import java.util.List;
import java.util.Map;

public interface CarYardService {

    CarYardDto saveCarYard(CarYardDto carYardDto);

    CarYardDto updateCarYard(CarYardDto carYardDto);

    CarYardDto getCarYardById(Long carYardId);

    Map<String, Object> deleteCarYard(Long carYardId);

    List<CarYardDto> getAllCarYard();

}
