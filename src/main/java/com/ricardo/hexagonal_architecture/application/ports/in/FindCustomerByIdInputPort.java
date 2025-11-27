package com.ricardo.hexagonal_architecture.application.ports.in;

import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findById(String id);
}
