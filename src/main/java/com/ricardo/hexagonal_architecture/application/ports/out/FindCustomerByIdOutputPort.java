package com.ricardo.hexagonal_architecture.application.ports.out;

import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);
}
