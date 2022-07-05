package com.pichincha.mvc.domain.mapper;

import com.pichincha.mvc.domain.Client;
import com.pichincha.mvc.domain.dto.ClientDto;
import com.pichincha.mvc.domain.enums.MaritalStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {


    @Mapping(target = "maritalStatus", source = "maritalStatus", qualifiedByName = "maritalStatusEnum")
    public abstract Client toClient(ClientDto clientDto);

    public abstract ClientDto toClientDto(Client client);

    public abstract List<ClientDto> toClientDtoList(List<Client> clients);

    @Named("maritalStatusEnum")
    protected MaritalStatus maritalStatusEnum(String maritalStatus) { return MaritalStatus.valueOf(maritalStatus); }
}
