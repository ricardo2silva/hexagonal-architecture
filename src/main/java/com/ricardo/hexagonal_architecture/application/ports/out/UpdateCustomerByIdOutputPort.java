package com.ricardo.hexagonal_architecture.application.ports.out;

import com.ricardo.hexagonal_architecture.adapters.out.repositories.entities.CustomerEntity;
import com.ricardo.hexagonal_architecture.application.core.domain.Customer;

public interface UpdateCustomerByIdOutputPort {
     CustomerEntity update(Customer costumer);
}
