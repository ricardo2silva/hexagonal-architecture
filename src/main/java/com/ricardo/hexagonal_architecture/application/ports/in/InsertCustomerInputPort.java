package com.ricardo.hexagonal_architecture.application.ports.in;

import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert (Customer customer, String zipcode);
}
