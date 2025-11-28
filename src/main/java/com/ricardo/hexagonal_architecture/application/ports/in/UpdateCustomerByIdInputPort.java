package com.ricardo.hexagonal_architecture.application.ports.in;

import com.ricardo.hexagonal_architecture.adapters.in.controllers.request.CustomerRequest;
import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

public interface UpdateCustomerByIdInputPort {

    Customer update(String id, CustomerRequest customerRequest);
}
