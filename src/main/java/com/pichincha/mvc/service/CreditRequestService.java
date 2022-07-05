package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.CreditRequest;
import com.pichincha.mvc.domain.dto.CreditRequestDto;

public interface CreditRequestService {

    CreditRequestDto saveCredit(CreditRequestDto creditRequestDto);

    CreditRequestDto getCredit(Long id);
}
