package com.ricardo.hexagonal_architecture.adapters.out.client.mapper;

import com.ricardo.hexagonal_architecture.adapters.out.client.response.ViaCepResponse;
import com.ricardo.hexagonal_architecture.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {


    @Mapping(source = "logradouro", target = "street")
    @Mapping(source = "localidade", target = "city")
    @Mapping(source = "uf", target = "state")
    Address toAddress(ViaCepResponse viaCepResponse);

}
