package com.ricardo.hexagonal_architecture.application.core.usecase;

import com.ricardo.hexagonal_architecture.application.core.exceptions.CustomerNotFoundException;
import com.ricardo.hexagonal_architecture.application.ports.in.DeleteCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.DeleteCustomerOutputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort,FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        var customer = findCustomerByIdOutputPort.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer not found"));
        deleteCustomerOutputPort.delete(customer.getId());
    }
}
