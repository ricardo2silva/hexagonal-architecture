package com.ricardo.hexagonal_architecture.application.ports.out;

import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
