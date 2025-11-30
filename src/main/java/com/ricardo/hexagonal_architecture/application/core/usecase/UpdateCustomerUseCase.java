package com.ricardo.hexagonal_architecture.application.core.usecase;

import com.ricardo.hexagonal_architecture.adapters.in.controllers.request.CustomerRequest;
import com.ricardo.hexagonal_architecture.adapters.out.repositories.mapper.CustomerEntityMapper;
import com.ricardo.hexagonal_architecture.application.core.domain.Customer;
import com.ricardo.hexagonal_architecture.application.core.exceptions.CustomerNotFoundException;
import com.ricardo.hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;
import com.ricardo.hexagonal_architecture.application.ports.out.UpdateCustomerOutputPort;
import org.apache.logging.log4j.util.Strings;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    private final UpdateCustomerOutputPort updateCustomerByIdOutputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort,
                                 UpdateCustomerOutputPort updateCustomerByIdOutputPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 CustomerEntityMapper customerEntityMapper) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
        this.updateCustomerByIdOutputPort = updateCustomerByIdOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer update(String id, CustomerRequest customerRequest) {
        var customer = findCustomerByIdOutputPort.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer not found"));
        if(Strings.isNotBlank(customerRequest.getZipcode())) {
            var address = findAddressByZipCodeOutputPort.find(customerRequest.getZipcode());
            customer.setAddress(address);
        }

        customer.setCpf(customerRequest.getCpf());
        customer.setName(customerRequest.getName());
        var result = updateCustomerByIdOutputPort.update(customer);

        return customerEntityMapper.toCustomer(result);
    }
}
