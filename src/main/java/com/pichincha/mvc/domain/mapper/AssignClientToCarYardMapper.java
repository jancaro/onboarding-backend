package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.AssignClientToCarYard;
import com.pichincha.mvc.domain.dto.AssignClientToCarYardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AssignClientToCarYardMapper {

    public abstract AssignClientToCarYardDto assignClientToCarYardDto(AssignClientToCarYard assignClientToCarYard);

    public abstract AssignClientToCarYard assignClientToCarYard(AssignClientToCarYardDto assignClientToCarYardDto);
}
