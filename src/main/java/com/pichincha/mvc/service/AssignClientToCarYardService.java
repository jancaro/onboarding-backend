package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.AssignClientToCarYard;
import com.pichincha.mvc.domain.CarYard;
import com.pichincha.mvc.domain.Client;
import com.pichincha.mvc.domain.dto.AssignClientToCarYardDto;

import java.util.Map;

public interface AssignClientToCarYardService {

    AssignClientToCarYardDto saveAssignDto(AssignClientToCarYardDto assignClientToCarYardDto);

    void saveAssign(Client client, CarYard carYard);

    AssignClientToCarYardDto updateAssign(AssignClientToCarYardDto assignClientToCarYardDto);

    AssignClientToCarYardDto getAssign(Long clientId, Long cardYardId);

    Map<String, Object> deleteAssign(Long clientId, Long cardYardId);
}
