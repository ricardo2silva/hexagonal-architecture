package com.ricardo.hexagonal_architecture.adapters.out;

import com.ricardo.hexagonal_architecture.adapters.out.client.FindAddressByZipCodeClient;
import com.ricardo.hexagonal_architecture.adapters.out.client.mapper.AddressResponseMapper;
import com.ricardo.hexagonal_architecture.application.core.domain.Address;
import com.ricardo.hexagonal_architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipcode) {
        var addressResponse = findAddressByZipCodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
