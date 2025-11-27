package com.ricardo.hexagonal_architecture.application.ports.out;

import com.ricardo.hexagonal_architecture.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipcode);
}
