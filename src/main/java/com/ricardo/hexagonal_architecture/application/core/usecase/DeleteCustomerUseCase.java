package com.ricardo.hexagonal_architecture.application.core.usecase;

import com.ricardo.hexagonal_architecture.application.ports.in.DeleteCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }

    @Override
    public void delete(String id) {
        deleteCustomerOutputPort.delete(id);
    }
}
