package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.CreditRequest;
import com.pichincha.mvc.domain.dto.CreditRequestDto;
import com.pichincha.mvc.domain.enums.CreditStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class CreditRequestMapper {

    @Mapping(target = "creditStatus", source = "creditStatus", qualifiedByName = "creditStatusEnum")
    public abstract CreditRequestDto toCreditRequestDto(CreditRequest creditRequest);

    public abstract CreditRequest toCreditRequest(CreditRequestDto creditRequestDto);

    @Named("creditStatusEnum")
    protected CreditStatus creditStatusEnum(String creditStatus) { return CreditStatus.valueOf(creditStatus);};
}
