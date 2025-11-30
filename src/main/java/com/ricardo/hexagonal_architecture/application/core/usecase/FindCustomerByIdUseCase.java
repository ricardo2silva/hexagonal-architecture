package com.ricardo.hexagonal_architecture.application.core.usecase;

import com.ricardo.hexagonal_architecture.application.core.domain.Customer;
import com.ricardo.hexagonal_architecture.application.core.exceptions.CustomerNotFoundException;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort){
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer findById(String id) {
        return findCustomerByIdOutputPort.findById(id).orElseThrow(()-> new CustomerNotFoundException("customer not found"));
    }
}
