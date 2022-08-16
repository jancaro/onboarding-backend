package com.pichincha.mvc.service;

import com.pichincha.mvc.domain.CreditRequest;
import com.pichincha.mvc.domain.dto.CreditRequestDto;
import com.pichincha.mvc.domain.enums.CreditStatus;

public interface CreditRequestService {

    CreditRequestDto saveCredit(CreditRequestDto creditRequestDto);

    CreditRequestDto updateCredit(Long id, CreditStatus status);

    CreditRequestDto getCredit(Long id);
}
