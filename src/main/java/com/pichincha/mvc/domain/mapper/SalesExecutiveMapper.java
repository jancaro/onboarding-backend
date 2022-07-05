package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.SalesExecutive;
import com.pichincha.mvc.domain.dto.SalesExecutiveDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SalesExecutiveMapper {

    public abstract SalesExecutive toSalesExecutive(SalesExecutiveDto salesExecutiveDto);

    public abstract SalesExecutiveDto toSalesExecutiveDto(SalesExecutive salesExecutive);

    public abstract List<SalesExecutiveDto> toClientDtoList(List<SalesExecutive> salesExecutives);
}
